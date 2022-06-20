package AAI_data_and_database.json_xml.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class test_jsonnode4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String entryId="";

        String exitId="";
        
        
        ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test_ transactions_set4.json");
		JsonNode masterJSON = mapper.readTree(from);

        ArrayNode transactionData = (ArrayNode) masterJSON.at("/transactions");

 

        for(int i = 0; i < transactionData.size(); i++) {

            JsonNode arrayElement = transactionData.get(i);

            JsonNode passageNode = arrayElement.at("/passage");
            JsonNode paymentMeansNode = arrayElement.at("/paymentMeans");
            ((ObjectNode)paymentMeansNode).put("pan", 99);
            
            

            if(passageNode.get("passageType").asInt()==0){

                entryId = passageNode.get("passageId").asText();

            }

            ((ObjectNode)passageNode).put("stationNumber", 99);

            if(passageNode.get("passageType").asInt()==4){

                exitId = passageNode.get("passageId").asText();

            }

 
            ((ObjectNode)passageNode).put("stationNumber", 99);
            
            ((ObjectNode)passageNode).removeAll();
            

        }
        
        System.out.println(entryId);
        
        System.out.println(exitId);
        

		
		
		/*ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test_ transactions_set4.json");
		JsonNode masterJSON = mapper.readTree(from);
		
		ArrayNode additionalDataObjects = (ArrayNode) masterJSON.at("/additionalDataObjects");
		System.out.println(additionalDataObjects.size());
		for(int i = 0; i < additionalDataObjects.size(); i++) {
            JsonNode arrayElement = additionalDataObjects.get(i);
            JsonNode passageNode = arrayElement.at("/passage");
            System.out.println(passageNode.get("passageId").asText());
            System.out.println("neues node");
		}*/
		
		

	}

}
