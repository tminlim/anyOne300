package anyOne300;

import junit.framework.TestCase;

public class ScoreSheetTest extends TestCase {
	ScoreSheet sheet = new ScoreSheet();
	public void testRender() throws Exception {
		for (int i = 0; i < sheet.frames.length; i++) {
			System.out.println(sheet.frames[i] + ":" + i );
		}
		sheet.render();
		
	}
}
