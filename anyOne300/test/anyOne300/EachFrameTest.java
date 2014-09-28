package anyOne300;


import junit.framework.TestCase;

public class EachFrameTest extends TestCase {
	public void testFillUpScore() throws Exception {
		EachFrame eachFrame = new EachFrame();
		eachFrame.knockOver();				
//		eachFrame.sndKnockOver();
//		eachFrame.totalPoint();
		System.out.println(String.format("%d = %d + %d ", eachFrame.getTotalScore(), eachFrame.getFirstScore(), eachFrame.getSndScore()));
	}


}

	

