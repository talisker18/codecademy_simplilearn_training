package ch.admin.bazg.boga.testhelper.datahelper;

import ch.admin.bazg.boga.domain.inspection_decision.InspectionDecision;
import ch.admin.bazg.boga.domain.inspection_decision.InspectionDecisionState;
import ch.admin.bazg.boga.domain.inspection_reference.ZoneState;
import ch.admin.bazg.boga.infrastructure.UrlAndCredentialCollection;
import ch.admin.bazg.boga.testhelper.Logger;
import ch.admin.bazg.boga.testhelper.domainhelper.WvsHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.sql.*;
import java.util.*;

import static ch.admin.bazg.boga.testhelper.Logger.logStep;

@Slf4j
public class DatabaseHelper {
    
    //singleton
    private static DatabaseHelper databaseHelper;

    //access these from outside via getters
    private InspecziunDatabaseHelper inspecziunDatabaseHelper;
    private BogaDatabaseHelper bogaDatabaseHelper;

    private DatabaseHelper(){
        this.inspecziunDatabaseHelper = new InspecziunDatabaseHelper();
        this.bogaDatabaseHelper = new BogaDatabaseHelper();

        //init the app connections which are private in the inner classes
        try {
            //inspecziun
            this.inspecziunDatabaseHelper.connectionInspecziunCore = 
                    DriverManager.getConnection(UrlAndCredentialCollection.getUrlForInspecziunCoreDb());
            logStep("connection to inspecziun core DB established");

            //boga
            this.bogaDatabaseHelper.connectionBogaCore = 
                    DriverManager.getConnection(UrlAndCredentialCollection.getUrlForBogaCoreDb());
            logStep("connection to boga core DB established");
            
            this.bogaDatabaseHelper.connectionBogaTelematic = 
                    DriverManager.getConnection(UrlAndCredentialCollection.getUrlForBogaTelematicDb());
            logStep("connection to boga telematic DB established");
            
            this.bogaDatabaseHelper.connectionBogaTraffic = 
                    DriverManager.getConnection(UrlAndCredentialCollection.getUrlForBogaTrafficDb());
            logStep("connection to boga traffic DB established");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseHelper getInstance(){
        if(databaseHelper == null){
            databaseHelper = new DatabaseHelper();
        }
        return databaseHelper;
    }

    public static void setDatabaseHelperToNull(){
        databaseHelper = null;
    }

    public void closeAllDbConnections(){
        try {
            //inspecziun
            this.inspecziunDatabaseHelper.connectionInspecziunCore.close();

            //boga
            this.bogaDatabaseHelper.connectionBogaCore.close();
            this.bogaDatabaseHelper.connectionBogaTelematic.close();
            this.bogaDatabaseHelper.connectionBogaTraffic.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    * getters
    *
    * */

    public InspecziunDatabaseHelper getInspecziunDatabaseHelper(){
        return this.inspecziunDatabaseHelper;
    }

    public BogaDatabaseHelper getBogaDatabaseHelper(){
        return this.bogaDatabaseHelper;
    }

    /*
    * general methods to work with database
    *
    * */

    //use this if you query only 1 table and if you want to see the log msg on line 50. Otherwise, use queryDatabase()
    public List<Map<String,Object>> queryDatabaseSingleTable(Connection connection, String query, String table){
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);

                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }

                list.add(row);
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Logger.logStep("print found data from database, table: "+table);

        for(Map<String,Object> row:list){
            log.info("printing row");
            for(Map.Entry<String,Object> entry: row.entrySet()){
                log.info("  -key: "+entry.getKey()+", value: "+entry.getValue());
            }
        }

        return list;
    }

    public List<Map<String,Object>> queryDatabase(Connection connection, String query){
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);

                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }

                list.add(row);
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Map<String,Object> row:list){
            log.info("printing row");
            for(Map.Entry<String,Object> entry: row.entrySet()){
                log.info("  -key: "+entry.getKey()+", value: "+entry.getValue());
            }
        }

