package AAJ_design_patterns.chain_of_responsibility.number_processor_example.processors;

public class ZeroProcessor extends Processor{

	public ZeroProcessor(Processor nextProcessor) {
		super(nextProcessor);
	}
	
	//no abstract methods to implement
	
	@Override
	public void process(AAJ_design_patterns.chain_of_responsibility.number_processor_example.request_obj.Number request) {
		if(request.getNumber() == 0) {
			System.out.println("zero processor processing: "+request.getNumber());
		}else {
			//send to next chain member, try to process there
			super.process(request);
		}
	}

}
