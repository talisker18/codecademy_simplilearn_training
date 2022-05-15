package AAJ_design_patterns.chain_of_responsibility.number_processor_example.processors;

public class Chain {

	Processor chain; //the last processor in the chain contains all other processors. in this case its the negative processor
	
	public Chain() {
		buildChain();
	}
	
	
	//so with each request, we first check if it is a negative number, then check if 0 and last check if positive
	private void buildChain() {
		this.chain = new NegativeProcessor(
				new ZeroProcessor(
						new PositiveProcessor(null)
						)
				);
	}
	
	//if we call process method of Chain, we always start checking if request is negative number because this.chain is instance of NegativeProcessor
	public void process (AAJ_design_patterns.chain_of_responsibility.number_processor_example.request_obj.Number request) {
		this.chain.process(request);
	}
}
