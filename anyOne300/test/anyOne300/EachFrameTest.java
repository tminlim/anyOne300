package anyOne300;

import junit.framework.TestCase;

public class EachFrameTest extends TestCase {
	
	public void testFillScore() throws Exception {
		EachFrame eachFrame = new EachFrame();
		eachFrame.fillUpScore(8,1);
		assertEquals((Integer)9, eachFrame.oneFrame.get("totalShot"));
		assertEquals((Integer)8, eachFrame.oneFrame.get("placeOnePin"));
		assertEquals((Integer)1, eachFrame.oneFrame.get("placeSndPin"));
	}
	
//	public void testname() throws Exception {
//		
//	}
	
	
	
}
