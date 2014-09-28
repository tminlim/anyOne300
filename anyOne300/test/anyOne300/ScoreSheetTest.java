package anyOne300;

import junit.framework.TestCase;

public class ScoreSheetTest extends TestCase {

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
