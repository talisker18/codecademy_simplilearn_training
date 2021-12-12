package AAD_java8.streams;

import java.util.stream.Stream;

public enum StreamOfEnumValuesDemo {
	
	LOW("low"),
	MEDIUM("medium"),
	HIGH("high");
	
	private String prio;

	StreamOfEnumValuesDemo(String prio) {
		// TODO Auto-generated constructor stub
		this.prio = prio;
		
	}
	
	public static Stream<StreamOfEnumValuesDemo> stream() {

        return Stream.of(StreamOfEnumValuesDemo.values());

    }
	
	public String getPrio() {
		return this.prio;
	}
	
}
