package AAA_core.generics_and_wildcards.ExampleWithInheritanceAndDao;

public abstract class Employee {
	private int id;
	private String name;
	
	abstract void doSpecialStuff(String s);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
