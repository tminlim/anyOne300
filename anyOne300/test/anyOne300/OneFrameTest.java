package anyOne300;

import junit.framework.TestCase;

public class OneFrameTest extends TestCase {
	public void testRandomShot() throws Exception {
		OneFrame oneFrame = new OneFrame();
		int rd = oneFrame._randomShot(3);
		System.out.println(rd);
		assertTrue(rd < 4);
	}	
}
