package AAI_data_and_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class test_jsonnode_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test2.json");
		JsonNode masterJSON = mapper.readTree(from);
		
		//System.out.println(masterJSON.get("setId").asText());
		
		ArrayNode additionalDataObjects = (ArrayNode) masterJSON.at("/additionalDataObjects");
		System.out.println(additionalDataObjects.size());
		for(int i = 0; i < additionalDataObjects.size(); i++) {
            JsonNode arrayElement = additionalDataObjects.get(i);
            System.out.println(arrayElement.get("passage").asText());
            System.out.println("neues node");
		}
		
		

	}

}
