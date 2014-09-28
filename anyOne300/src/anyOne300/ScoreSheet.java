package anyOne300;

public class ScoreSheet {
	private static final int NUMBER_OF_FRAMES = 10;
	private static final int TEN_POINT = 10;
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
		if(nthFrame > 0) {
			tenPinsEvent(nthFrame);			
			int nFrameScore= frames[nthFrame - 1].getFrameScore() + frames[nthFrame].getTotalScore();
			frames[nthFrame].setFrameScore(nFrameScore);
		} else {			
			isFirstFrame();
		}
	}

	private void isFirstFrame() {
		if(strikeFirstFrame()) {
			frames[0].setFrameScore(TEN_POINT); 
		} else {
			frames[0].setFrameScore(frames[0].getTotalScore());
		}
	}

	private boolean strikeFirstFrame() {
		return frames[0].getFirstScore() == TEN_POINT;
	}
	
	private ScoreSheet tenPinsEvent(int nthFrame) {
		return new TenPinsEvent(this, frames, nthFrame).tenPinsEvent();
	}

	
	void renderScore() {
		for (EachFrame eachFrame : frames) {
			System.out.println(String.format("%d + %d = %d (%d) | ", eachFrame.getFirstScore(), eachFrame.getSndScore(), eachFrame.getTotalScore(), eachFrame.getFrameScore()));
		}
	}
}
