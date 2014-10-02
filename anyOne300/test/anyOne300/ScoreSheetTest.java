package anyOne300;

import junit.framework.TestCase;

public class ScoreSheetTest extends TestCase {
	private static int NUMBER_OF_FRAMES = 10;

	public void testSetFrame() throws Exception {
		ScoreSheet sheet = new ScoreSheet();
		sheet.initFrame();
		sheet.receiveScore();		
		}
	
	public void testTotalScoreByFrame() throws Exception {
		ScoreSheet sheet = new ScoreSheet();
		sheet.initFrame();
		sheet.receiveScore();
		sheet.renderScore();
	}
}
