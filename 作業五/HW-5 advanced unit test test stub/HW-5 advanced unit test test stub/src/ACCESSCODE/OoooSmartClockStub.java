package ACCESSCODE;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import java.text.DateFormat;

class OoooSmartClockStub {
	
	OoooSmartClock testcase = new OoooSmartClock();
	
	
	//function to check if two value is equal.
	void assertEquals(int exp, int b) {
		Assertions.assertEquals(exp, b);
	}
	
	//void assertEquals(IDialog exp, IDialog b) {
	//	Assertions.assertEquals(exp, b);
	//}
	
	@Test
	void Stubtest() throws Exception {
		IDialog d = new OoooSmartClock();
		d.set(5);
		int zoneindex = d.show();
		testcase.dialog=d;
		testcase.setTimeZone();
		assertEquals(zoneindex,testcase.getTimeZone());
		
	}
	
	@Test
	void Stubtest2() {
		int b = testcase.show();
	    int exp = 2;
		assertEquals(exp,b);
	}
	
	

}
