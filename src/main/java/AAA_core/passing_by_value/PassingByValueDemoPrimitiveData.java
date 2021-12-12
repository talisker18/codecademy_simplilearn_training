package AAA_core.passing_by_value;

public class PassingByValueDemoPrimitiveData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int originalInt = 15;
		
		PassingByValueDemoPrimitiveData obj = new PassingByValueDemoPrimitiveData();

		obj.changeInt(originalInt); //originalInt remains unchanged because primitive data types are copied when passed as argument
		System.out.println(originalInt);
	}
	
	
	void changeInt(int copyOfa) { //a copy of originalInt is made
		copyOfa = 10; //changes on primitive data types only affects the local copy in the method scope
	}

}
