package AAA_core.generics_and_wildcards.ExampleWithInheritanceAndDao;

public class Developer extends Employee {
	String preferredProgrammingLanguage;

	@Override
	void doSpecialStuff(String s) {
		this.preferredProgrammingLanguage=s;
		
	}
	
	String getPreferredProgrammingLanguage() {
		return this.preferredProgrammingLanguage;
	}
	
	@Override
	public String toString() {
		return "id:"+super.getId()+", name: "+super.getName()+", preferred programming language: "+this.preferredProgrammingLanguage;
	}

}
