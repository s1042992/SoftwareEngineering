package CC;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.*;
import org.junit.jupiter.api.Test;


class RocketControllerTest  {

	RocketControllerMock mytest = null;
	ILogger logger;
	
	@Before
	void BeforeTest() {
		mytest = new RocketControllerMock();
	}
	
	
	@Test
	void test() {
		String Input = "IGNITE 0 1000 AT 0\n" + 
				"IGNITE 1 500 AT 2\n"+
				"SHUTOFF 0 AT 5\n"+
				"SHUTOFF 1 AT 6\n";
		
		String Expect = "IGNITE 0 1000 AT 0\n" + 
				"IGNITE 1 500 AT 2\n"+
				"SHUTOFF 0 AT 5\n"+
				"SHUTOFF 1 AT 6\n";
		
		mytest.fireUp(Input);
		assertEquals(Expect, logger.getLog());
		
	}
	
	
	
}
