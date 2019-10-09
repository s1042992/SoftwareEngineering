package ACCESSCODE;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class OoooSmartClockStub extends OoooSmartClock {
	
	void assertEquals(boolean expected, boolean actual) {
		Assertions.assertEquals(expected, actual);
	}
	@Test
	void test() {
		boolean b = Boolean.parseBoolean(getCurrentTimeStamp());
	    boolean exp = true;
		assertEquals(exp,b);
	}
	
	@Test
	void test2() {
		boolean b = Boolean.parseBoolean(getLocalCurrentTimeStamp());
	    boolean exp = true;
		assertEquals(exp,b);
	}

}
