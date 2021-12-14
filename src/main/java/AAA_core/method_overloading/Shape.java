package AAA_core.method_overloading;

public class Shape {

	//overloading methods
	
	//area for circles
	public double findArea(double radius) {
		return (Math.pow(radius, 2)) * 3.1415926;
	}
	
	//area for square
	public float findArea(float side) {
		return side*side;
	}
	
	//area for rectangle
	public double findArea(double length, double width) {
		return length * width;
	}
	
	
}
