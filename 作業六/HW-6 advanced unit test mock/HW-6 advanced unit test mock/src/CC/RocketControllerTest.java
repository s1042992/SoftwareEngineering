package CC;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RocketControllerTest  {
	
	IRocketSystemBaseMock mytest = null;
	RocketController controller;
	ILogger logger;
	
	
	@BeforeEach
	void BeforeEachTest() {
		controller = new RocketController();
		logger = new ILogger();
		mytest = new IRocketSystemBaseMock(logger);
		controller.setUpRocketSystem(mytest);
	}
	@After
	void AfterTest(){
		controller = null;
		logger = null;
		
	}

	@Test
	void test1() {
		
		
		
		String Input = "IGNITE 0 1000 AT 0\n" + 
				"IGNITE 1 500 AT 2\n"+
				"SHUTOFF 0 AT 5\n"+
				"SHUTOFF 1 AT 6\n";
		
		String Expect = "IGNITE 0 1000 AT 0\n" + 
				"IGNITE 1 500 AT 2\n"+
				"SHUTOFF 0 AT 5\n"+
				"SHUTOFF 1 AT 6\n";
		
		controller.fireUp(Input);
		
		//System.out.println(Input);
		
		assertEquals(Expect, logger.getLog());
		
	}
	
	
	
	
}
