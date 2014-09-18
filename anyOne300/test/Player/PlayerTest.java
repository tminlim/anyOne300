package Player;

import java.util.Scanner;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	Scanner scan = new Scanner(System.in);

	public void testAllTenPins() throws Exception {
		Player frame = new Player();	
		//scanner test
		//assertEquals(frame.knockOver(scan.nextInt()), frame.point);
		//int 타입아닌거 에러처리 		
		//assertEquals(true, frame.fallTenPins());
		frame.knockOver(10);
		assertEquals("/", frame.firstShot());
	}
	
	public void testNotTenPins() throws Exception {
		Player frame = new Player();	
		frame.knockOver(8);
		frame.notTenPins(1);
		assertEquals(8, frame.countOnePins);
		assertEquals(1, frame.countSndPins);
		assertEquals(9, frame.totalPoint);	
	}
}
