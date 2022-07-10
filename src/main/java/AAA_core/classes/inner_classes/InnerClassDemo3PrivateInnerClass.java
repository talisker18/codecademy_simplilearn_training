package AAA_core.classes.inner_classes;

public class InnerClassDemo3PrivateInnerClass {
	
	public static void main(String[] args) {
		Bicycle b = new InnerClassDemo3PrivateInnerClass().new Bicycle("Giant");
		System.out.println(b);
		
		
	}
	
	private class Bicycle{
		
		private String brand;
		private int frameSize = 0;
		
		private Bicycle(String brand) {
			this.brand = brand;
		}

		@Override
		public String toString() {
			return "Bicycle [brand=" + brand + ", frameSize=" + frameSize + "]";
		}
		
		
	}

}
