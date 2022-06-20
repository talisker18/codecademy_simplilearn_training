package ch.admin.bazg.boga.testhelper.domainhelper.boga;

import ch.admin.bazg.boga.domain.anpr_bundle.Stations;
import ch.admin.bazg.boga.infrastructure.HttpParams;
import ch.admin.bazg.boga.infrastructure.UrlAndCredentialCollection;
import ch.admin.bazg.boga.testhelper.FormatHelper;
import ch.admin.bazg.boga.testhelper.GeneralTestHelper;
import ch.admin.bazg.boga.testhelper.HttpHelper;
import ch.admin.bazg.boga.testhelper.Logger;
import ch.admin.bazg.boga.testhelper.datahelper.JsonHelper;
import ch.admin.bazg.boga.testhelper.datahelper.XmlHelper;
import ch.admin.bazg.boga.testhelper.domainhelper.WvsHelper;
import ch.admin.bazg.boga.testhelper.testrules.TestRulesBeforeAndAfterTestMethodForUi;
import ch.admin.bazg.boga.testhelper.testrules.TestRulesBeforeAndAfterTestmethodForBackend;
import ch.admin.bazg.boga.testhelper.ui.pages.BorderPanelPage;
import ch.admin.bazg.boga.testhelper.ui.util.tasks.CheckOnBorderpanelTask;
import ch.admin.bazg.boga.testhelper.ui.util.tasks.CheckOnUiTask;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.*;

import static ch.admin.bazg.boga.testhelper.HttpHelper.createNewRequestSpecWithoutQueryParamsAndSendRequest;
import static ch.admin.bazg.boga.testhelper.HttpHelper.validateHttpResponse;
import static ch.admin.bazg.boga.testhelper.Logger.logStep;

//TODO export stuff which is needed also in e2e test (into domainhelper)

@Slf4j
public final class AnprBundleHelper {
    private AnprBundleHelper(){
        //prevent instantiation
    }

    //building and exchanging data
    final static XmlHelper xmlHelper = new XmlHelper();
    public static NodeList allCountryNodes;
    private static List<String> countryCodesInAlpha3;
    public final static JsonHelper JSON_HELPER = new JsonHelper();

    //vars for unhappy and negative testing
    public final static String[] EMPTY_PLATES ={"",null};
    public final static String EMPTY_PLATE_COUNTRY ="";
    public final static String EMPTY_PLATE_COUNTRY_VALUE_FROM_DB = null;

    public static List<String> getCountryCodeListInAlpha3(){
        if(allCountryNodes==null && countryCodesInAlpha3==null){
            initCountryListsAsAlpha3();
        }

        return countryCodesInAlpha3;
    }



    public static void initCountryListsAsAlpha3(){
        if(allCountryNodes==null && countryCodesInAlpha3==null){
            logStep("List with country elements and list with country codes alpha-3 will be initialized");
            allCountryNodes = xmlHelper.getElementsByTag(
                    (Document) xmlHelper.readStringAndBuildObject(
                            xmlHelper.getFileAndReturnContentAsString("country_codes")),
                    "country");

            countryCodesInAlpha3 = xmlHelper.getValuesOfGivenXmlAttribute(
                    allCountryNodes,
                    "alpha-3");
        }
    }

    public static void initNodeListWithCountryCodes(){
        if(allCountryNodes==null){
            logStep("List with country elements be initialized");
            allCountryNodes = xmlHelper.getElementsByTag(
                    (Document) xmlHelper.readStringAndBuildObject(
                            xmlHelper.getFileAndReturnContentAsString("country_codes")),
                    "country");
        }
    }

    //use this method only if kafka records are in json format. For this we need avro deserializer first
    public static List<String> getListWithBundleIdsWhenRecordIsJson(List<ConsumerRecord<String,String>> kafkaRecords){
        //build list with bundle ids
        List <String> listWithBundleIds = new ArrayList<>();

        JsonHelper jsonHelper = new JsonHelper();

        for(ConsumerRecord<String,String> record: kafkaRecords){
            JSONObject jsonObject = (JSONObject) jsonHelper.readStringAndBuildObject(record.value());
            listWithBundleIds.add((String) jsonObject.get("bundleId"));
        }

        return listWithBundleIds;
    }

