package AAU_ioc.motivation_of_ioc;

public class DemoWithIoc {
	private SomeInterface impl;
	
	//here we do not have to implement anything, so DemoWithIoc and SomeInterface are loosly coupled and independent
	public DemoWithIoc(SomeImplementationOfInterface impl) {
		this.impl = impl;
	}

}
