package ACCESSCODE;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class OoooSmartClockStub {
	
	OoooSmartClock testcase = new OoooSmartClock();
	
	//function to check if two value is equal.
	void assertEquals(boolean expected, boolean actual) {
		Assertions.assertEquals(expected, actual);
	}
	//function to check if the string is null.
	boolean isEmpty(String value) {
        if (value == null || value.trim().equals(""))
            return true;
        else
            return false;
    }
	
	@Test
	void test() {
		//System.out.println(testcase.getCurrentTimeStamp());
		boolean b = isEmpty(testcase.getCurrentTimeStamp());
	    boolean exp = true;
		assertEquals(exp,b);
	}
	
	@Test
	void test2() {
		boolean b = isEmpty(testcase.getLocalCurrentTimeStamp());
	    boolean exp = true;
		assertEquals(exp,b);
	}

}
