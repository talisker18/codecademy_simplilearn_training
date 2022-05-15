package AAJ_design_patterns.chain_of_responsibility.number_processor_example;

import AAJ_design_patterns.chain_of_responsibility.number_processor_example.processors.Chain;
import AAJ_design_patterns.chain_of_responsibility.number_processor_example.request_obj.Number;

public class App {
	
	public static void main(String[] args) {
		Chain chain = new Chain();
		
		Number request1 = new Number(-5);		
		chain.process(request1);
		
		Number request2 = new Number(0);		
		chain.process(request2);
		
		Number request3 = new Number(15);		
		chain.process(request3);
	}

}
