package Bowl;

import junit.framework.TestCase;
import Bowl.BowlOver;

public class BowlOverTest extends TestCase {
	public void testBowl() throws Exception {
		BowlOver bowl = new BowlOver();//junit에서 반복되는 부분 전체 필드로 처리하는 방법 있었다 
		int point = bowl.knockOver(7);
		assertEquals(7, point);
		
		int maxRemainPins = bowl.remainPins();
		assertEquals(3 , maxRemainPins);				
		assertTrue(bowl.rangeSndPoint(2));
		bowl.sndShot(2);
		assertEquals(7, bowl.countOnePins);
		assertEquals(2, bowl.countSndPins);
		
	}
}
