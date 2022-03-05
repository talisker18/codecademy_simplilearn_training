package AAP_xml_and_json.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/*
 * 
 * 
 * */

public class ObjectMapperJson {
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		//java object to json
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = new Car("yellow", "renault");
		objectMapper.writeValue(new File("target/car.json"), car);
		
		//output into file is {"color":"yellow","type":"renault"}
		
		//instead of writing it to file, write it to string
		String str = objectMapper.writeValueAsString(car);
		System.out.println("print json: "+str);
		
		
		//json to java object, read from string
		String json ="{\"color\":\"yellow\",\"type\":\"renault\"}";
		car = objectMapper.readValue(json, Car.class);
		
		//for this we need default constr without args
		System.out.println("print object: "+car);
		
		//json to java object, read from file
		car = objectMapper.readValue(new File("target/car.json"), Car.class);
		System.out.println("print object read from file: "+car);
		
		//json to jackson JsonNode
		JsonNode jsonNode = objectMapper.readTree(json);
		
		//get specific node
		String color = jsonNode.get("color").asText(); //jsonNode.get("color") returns new JsonNode
		System.out.println("print color: "+color);
		
		//Creating a Java List From a JSON Array String
		String jsonCarArray = 
				  "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
		System.out.println("printing java list from json array: "+listCar);
		
		//create a Car[] from json array String
		jsonCarArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		Car[] cars = objectMapper.readValue(jsonCarArray, Car[].class);
		System.out.println("printing java Car [] from json array: ");
		
		for(Car c: cars) {
			System.out.println(c);
		}
		
		System.out.println();
		
		//create java map from json string / json node
		json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Map<String, Object> map 
		  = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
		System.out.println("print java map from json node: "+map);
		
		
		
		
		/**       serialization / deserialization       */
		
		
		/*
		 * One of the greatest strengths of the Jackson library is the highly customizable serialization and deserialization process.
		 * 
		 * 
		 * */
		
		/*
		 * While converting JSON objects to Java classes, in case the JSON string has some new fields, the default process would result in an exception:
		 * 
		 * for example: String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
		 * 
		 * -> year is new field
		 * 
		 * ---> solution: use configure method
		 * */
		
		String jsonString 
		  = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		car = objectMapper.readValue(jsonString, Car.class);

		JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
		JsonNode jsonNodeYear = jsonNodeRoot.get("year");
		String year = jsonNodeYear.asText();
		System.out.println("print year from json string if field year is not defined in Car.class: "+year);
		
		
		/*
		 * create custom serializer / deserialzer
		 * 
		 * ---> in the above examples, we always use default SerDe
		 * 
		 * ---> see CustomCarSerializer.class in this file
		 * 
		 * */
		
		//Ser
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
		module.addSerializer(Car.class, new CustomCarSerializer());
		mapper.registerModule(module);
		car = new Car("yellow", "renault");
		String carJson = mapper.writeValueAsString(car);
		System.out.println("print json string using custom serializer: "+carJson);
		
		//De
		json = "{ \"car_color\" : \"Black\", \"car_brand\" : \"BMW\" }";
		mapper = new ObjectMapper();
		module = new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(Car.class, new CustomCarDeserializer());
		mapper.registerModule(module);
		car = mapper.readValue(json, Car.class);
		System.out.println("print car object after using custom deserializer: "+car);
	}

}


class Car{
	private String color;
    private String type;
    
	public Car(String color, String type) {
		super();
		this.color = color;
		this.type = type;
	}
	
	public Car() {
		
	}
	
	//if we do not declare getters and setters we will get this exception:
	
	/*Exception in thread "main" com.fasterxml.jackson.databind.exc.InvalidDefinitionException: 
	 * No serializer found for class AAP_xml_and_json.jackson.Car and no properties discovered to 
	 * create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)*/

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", type=" + type + "]";
	}
}


/**
 * custom serde class
 * 
 * */


/*
 * Custom serializers and deserializers are very useful in situations where 
 * the input or the output JSON response is different in structure than 
 * the Java class into which it must be serialized or deserialized
 * 
 * --->use case: a client needs the json not with "type":"renault" but with "car_brand":"renault"
 * */

class CustomCarSerializer extends StdSerializer<Car> {
    
    public CustomCarSerializer() {
        this(null);
    }

    public CustomCarSerializer(Class<Car> t) {
        super(t);
    }

    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
	    jsonGenerator.writeStartObject();
	    jsonGenerator.writeStringField("car_brand", car.getType()); //name of field = car_brand instead of type
	    jsonGenerator.writeEndObject();
    }
}

class CustomCarDeserializer extends StdDeserializer<Car> {
    
    public CustomCarDeserializer() {
        this(null);
    }

    public CustomCarDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Car deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        Car car = new Car();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);
        
        // try catch block
        JsonNode colorNode = node.get("car_color");
        JsonNode typeNode = node.get("car_brand");
        String color = colorNode.asText();
        String type = typeNode.asText();
        car.setColor(color);
        car.setType(type);
        return car;
    }
}