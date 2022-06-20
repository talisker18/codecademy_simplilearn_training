package AAI_data_and_database.json_xml.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class test_jsonnode3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\FT_002_EETS - additional_set4.json");
		JsonNode masterJSON = mapper.readTree(from);
		
		ArrayNode additionalDataObjects = (ArrayNode) masterJSON.at("/additionalDataObjects");
		System.out.println(additionalDataObjects.size());
		for(int i = 0; i < additionalDataObjects.size(); i++) {
            JsonNode arrayElement = additionalDataObjects.get(i);
            JsonNode passageNode = arrayElement.at("/passage");
            System.out.println(passageNode.get("passageId").asText());
            System.out.println("neues node");
            
            if(passageNode.isNull()) {
            	System.out.println("null node");
            }
            
		}
		
		

	}

}