        return list;
    }

    public void updateDatabase(Connection connection, String query) {
        Statement st;

        try {
            st = connection.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDataForGivenVehicleInBogaAndInspecziun(String plateValue, String plateCountry){
        Logger.logStep("deleting data boga core db");
        String queryForDatabase = "select m.vehicle_id, ref.means_of_transport_id, obj.inspection_reference_id, obj.goods_declaration_id\n" +
                "from vehicle v, means_of_transport m, inspection_reference ref, inspection_object obj, goods_declaration decl\n" +
                "where v.plate_value = '"+plateValue+"'\n" +
                "AND v.plate_country = '"+plateCountry+"'\n" +
                "AND v.id = m.vehicle_id\n" +
                "AND m.id= ref.means_of_transport_id\n" +
                "AND ref.id= obj.inspection_reference_id\n" +
                "AND decl.id= obj.goods_declaration_id\n" +
                ";";

        List<Map<String,Object>> data = queryDatabase(
                this.bogaDatabaseHelper.connectionBogaCore,
                queryForDatabase
        );

        for(int i = 0; i<data.size(); i++){
            //consider sequence of deleting data due to constraints
            queryForDatabase = "delete from inspection_object where inspection_reference_id='"+((UUID) data.get(i).get("inspection_reference_id")).toString()+"';";
            updateDatabase(this.bogaDatabaseHelper.connectionBogaCore, queryForDatabase);

            queryForDatabase = "delete from goods_declaration where id='"+((UUID) data.get(i).get("goods_declaration_id")).toString()+"';";
            updateDatabase(this.bogaDatabaseHelper.connectionBogaCore, queryForDatabase);

            queryForDatabase = "delete from inspection_reference where id='"+((UUID) data.get(i).get("inspection_reference_id")).toString()+"';";
            updateDatabase(this.bogaDatabaseHelper.connectionBogaCore, queryForDatabase);

            queryForDatabase = "delete from means_of_transport where id='"+((UUID) data.get(i).get("means_of_transport_id")).toString()+"';";
            updateDatabase(this.bogaDatabaseHelper.connectionBogaCore, queryForDatabase);

            queryForDatabase = "delete from vehicle where id='"+((UUID) data.get(i).get("vehicle_id")).toString()+"';";
            updateDatabase(this.bogaDatabaseHelper.connectionBogaCore, queryForDatabase);
        }

        Logger.logStep("deleting data inspecziun db");

        queryForDatabase = "select m.vehicle_id, ic.means_of_transport_id, obj.inspection_case_id, obj.goods_declaration_id\n" +
                "from vehicle v, means_of_transport m, inspection_case ic, inspection_object obj, goods_declaration decl\n" +
                "where v.plate_value = '"+plateValue+"'\n" +
                "AND v.plate_country = '"+plateCountry+"'\n" +
                "AND v.id = m.vehicle_id\n" +
                "AND m.id= ic.means_of_transport_id\n" +
                "AND ic.id= obj.inspection_case_id\n" +
                "AND decl.id= obj.goods_declaration_id\n" +
                ";";

        data = queryDatabase(
                this.inspecziunDatabaseHelper.connectionInspecziunCore,
                queryForDatabase
        );

        for(int i = 0; i<data.size(); i++){
            //consider sequence of deleting data due to constraints
            queryForDatabase = "delete from inspection_object where inspection_case_id='"+((UUID) data.get(i).get("inspection_case_id")).toString()+"';";
            updateDatabase(
                    this.inspecziunDatabaseHelper.connectionInspecziunCore,
                    queryForDatabase
            );

            queryForDatabase = "delete from goods_declaration where id='"+((UUID) data.get(i).get("goods_declaration_id")).toString()+"';";
            updateDatabase(
                    this.inspecziunDatabaseHelper.connectionInspecziunCore,
                    queryForDatabase
            );

            queryForDatabase = "delete from inspection_case where id='"+((UUID) data.get(i).get("inspection_case_id")).toString()+"';";
            updateDatabase(this.inspecziunDatabaseHelper.connectionInspecziunCore,
                    queryForDatabase
            );

            queryForDatabase = "delete from means_of_transport where id='"+((UUID) data.get(i).get("means_of_transport_id")).toString()+"';";
            updateDatabase(
                    this.inspecziunDatabaseHelper.connectionInspecziunCore,
                    queryForDatabase
            );

            queryForDatabase = "delete from vehicle where id='"+((UUID) data.get(i).get("vehicle_id")).toString()+"';";
            updateDatabase(
                    this.inspecziunDatabaseHelper.connectionInspecziunCore,
                    queryForDatabase
            );
        }

        //TODO: do not delete the telematics_state_machine entry in DB. This causes sometimes that tests fail because there will not be generated a new telematics_state_machine.
        //Logger.logStep("deleting data boga telematic db");

        /*queryForDatabase = "delete from telematics_state_machine where machine_id ='"+plateValue+"';";
        DatabaseHelper.updateDatabse(SetUpAndCleanUp.connectionBogaTelematic, queryForDatabase);*/
    }

    public void compareTestDataWithDatabaseDataAndDoValidations(
            List<Map<String,Object>> dataFromDatabase,
            Map<String,String> queryStringParameters
    ){

    }

    /*
    * app specific databasehelper
    *
    * */

    
    //must be public because we access methods of InspecziunDatabaseHelper from outside. so method AND class must be public
    public class InspecziunDatabaseHelper {

    	//can be private because we use this only in outer class and not outside of this java file
        private Connection connectionInspecziunCore;

        private InspecziunDatabaseHelper() {
            //prevent instantiation from outside
        }

        public void checkDBInspectionDecisionIfDecisionIsFinal(WvsHelper wvsHelper) {
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ check if decision = NO_INSPECTION and decision_state= FINAL in DB ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            //check if inspection_decision has NO_INSPECTION and FINAL state
            String sqlQuery = "select inspection_case.decision, inspection_case.decision_status " +
                    "FROM inspection_case INNER JOIN journey on inspection_case.journey_id = journey.id " +
                    "WHERE journey.journey_reference_number = '" + wvsHelper.getJourneyReferenceNumber() + "'";


            List<Map<String, Object>> result = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    sqlQuery,
                    "inspection_decision"
            );

            Assert.assertEquals(1, result.size());
            Assert.assertEquals(InspectionDecision.NO_INSPECTION.getDecision(), result.get(0).get("decision"));
            Assert.assertEquals(InspectionDecisionState.FINAL.getState(), result.get(0).get("decision_status"));
        }

        public void checkIfInspectionReferenceIsOnSelectionState(WvsHelper wvsHelper) {
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ publish motLocalisationChanged event for tracking ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String sqlQuery = "select * from inspection_reference where journey_reference_number = '" + wvsHelper.getJourneyReferenceNumber() + "'";

            List<Map<String, Object>> result = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    sqlQuery,
                    "inspection_reference"
            );

            Assert.assertEquals(1, result.size());
            Assert.assertEquals(ZoneState.SELECTION.getState(), result.get(0).get("zone"));
        }

        public String getZoneStateOfInspectionReference(WvsHelper wvsHelper) {

            String sqlQuery = "select * from inspection_reference where journey_reference_number = '" + wvsHelper.getJourneyReferenceNumber() + "'";

            List<Map<String, Object>> result = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    sqlQuery,
                    "inspection_reference"
            );

            return (String) result.get(0).get("zone");
        }

        public void checkInspecziunCoreDbAfterSendingWvsJourneyAcceptedEvent(WvsHelper wvsHelper, Map<String, Object> mapWithPrimaryKeyIds) {
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ check inspecziun db after sending WvsTransportMeansCorrelationAcceptedEvent ~~~~~~~~~~~~~~~~~~~~~~~~~~");

            //check inspecziun db, tbl vehicle
            String queryForDatabase = "select * from vehicle " +
                    "where plate_value = '" + wvsHelper.getQueryStringParameters().get("activeBorderTransportMeanIdentificationNumber").toUpperCase() + "' " +
                    "AND plate_country = '" + wvsHelper.getQueryStringParameters().get("activeBorderTransportMeanNationality") + "';";

            List<Map<String, Object>> data = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    queryForDatabase,
                    "vehicle"
            );

            //no new entry in vehicle tbl of inspecziun db when sending wvsJourney. The entry happens after receiving anpr bundle
            Assert.assertEquals(1, data.size());

            mapWithPrimaryKeyIds.put("vehicleIdInspecziun", data.get(0).get("id").toString());

            //check inspecziun db, tbl means_of_transport
            queryForDatabase = "select * from means_of_transport " +
                    "where vehicle_id = '" + mapWithPrimaryKeyIds.get("vehicleIdInspecziun") + "';";

            data = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    queryForDatabase,
                    "means_of_transport"
            );

            Assert.assertEquals(1, data.size());

            assert data.get(0).get("created_at") != null;
            assert data.get(0).get("modified_at") != null;
            assert data.get(0).get("vehicle_id") != null;

            mapWithPrimaryKeyIds.put("meansOfTransportIdInspecziun", data.get(0).get("id").toString());

            //check inspecziun db, tbl journey
            queryForDatabase = "select * from journey " +
                    "where journey_reference_number = '" + wvsHelper.getQueryStringParameters().get("journeyReferenceNumber") + "';";

            data = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    queryForDatabase,
                    "journey"
            );

            Assert.assertEquals(1, data.size());

            assert data.get(0).get("id") != null;
            assert data.get(0).get("created_at") != null;
            assert data.get(0).get("modified_at") != null;
            Assert.assertEquals(wvsHelper.getQueryStringParameters().get("journeyVersion"), data.get(0).get("journey_version").toString());
            Assert.assertEquals(wvsHelper.getQueryStringParameters().get("lrn"), data.get(0).get("trader_reference"));

            mapWithPrimaryKeyIds.put("journeyId", data.get(0).get("id").toString());

            //check inspecziun db, tbl inspection_case
            queryForDatabase = "select * from inspection_case " +
                    "where journey_id = '" + mapWithPrimaryKeyIds.get("journeyId") + "';";

            data = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    queryForDatabase,
                    "inspection_case"
            );

            Assert.assertEquals(1, data.size());

            assert data.get(0).get("id") != null;
            assert data.get(0).get("created_at") != null;
            assert data.get(0).get("modified_at") != null;
            Assert.assertEquals(mapWithPrimaryKeyIds.get("meansOfTransportIdInspecziun"), data.get(0).get("means_of_transport_id").toString());
            Assert.assertNull(data.get(0).get("station_id"));
            Assert.assertNull(data.get(0).get("user_id"));
            Assert.assertNull(data.get(0).get("activated_at"));

            mapWithPrimaryKeyIds.put("inspectionCaseId", data.get(0).get("id").toString());

            //check inspecziun db, tbl inspection_object
            //not generated anymore after sending wvs event
            queryForDatabase = "select * from inspection_object " +
                    "where inspection_case_id = '" + mapWithPrimaryKeyIds.get("inspectionCaseId") + "';";

            data = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    queryForDatabase,
                    "inspection_object"
            );

            Assert.assertEquals(0, data.size());

            //check inspecziun db, tbl goods_declaration
            queryForDatabase = "select * from goods_declaration " +
                    "where gdrn = '" + wvsHelper.getQueryStringParameters().get("goodsDeclarationReferenceNumber") + "';";

            data = queryDatabaseSingleTable(
                    this.connectionInspecziunCore,
                    queryForDatabase, "goods_declaration"
            );

            Assert.assertEquals(1, data.size());

            logStep("goods declaration id inspecziun DB after sending wvs event: " + data.get(0).get("id").toString());

            assert data.get(0).get("created_at") != null;
            assert data.get(0).get("modified_at") != null;

            //unboxing: DB returns weight as Double object
            double unboxedWeight = (Double) data.get(0).get("weight"); // TODO zurzeit wird gewicht nicht von passar mitgeteilt...wird sich wahrscheinlich später ändern, daher hier immer 0
            int weightAsInt = (int) unboxedWeight;
            assert weightAsInt == 0;

            String processDirection = null;

            if (wvsHelper.getQueryStringParameters().get("borderCrossingDirection").equals("ENTRY")) {
                processDirection = "IMPORT_CH";
            } else if (wvsHelper.getQueryStringParameters().get("borderCrossingDirection").equals("EXIT")) {
                processDirection = "EXPORT_CH";
            }

            Assert.assertEquals(processDirection, data.get(0).get("process_direction"));
            Assert.assertEquals(mapWithPrimaryKeyIds.get("journeyId"), data.get(0).get("journey_id").toString());
        }
    }

    public class BogaDatabaseHelper {
        private Connection connectionBogaCore;
        private Connection connectionBogaTelematic;
        private Connection connectionBogaTraffic;

        private BogaDatabaseHelper() {
            //prevent instantiation from outside
        }

        /*
         * boga-afv-adapter-service DB
         *
         * */

        public void checkByPlateValueIfAnprBundleExists(String plateValue){
            String sqlQuery = "select * from anpr_record where plate_value = '"+plateValue+"'";

            List<Map<String,Object>> result = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    sqlQuery,
                    "anpr_records"
            );

            Assert.assertEquals(1,result.size());
        }

        /*
         * boga-core-service DB
         *
         * */

        public void checkIfStateOfInspectionReferenceIsActivated(String journeyReferenceNumber){
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ check if the inspection reference was activated ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            final String queryForDatabase = "select * from inspection_reference " +
                    "where journey_reference_number='"+journeyReferenceNumber+"';";

            final List<Map<String,Object>> data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase,
                    "inspection_reference"
            );

            Assert.assertEquals(1,data.size());
            Assert.assertNotNull(data.get(0).get("activated_at"));
        }

        public List<Map<String,Object>> getVehicleDataFromBogaDatabase(String plateValue, String plateCountry){
            final String queryForDatabase = "select * from vehicle " +
                    "where plate_value='"+plateValue+"'" +
                    "and  plate_country='"+plateCountry+"';";

            final List<Map<String,Object>> data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase,
                    "vehicle"
            );

            if(data.size()==0){
                return null;
            }else{
                return data;
            }
        }

        public void checkBogaCoreDbAfterSendingWvsJourneyAcceptedEvent(WvsHelper wvsHelper, Map<String,Object> mapWithPrimaryKeyIds){
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ check boga db after sending WvsJourneyAcceptedEvent ~~~~~~~~~~~~~~~~~~~~~~~~~~");

            //check boga db, tbl inspection_reference
            String queryForDatabase = "select * from inspection_reference " +
                    "where journey_reference_number='"+wvsHelper.getQueryStringParameters().get("journeyReferenceNumber")+"';";

            List<Map<String,Object>> data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase, "inspection_reference"
            );

            Assert.assertEquals(1,data.size());

            Assert.assertEquals(null,data.get(0).get("activated_at"));
            Assert.assertEquals(wvsHelper.getQueryStringParameters().get("journeyVersion"),data.get(0).get("journey_version").toString());
            Assert.assertEquals(wvsHelper.getQueryStringParameters().get("lrn"),data.get(0).get("trader_reference"));
            assert data.get(0).get("created_at")!=null;
            assert data.get(0).get("means_of_transport_id")!=null;
            assert data.get(0).get("id")!=null;
            assert data.get(0).get("modified_at")!=null;

            //save ids because we need this later
            mapWithPrimaryKeyIds.put("meansOfTransportIdBoga",data.get(0).get("means_of_transport_id").toString());
            mapWithPrimaryKeyIds.put("inspectionReferenceId",data.get(0).get("id").toString());

            //check boga db, tbl means_of_transport
            queryForDatabase = "select * from means_of_transport " +
                    "where id='"+ mapWithPrimaryKeyIds.get("meansOfTransportIdBoga") +"';";

            data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase,
                    "means_of_transport"
            );

            Assert.assertEquals(1,data.size());

            assert data.get(0).get("created_at")!=null;
            assert data.get(0).get("modified_at")!=null;
            assert data.get(0).get("vehicle_id")!=null;

            //save vehicle_id because we need this later
            mapWithPrimaryKeyIds.put("vehicleIdBoga",data.get(0).get("vehicle_id").toString());

            //check boga db, tbl vehicle
            queryForDatabase = "select * from vehicle " +
                    "where id='"+ mapWithPrimaryKeyIds.get("vehicleIdBoga") +"';";

            data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase,
                    "vehicle"
            );

            Assert.assertEquals(1,data.size());

            assert data.get(0).get("created_at")!=null;
            assert data.get(0).get("modified_at")!=null;
            Assert.assertEquals(wvsHelper.getQueryStringParameters().get("activeBorderTransportMeanNationality"),data.get(0).get("plate_country"));
            Assert.assertEquals(
                    wvsHelper.getQueryStringParameters().get("activeBorderTransportMeanIdentificationNumber").toUpperCase(),
                    data.get(0).get("plate_value"));
            Assert.assertEquals(null,data.get(0).get("vehicle_class"));
            Assert.assertEquals(null,data.get(0).get("vehicle_type"));

            //check boga db, tbl inspection_object
            queryForDatabase = "select * from inspection_object " +
                    "where inspection_reference_id='"+ mapWithPrimaryKeyIds.get("inspectionReferenceId") +"';";

            data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase,
                    "inspection_object"
            );

            Assert.assertEquals(1,data.size());

            assert data.get(0).get("id")!=null;
            assert data.get(0).get("created_at")!=null;
            assert data.get(0).get("modified_at")!=null;
            assert data.get(0).get("goods_declaration_id")!=null;
            Assert.assertEquals(null,data.get(0).get("vehicle_id")); // this should be null because we created inspection_object based only on goodsDeclaration
            Assert.assertEquals(null,data.get(0).get("person_id"));

            //save goods_declaration_id because we need this later
            mapWithPrimaryKeyIds.put("goodsDeclarationIdBoga", data.get(0).get("goods_declaration_id"));

            //check boga db, tbl goods_declaration
            queryForDatabase = "select * from goods_declaration " +
                    "where id='"+ mapWithPrimaryKeyIds.get("goodsDeclarationIdBoga") +"';";

            data = queryDatabaseSingleTable(
                    this.connectionBogaCore,
                    queryForDatabase, "goods_declaration"
            );

            Assert.assertEquals(1,data.size());

            assert data.get(0).get("created_at")!=null;
            assert data.get(0).get("modified_at")!=null;
            Assert.assertEquals(wvsHelper.getQueryStringParameters().get("goodsDeclarationReferenceNumber"),data.get(0).get("gdrn"));

            //unboxing: in DB, value of 'weight' is of class Double
            double unboxed = (Double) data.get(0).get("weight"); // TODO zurzeit wird gewicht nicht von passar mitgeteilt...wird sich wahrscheinlich später ändern, daher hier immer 0
            int valueAsInt = (int) unboxed;
            assert valueAsInt==0;

            String processDirection = null;

            if(wvsHelper.getQueryStringParameters().get("borderCrossingDirection").equals("ENTRY")){
                processDirection="IMPORT_CH";
            }else if(wvsHelper.getQueryStringParameters().get("borderCrossingDirection").equals("EXIT")){
                processDirection="EXPORT_CH";
            }

            Assert.assertEquals(processDirection,data.get(0).get("process_direction"));
        }

        /*
         * boga-telematics-adapter-service DB
         *
         * */

        public List<Map<String,Object>> checkIfEndpointIsAlreadyAvailable(String endpointUri){
            log.info("\n--------------check in boga telematic db if endpoint exists already--------------\n");
            String queryForDatabse = "select *\n" +
                    "from endpoint\n" +
                    "where uri = '"+endpointUri+"'\n" +
                    ";";

            return queryDatabase(
                    this.connectionBogaTelematic,
                    queryForDatabse
            );
        }

        public void checkIfThereIsNewEntryInTblTelematicsStateMachine(String plateCountry, String plateValue){
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ check if there is new entry for vehicle in tbl telematics_state_machine ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            //check if there is a new entry in boga telematic DB, tbl telematics_state_machine
            final String queryForDatabase = "select * from telematics_state_machine " +
                    "where machine_id='"+plateCountry+"-"+plateValue+"';";

            final List<Map<String,Object>> data = queryDatabaseSingleTable(
                    this.connectionBogaTelematic,
                    queryForDatabase,
                    "telematics_state_machine"
            );

            Assert.assertEquals(1,data.size());
        }

        public void checkIfStateMachineOfVehicleInDbEqualsToExpectedState(String plateCountry, String plateValue, String expectedState){
            Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ check if there is new entry for vehicle in tbl telematics_state_machine ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            //check if there is a new entry in boga telematic DB, tbl telematics_state_machine
            final String queryForDatabase = "select * from telematics_state_machine " +
                    "where machine_id='"+plateCountry+"-"+plateValue+"';";

            final List<Map<String,Object>> data = queryDatabaseSingleTable(
                    this.connectionBogaTelematic,
                    queryForDatabase,
                    "telematics_state_machine"
            );

            Assert.assertEquals(1,data.size());

            String state = (String) data.get(0).get("state");

            Assert.assertEquals(expectedState, state);
        }
    }
}

