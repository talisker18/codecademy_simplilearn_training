package AAJ_design_patterns.observer_pattern;

public class BinaryObserver extends Observer{

	   public BinaryObserver(Subject subject){
	      super.subject = subject;
	      super.subject.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
	   }
}