    //use this method only if kafka records are in string format
    public static List<String> extractBundleIdsFromListWithKafkaRecords(List<ConsumerRecord<String,String>> kafkaRecords){
        //build list with bundle ids
        List <String> listWithBundleIds = new ArrayList<>();

        for(ConsumerRecord<String,String> record: kafkaRecords){
            String value = record.value();
            //split by newline
            String lines[] = value.split("\\r?\\n");

            //next, split by "/"
            lines = lines[1].split("/");

            //bundleId is in second index
            log.info("BundleId is: "+lines[1]);

            listWithBundleIds.add(lines[1]);
        }

        return listWithBundleIds;
    }

    public static void sendAnprBundle(
            WvsHelper wvsHelper,
            long milliSecondsToWaitAfterSending,
            boolean checkOnUi
    ) throws IOException {
        Logger.logStep("~~~~~~~~~~~~~~~~~~~~~~~~~~ send anpr bundle ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //send anpr bundle
        //set URL of needed service as baseURI for each HTTP request
        RestAssured.baseURI = UrlAndCredentialCollection.bogaAfvAdapterService;

        final JSONObject anprBundleContent = (JSONObject) AnprBundleHelper.JSON_HELPER.readStringAndBuildObject(
                AnprBundleHelper.JSON_HELPER.getFileAndReturnContentAsString("anpr_bundles/french_vehicles/AT554BZ.json")
        );

        //substitute values
        anprBundleContent.put("plate",wvsHelper.getPlateValue());
        anprBundleContent.put("plateCountry",wvsHelper.getPlateCountryInAlpha3());

        final String timeStampForBundle = FormatHelper.getTimestampOfNowAsStringAndAddSeconds(60);

        anprBundleContent.put("timestamp",timeStampForBundle);

        final String bodyForHttpRequest = anprBundleContent.toString();

        final Map<String,String> headers = new HashMap<>();
        headers.put(
                HttpParams.HttpHeaders.STATION_ID.getHeaderFieldName(),
                Stations.THC.getStationId()
        );

        final Response resp = createNewRequestSpecWithoutQueryParamsAndSendRequest(
                TestRulesBeforeAndAfterTestmethodForBackend.getAccessTokenBogaAfvAdapter(),
                bodyForHttpRequest,
                headers,
                Method.POST,
                UrlAndCredentialCollection.EndpointsBorderGuardAfvAdapter.SEND_ANPR_BUNDLE.getEndpointPath()
        );

        validateHttpResponse(resp, HttpHelper.HttpStatusCode.OK.getHttpStatusCode(),HttpHelper.HttpStatusLine.OK.getHttpStatusLine());

        if(checkOnUi){
            //check on UI
            Timer timer = new Timer();
            CheckOnBorderpanelTask task = new CheckOnBorderpanelTask(10000,timer,TestRulesBeforeAndAfterTestMethodForUi.borderPanelPage);
            task.createAndSetCheckUiFieldsForHappyCase(1,0,wvsHelper);
            timer.schedule(task,0,500); //exec run() method every 500ms

            while(!task.isDone()){
                //wait for task to be finished, then move on
            }

            Assert.assertTrue(task.isUiTestSuccessful());
        }

        //we have to wait until the traffic control light has switched back to green/red and the decision is final
        GeneralTestHelper.waitForSpecifiedTimeInMillis(milliSecondsToWaitAfterSending);
    }


    /**
     * database checking methods. The methods use the the REST Database API of boga-core-service
     * instead of querying database directly
     * */

    public static void checkViaRestApiIfAnprBundleDataWasSavedCorrectly(Map<String,Object> testDataParameter, String accessToken){
        logStep("starting validation of database entry");

        RestAssured.baseURI = UrlAndCredentialCollection.bogaCoreService;

        String testDataPlateCountry="";
        String testDataBundleId="";
        String testDataPlate="";
        String testDataTimestamp="";
        int testDataOcrScore=0;
        String testDataOcrStatus="";

        for (Map.Entry<String,Object> entry : testDataParameter.entrySet()){
            switch(entry.getKey()){
                case "plateCountry":
                    testDataPlateCountry= (String) entry.getValue();
                    break;
                case "bundleId":
                    testDataBundleId= (String) entry.getValue();
                    break;
                case "plate":
                    testDataPlate= (String) entry.getValue();
                    break;
                case "timestamp":
                    testDataTimestamp= (String) entry.getValue();
                    break;
                case "ocrScore":
                    testDataOcrScore= (int) entry.getValue();
                    break;
                case "ocrStatus":
                    testDataOcrStatus=(String) entry.getValue();
            }
        }

        log.info("\n"+"///////////////Validation for following testdata set///////////////"+"\n");
        log.info("plateCountry: "+testDataPlateCountry);
        log.info("bundleId: "+testDataBundleId);
        log.info("plate: "+testDataPlate);
        log.info("timestamp: "+testDataTimestamp);
        log.info("ocrScore: "+testDataOcrScore);
        log.info("ocrStatus: "+testDataOcrStatus);

        log.info("~~~~~~~~~~~~~\ntry to get database entry for this dataset, with bundleId "+testDataBundleId+"\n");
        log.info("make http request to database API of Boga Core Service\n");

        String endpoint = UrlAndCredentialCollection.EndpointsBorderGuardCore.FIND_ANPR_BUNDLE.getEndpointPath();

        endpoint = String.format(endpoint,testDataBundleId);

        log.info("call to endpoint "+endpoint);

        //get access token for boga core service and send request
        Response resp= createNewRequestSpecWithoutQueryParamsAndSendRequest(
                accessToken,
                null,
                null,
                Method.GET,
                endpoint
        );

        validateHttpResponse(resp, HttpHelper.HttpStatusCode.OK.getHttpStatusCode(), HttpHelper.HttpStatusLine.OK.getHttpStatusLine());

        log.info("following data from database found:");
        log.info("  "+resp.asString()+"\n");
        log.info("validate country code:");
        log.info("  -plateCountry of testdata = "+testDataPlateCountry);
        //get alpha2 code of this alpha3 code. Get plateCountry saved in database and compare the values
        Element element = AnprBundleHelper.xmlHelper.getSingleXmlElementFromNodeListContainingSpecificValueOfGivenAttribute(
                AnprBundleHelper.allCountryNodes,
                "alpha-3",
                testDataPlateCountry
        );

        String correctAlpha2Code = element.getAttribute("alpha-2");

        JsonHelper jsonHelper = new JsonHelper();
        //data for this anpr records saved in database, returned as json
        JSONObject dataFromDatabaseAsJsonObj = (JSONObject) jsonHelper.readStringAndBuildObject(resp.asString());
        String plateCountryInDatabase = (String) dataFromDatabaseAsJsonObj.get("plateCountry");
        log.info("  -alpha2 code for "+testDataPlateCountry+" is "+correctAlpha2Code+" and should be equal to saved plateCountry = "+plateCountryInDatabase);
        log.info("\n");
        Assert.assertEquals(correctAlpha2Code, plateCountryInDatabase);

        log.info("validate plate value:");
        log.info("  -plate of testdata = "+testDataPlate);
        String plateValueInDatabase = (String) dataFromDatabaseAsJsonObj.get("plateValue");
        log.info("  -plate of testdata is "+testDataPlate+" and should be equal to saved plate = "+plateValueInDatabase);
        log.info("\n");

        //plate value is saved as String with capitalized letters
        testDataPlate = testDataPlate.toUpperCase();
        Assert.assertEquals(testDataPlate, plateValueInDatabase);

        log.info("validate ocrScore:");
        log.info("  -ocrScore of testdata = "+testDataOcrScore);
        long ocrScoreFromDatabase = (long) dataFromDatabaseAsJsonObj.get("ocrScore");
        log.info("  -ocrScore of testdata is "+testDataOcrScore+" and should be equal to saved ocrScore = "+ocrScoreFromDatabase);
        log.info("\n");
        Assert.assertEquals(testDataOcrScore, ocrScoreFromDatabase);

        log.info("validate ocrStatus:");
        log.info("  -if ocrStatus of testdata = READ, value should be saved as 'OK' in database");
        log.info("  -ocrStatus of testdata = "+testDataOcrStatus);
        String ocrStatusFromDatabase = (String) dataFromDatabaseAsJsonObj.get("ocrStatus");
        log.info("  -ocrStatus of database = "+ocrStatusFromDatabase);
        log.info("\n");
        boolean testDataAndSavedDataCorrelate=false;
        if(testDataOcrStatus.equals("READ") && ocrStatusFromDatabase.equals("OK")){
            testDataAndSavedDataCorrelate = true;
        }
        Assert.assertTrue(testDataAndSavedDataCorrelate);

        log.info("validate timestamp:");
        log.info("  -timestamp of testdata = "+testDataTimestamp);
        String timestampFromDatabase = (String) dataFromDatabaseAsJsonObj.get("cameraTimestamp");
        log.info("  -timestamp of database = "+timestampFromDatabase);
        log.info("\n");
        Assert.assertEquals(testDataTimestamp, timestampFromDatabase);
    }

    public static void checkOnlyByBundleIdIfAnprBundleWasSaved(String bundleId){
        RestAssured.baseURI = UrlAndCredentialCollection.bogaCoreService;

        final String uri = String.format(
                UrlAndCredentialCollection.EndpointsBorderGuardCore.FIND_ANPR_BUNDLE.getEndpointPath(),
                bundleId
        );

        Response resp= createNewRequestSpecWithoutQueryParamsAndSendRequest(
                TestRulesBeforeAndAfterTestmethodForBackend.getAccessTokenBogaCore(),
                null,
                null,
                Method.GET,
                uri
        );
        validateHttpResponse(resp,
                HttpHelper.HttpStatusCode.OK.getHttpStatusCode(),
                HttpHelper.HttpStatusLine.OK.getHttpStatusLine()
        );

    }

    public static void checkDatabaseForPredefinedBundlesUnhappyPath(Map<String,Object> testDataParameter){
        logStep("starting validation of database entries");

        RestAssured.baseURI = UrlAndCredentialCollection.bogaCoreService;

        String testDataPlateCountry="";
        String testDataBundleId="";
        String testDataPlate="";
        String testDataTimestamp="";
        int testDataOcrScore=0;
        String testDataOcrStatus="";

        for (Map.Entry<String,Object> entry : testDataParameter.entrySet()){
            switch(entry.getKey()){
                case "plateCountry":
                    testDataPlateCountry= (String) entry.getValue();
                    break;
                case "bundleId":
                    testDataBundleId= (String) entry.getValue();
                    break;
                case "plate":
                    testDataPlate= (String) entry.getValue();
                    break;
                case "timestamp":
                    testDataTimestamp= (String) entry.getValue();
                    break;
                case "ocrScore":
                    testDataOcrScore= (int) entry.getValue();
                    break;
                case "ocrStatus":
                    testDataOcrStatus=(String) entry.getValue();
            }
        }

        log.info("\n"+"///////////////Validation for following testdata set///////////////"+"\n");
        log.info("plateCountry: "+testDataPlateCountry);
        log.info("bundleId: "+testDataBundleId);
        log.info("plate: "+testDataPlate);
        log.info("timestamp: "+testDataTimestamp);
        log.info("ocrScore: "+testDataOcrScore);
        log.info("ocrStatus: "+testDataOcrStatus);

        log.info("~~~~~~~~~~~~~\ntry to get database entry for this dataset, with bundleId "+testDataBundleId+"\n");
        log.info("make http request to database API of Boga Core Service\n");

        String endpoint = UrlAndCredentialCollection.EndpointsBorderGuardCore.FIND_ANPR_BUNDLE.getEndpointPath();

        endpoint = String.format(endpoint,testDataBundleId);

        //get access token for boga core service and send request
        Response resp= createNewRequestSpecWithoutQueryParamsAndSendRequest(
                TestRulesBeforeAndAfterTestmethodForBackend.getAccessTokenBogaCore(),
                null,
                null,
                Method.GET,
                endpoint
        );

        validateHttpResponse(resp, HttpHelper.HttpStatusCode.NOT_FOUND.getHttpStatusCode(), HttpHelper.HttpStatusLine.NOT_FOUND.getHttpStatusLine());

        log.info("following data from database found:");
        log.info("  "+resp.asString()+"\n");
        log.info("validate country code:");
        log.info("  -plateCountry of testdata = "+testDataPlateCountry);

        JSONObject dataFromDatabaseAsJsonObj = (JSONObject) AnprBundleHelper.JSON_HELPER.readStringAndBuildObject(resp.asString());
        String plateCountryInDatabase = (String) dataFromDatabaseAsJsonObj.get("plateCountry");
        log.info("  -alpha2 code for empty plateCountry in database is " +
                ""+ EMPTY_PLATE_COUNTRY_VALUE_FROM_DB+" and should be equal " +
                "to saved plateCountry = "+plateCountryInDatabase);

        Assert.assertEquals(EMPTY_PLATE_COUNTRY_VALUE_FROM_DB, plateCountryInDatabase);
        log.info("\n");

        log.info("validate plate value:");
        log.info("  -plate of testdata = "+testDataPlate);
        String plateValueInDatabase = (String) dataFromDatabaseAsJsonObj.get("plateValue");
        log.info("  -plate of data in database = "+plateValueInDatabase);
        boolean plateIsOk = false;

        if(testDataPlate==null && plateValueInDatabase.equals("")){
            plateIsOk = true;
        }else if(testDataPlate.isEmpty() && plateValueInDatabase.equals("")){
            plateIsOk = true;
        }

        log.info("\n");
        Assert.assertTrue(plateIsOk);

        log.info("validate ocrScore:");
        log.info("  -ocrScore of testdata = "+testDataOcrScore);
        long ocrScoreFromDatabase = (long) dataFromDatabaseAsJsonObj.get("ocrScore");
        log.info("  -ocrScore of testdata is "+testDataOcrScore+" and should be equal to saved ocrScore = "+ocrScoreFromDatabase);
        log.info("\n");
        Assert.assertEquals(testDataOcrScore, ocrScoreFromDatabase);

        log.info("validate ocrStatus:");
        log.info("  -ocrStatus of testdata = "+testDataOcrStatus);
        String ocrStatusFromDatabase = (String) dataFromDatabaseAsJsonObj.get("ocrStatus");
        log.info("  -ocrStatus of database = "+ocrStatusFromDatabase);
        log.info("\n");
        Assert.assertEquals(testDataOcrStatus, ocrStatusFromDatabase);

        log.info("validate timestamp:");
        log.info("  -timestamp of testdata = "+testDataTimestamp);
        String timestampFromDatabase = (String) dataFromDatabaseAsJsonObj.get("cameraTimestamp");
        log.info("  -timestamp of database = "+timestampFromDatabase);
        log.info("\n");
        Assert.assertEquals(testDataTimestamp, timestampFromDatabase);
    }

    public static void checkDatabaseForNegativeTests(List<String> recordsOfTopicReceived, String accessTokenBogaCore){
        logStep("starting validation of database entry");

        RestAssured.baseURI = UrlAndCredentialCollection.bogaCoreService;

        for(String bundleId: recordsOfTopicReceived){
            String endpoint = UrlAndCredentialCollection.EndpointsBorderGuardCore.FIND_ANPR_BUNDLE.getEndpointPath();
            endpoint = String.format(endpoint,bundleId);

            log.info("~~~~~~~~~~~~~\ntry to get database entry for this dataset, with bundleId "+bundleId+". There should not be an entry"+"\n");
            log.info("make http request to database API of Boga Core Service\n");

            //get access token for boga core service and send request
            Response resp= createNewRequestSpecWithoutQueryParamsAndSendRequest(
                    accessTokenBogaCore,
                    null,
                    null,
                    Method.GET,
                    endpoint
            );

            validateHttpResponse(
                    resp,
                    HttpHelper.HttpStatusCode.NOT_FOUND.getHttpStatusCode(),
                    HttpHelper.HttpStatusLine.NOT_FOUND.getHttpStatusLine()
            );
        }
    }
}

