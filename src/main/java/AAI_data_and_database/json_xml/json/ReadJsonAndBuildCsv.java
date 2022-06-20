package AAI_data_and_database.json_xml.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ReadJsonAndBuildCsv {
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		File from = new File("D:\\EZV\\Testing\\EETS\\Geschäft\\geojson\\Ausfahrt_FR_MILANO.json");
		JsonNode masterJSON = mapper.readTree(from);
		
		ArrayNode features = (ArrayNode) masterJSON.at("/features");
		
		JsonNode geometry = features.get(0).at("/geometry");
		ArrayNode coordinates = (ArrayNode) geometry.at("/coordinates"); 
		
		FileWriter myWriter = new FileWriter("D:\\EZV\\Testing\\EETS\\Geschäft\\geojson\\output_coordinates_ausfahrt.csv");
	    myWriter.write("hardwareSN;ObuID;ContractProviderID;VehicleAxlesTyreType;VehicleAxlesTractor;VehicleAxlesTrailer;GpsTimeUTC;ProxyPackageID;RecordID;Latitude;Longitude;InstantaneousSpeed;Course;Distance;HorAcc;SatelliteMask;Type\n");
	    
	    LocalDateTime myDateObj = LocalDateTime.of(2020, 01, 03, 8, 0);
		
		for (int i=0;i<coordinates.size();i++) {
			ArrayNode element = (ArrayNode) coordinates.get(i);
			
			myWriter.write("3.04201E+14;420086183;10747906;0;2;1;");
			
			myDateObj=myDateObj.plusSeconds(10);
		    System.out.println("Before formatting: " + myDateObj);
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

		    String formattedDate = myDateObj.format(myFormatObj);
		    System.out.println("After formatting: " + formattedDate);
		    myWriter.write(formattedDate+";;;");
		   
			

				
			myWriter.write(element.get(1).asText()+";"+element.get(0).asText()+";0;0;0;0;0;0");

			myWriter.write("\n");
		}
		
		myWriter.close();

	}

}
