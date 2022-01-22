package AAA_core.classpath_demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * CLASSPATH is an environment variable which is used by Application ClassLoader to locate and load the .class files. 
 * The CLASSPATH defines the path, to find third-party and user-defined classes that are not extensions or part of Java platform. 
 * Include all the directories which contain .class files and JAR files when setting the CLASSPATH.
 * 
 * 
 * comment by me: e.g. CLASSPATH is needed to load a compiled resource into a fileread, for example a application.properties file has to be read
 * in some part of my java program
 * 
 * */

public class ClassPathDemo {
	
	public ClassPathDemo() throws IOException {
		Properties props = new Properties();
		///FlyAway/target/FlyAway/WEB-INF/classes/application.properties
		InputStream  in = getClass().getClassLoader().getResourceAsStream("application.properties");
		props.load(in);
		in.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(System.getProperty("java.class.path")); //C:\Users\chgix\eclipse-workspace-main\codecademy_simplilearn_training\target\classes
		//--> in target/classes there are all compiled resources

		ClassPathDemo c = new ClassPathDemo();
		
		//to get this program run and load the file application.properties, we first have to compile it
		//--> mvn clean install
		//--> then in folder /codecademy_simplilearn_training/target/classes we would find the compiled file application.properties
		//--> this compiled file we would load into InputStream on line 24
	}

}
