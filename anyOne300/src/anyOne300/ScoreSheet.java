package anyOne300;

import knockDown.FallPins;

public class ScoreSheet {
	private static final int NUMBER_OF_FRAMES = 10;
	private static final int NOT_TEN_NOT_FIRST_FRAME = 2;
	private static final int TEN_POINT = 10;
	private static final int FIRST_FRAME = 0;
	
	private FallPins fallPins;
	
	private EachFrame[] frames;

	void initFrame() {
		frames = new EachFrame[NUMBER_OF_FRAMES];
	}
	
	void receiveScore() {
		for (int nthFrame = 0; nthFrame < NUMBER_OF_FRAMES; ++nthFrame) {
			frames[nthFrame] = new EachFrame();
			frames[nthFrame].knockOver();
			totalFrameScore(nthFrame); 
		}
	}

	private void totalFrameScore(int nthFrame) {
		totalScoreByFrame(nthFrame);
	}

	private void totalScoreByFrame(int nthFrame) {
		if(nthFrame > FIRST_FRAME) {
			tenPinsEvent(nthFrame);									
			fallPins.setType(NOT_TEN_NOT_FIRST_FRAME, frames, nthFrame);
		} else 			
			isFirstFrame();
	}

	private void isFirstFrame() {
		if(strikeFirstFrame()) 
			frames[FIRST_FRAME].setFrameScore(TEN_POINT); 
		else 
			frames[FIRST_FRAME].setFrameScore(frames[FIRST_FRAME].getTotalScore());
	}

	private boolean strikeFirstFrame() {
		return frames[FIRST_FRAME].getFirstScore() == TEN_POINT;
	}
	
	private ScoreSheet tenPinsEvent(int nthFrame) {
		return new TenPinsEvent(this, frames, nthFrame).tenPinsEvent();
	}

	void renderScore() {
		for (EachFrame eachFrame : frames)
			System.out.println(String.format("%d + %d = %d (%d) | ", eachFrame.getFirstScore(), eachFrame.getSndScore(), eachFrame.getTotalScore(), eachFrame.getFrameScore()));
	}
}
