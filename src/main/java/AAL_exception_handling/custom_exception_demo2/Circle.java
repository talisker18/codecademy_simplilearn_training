package AAL_exception_handling.custom_exception_demo2;

public class Circle {
	
	int radius;
	
	Circle(int r) throws InvalidRadiusException{
		if(r < 0) {
			throw new InvalidRadiusException(r);
		}else {
			this.radius = r;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Circle c = new Circle(-10);
		} catch (InvalidRadiusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("program not aborted because exception was caught");
		}

	}

}
