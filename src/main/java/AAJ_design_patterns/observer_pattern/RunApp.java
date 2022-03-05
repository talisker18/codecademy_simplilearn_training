package AAJ_design_patterns.observer_pattern;

public class RunApp {

	public static void main(String[] args) {
		
		//track every change on this subject
		Subject subject = new Subject();

	      new HexaObserver(subject);
	      new BinaryObserver(subject);
	
	      System.out.println("First state change: 15");	
	      subject.setState(15);
	      System.out.println("Second state change: 10");	
	      subject.setState(10);
	}
}
