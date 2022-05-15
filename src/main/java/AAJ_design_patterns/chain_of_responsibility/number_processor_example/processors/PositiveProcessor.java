package AAJ_design_patterns.chain_of_responsibility.number_processor_example.processors;

public class PositiveProcessor extends Processor{

	public PositiveProcessor(Processor nextProcessor) {
		super(nextProcessor);
		// TODO Auto-generated constructor stub
	}
	
	//no abstract methods to implement
	
	@Override
	public void process(AAJ_design_patterns.chain_of_responsibility.number_processor_example.request_obj.Number request) {
		if(request.getNumber() > 0) {
			System.out.println("positive processor processing: "+request.getNumber());
		}else {
			//send to next chain member, try to process there
			super.process(request);
		}
	}

}
