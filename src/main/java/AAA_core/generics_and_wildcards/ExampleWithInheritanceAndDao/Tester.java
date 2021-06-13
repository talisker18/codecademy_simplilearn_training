package AAA_core.generics_and_wildcards.ExampleWithInheritanceAndDao;

public class Tester extends Employee {
	String preferredTestingMethod;
	
	@Override
	void doSpecialStuff(String s) {
		this.preferredTestingMethod=s;
	}
	
	String getPreferredTestingMethod() {
		return this.preferredTestingMethod;
	}
	
	@Override
	public String toString() {
		return "id:"+super.getId()+", name: "+super.getName()+", preferred testing method: "+this.preferredTestingMethod;
	}

}
