package AAL_exception_handling.example_throw_keyword;

//see also exception handling with Callable: src/main/java/AAG_threads/callable/CallableExample.java

class VotingSystem{
	static void validate(int age) throws ArithmeticException{
		
		if(age < 18) {
			throw new ArithmeticException("exception message: you are not allowed to vote"); //custom exception: this is called with e.getMessage()
		}else {
			System.out.println("you are valid to vote");
		}
		
	}
}

public class ExampleThrowKeyWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {
			VotingSystem.validate(12);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}*/
		
		//instead of try catch, we can use throws Exception in method signature. but here, we cant catch the exception!!!
		VotingSystem.validate(12);
	}

}
