package AAJ_design_patterns.chain_of_responsibility.number_processor_example.processors;

public abstract class Processor {
	
	private Processor nextProcessor;
	
	public Processor (Processor nextProcessor) {
		this.nextProcessor = nextProcessor;
	}
	
	public void process(AAJ_design_patterns.chain_of_responsibility.number_processor_example.request_obj.Number request) {
		if(this.nextProcessor != null) {
			this.nextProcessor.process(request);
		}
	}

}
