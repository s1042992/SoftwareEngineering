import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class AvlTest {
	AvlTree temp = new AvlTree();
	@BeforeEach
	void setup()
	{
		AvlTree temp = new AvlTree();
	}
	@AfterEach
	void cleanup()
	{
		AvlTree temp = null;
	}
	
	

	@Test
	void test() {
		
		temp.insert(10);
		temp.insert(5);
		temp.insert(4);
		temp.insert(11);
		temp.insert(15);
		temp.insert(16);
		temp.insert(17);
		temp.insert(3);
		temp.insert(2);
		temp.insert(9);
		temp.insert(8);
		temp.insert(7);

		assertEquals("2 4 3 7 8 5 10 15 17 16 11 9",temp.postorder());
		assertEquals("2 3 4 5 7 8 9 10 11 15 16 17",temp.inorder());
		assertEquals("9 5 3 2 4 8 7 11 10 16 15 17",temp.preorder());
	}
	
	@Test
	void test2() {
		
		temp.insert(2);
		temp.insert(5);
		temp.insert(9);
		temp.insert(14);
		temp.insert(13);
		temp.insert(17);
		temp.insert(6);
		
		assertEquals("2 6 9 5 17 14 13",temp.postorder());
		assertEquals("2 5 6 9 13 14 17",temp.inorder());
		assertEquals("13 5 2 9 6 14 17",temp.preorder());
	}

}
