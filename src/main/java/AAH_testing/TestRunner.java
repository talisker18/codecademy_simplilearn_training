package AAH_testing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestRunner {
	String message = "Hello world";
	TestDemo testdemo = new TestDemo("Hello world");
	
	@Test
	public void testPrintMessage() {
		assertEquals(message, testdemo.printMessage());
	}

}
