package AAB_inheritance_and_polymorphism.inheritance_example;

public class Mayan extends Language {

	//this constructor must be defined because parent class has defined it. if we define at least 1 constructor, there will not be a implicit constructor with constr()
	public Mayan(String name, int numSpeakers, String regionsSpoken, String wordOrder) {
		super(name, numSpeakers, regionsSpoken, wordOrder);
		// TODO Auto-generated constructor stub
	}

}
