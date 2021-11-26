package AAL_exception_handling.custom_exception_demo;

class CheckAgeException extends Exception{
	
	//2 different constr, which call the super constructor of Exception class
	
	public CheckAgeException() {
		super("invalid age to vote");
	}
	
	public CheckAgeException(String message) {
		super(message);
	}
}

class VotingSystem2{
	static void validate(int age) throws CheckAgeException {
		
		if(age < 18) {
			throw new CheckAgeException("exception message: you are not allowed to vote"); //custom exception: this is called with e.getMessage()
		}else {
			System.out.println("you are valid to vote");
		}
		
	}
}

public class CustomException {
	
	public static void main(String[] args) {
		try {
			VotingSystem2.validate(12);
		}catch(CheckAgeException e) {
			System.out.println(e.getMessage());
		}
	}

}
