package anyOne300;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EachFrame {
	Map<String, Integer> oneFrame = new HashMap<String , Integer>();
	Set<Entry<String, Integer>> scoreSet = oneFrame.entrySet();
	Iterator<Entry<String, Integer>> scoreIter = scoreSet.iterator();
	
	void fillUpScore(int firstShot, int sndShot) {
		oneFrame.put( "placeOnePin", firstShot);
		oneFrame.put("totalShot", firstShot + sndShot);
		oneFrame.put("placeSndPin", sndShot);
//		oneFrame.put("totalScore", value);
		
//		while (scoreIter.hasNext()) {
//			Map.Entry<String, Integer> scoreSheet = (Map.Entry<String, Integer>)scoreIter.next();
//			System.out.println(scoreSheet.getKey() + ": " + scoreSheet.getValue());
//		}		
	}
	


}
