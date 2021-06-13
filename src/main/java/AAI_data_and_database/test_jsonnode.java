package AAI_data_and_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class test_jsonnode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test.json");
		JsonNode masterJSON = mapper.readTree(from);
		
		JsonNode nameNode = masterJSON.at("/identification");
		
		System.out.println(nameNode.get("name").asText());
		System.out.println(nameNode.get("last name").asText());
		((ObjectNode)nameNode).put("last name", "henz");
		
		System.out.println(nameNode.get("last name").asText());
		
		//((ObjectNode)nameNode).putNull("last name");
		
		((ObjectNode)masterJSON).putNull("identification");
		
		Writer fileWriter = new FileWriter("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test_output.txt");
		
		fileWriter.write(mapper.writeValueAsString(masterJSON));

		fileWriter.close();*/
		
		ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test.json");
		JsonNode masterJSON = mapper.readTree(from);
		
		//JsonNode nameNode = masterJSON.at("/findings");
		
		
		//((ObjectNode)nameNode).putNull("last name");
		
		((ObjectNode)masterJSON).putNull("findings");
		
		Writer fileWriter = new FileWriter("D:\\EZV\\Testing\\EETS\\Geschäft\\Testautomatisierung\\test_output.txt");
		
		fileWriter.write(mapper.writeValueAsString(masterJSON));

		fileWriter.close();

	}

}
