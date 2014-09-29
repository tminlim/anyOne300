package knockDown;

import anyOne300.EachFrame;

public class FallPins {
	private FallPinsType type;
	private EachFrame[] frames;
	private int curFrame;
		
	int getType() {
		return type.getTypeEvent();
	}
	public void setType (int _type, EachFrame[] nFrames, int nNthFrame) {
		FallPinsType.fallType(_type);
		frames = nFrames;
		curFrame = nNthFrame;
		countTotalScore();
	}
	
	void countTotalScore() {
		int prevFrame = curFrame - 1;
		int frameScore;
		
		switch (getType()) {
		case FallPinsType.STRIKE_NOT_FIRST_FRAME:
			frameScore= frames[curFrame].getTotalScore() + frames[prevFrame].getFrameScore();
			frames[prevFrame].setFrameScore(frameScore); 			
			break;
		case FallPinsType.SPARE_NOT_FIRST_FRAME:
			frameScore= frames[curFrame].getFirstScore() + frames[prevFrame].getFrameScore();
			frames[prevFrame].setFrameScore(frameScore);	
			break;
		case FallPinsType.NOT_STRIKE_NOT_FIRST_FRAME:
			frameScore= frames[prevFrame].getFrameScore() + frames[curFrame].getTotalScore();
			frames[curFrame].setFrameScore(frameScore);			
			break;

		default:
			throw new RuntimeException("누적점수를 모르는 상황! ");
		}
	}


}
