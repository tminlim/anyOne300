package anyOne300;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class PrintTest extends TestCase {
	public void testInitScoreBoard() throws Exception {
		Print print = new Print();
		print.initAllScoreBoard();
		//assertEquals("[0|0] ", actual);
	}
}
