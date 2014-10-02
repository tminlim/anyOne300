package anyOne300;

import java.util.Scanner;

public class ScoreSheet {
	private static final int NUMBER_OF_FRAMES = 10;
	private static final int TEN_POINT = 10;
	private static final int FIRST_FRAME = 0;
	private static final int TENTH_FRAME = 9;
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
		if((nthFrame > FIRST_FRAME) && (nthFrame < TENTH_FRAME)) {
			tenPinsEvent(nthFrame);			
			int nFrameScore= frames[nthFrame - 1].getFrameScore() + frames[nthFrame].getTotalScore();
			frames[nthFrame].setFrameScore(nFrameScore);
		} else {			
			isFirstFrame();
		}
		if(nthFrame == TENTH_FRAME) {
			if((frames[TENTH_FRAME].getFirstScore() == TEN_POINT)) {
				frames[TENTH_FRAME].thirdKnockOver();
				int nFrameScore= frames[TENTH_FRAME].getFrameScore() + frames[TENTH_FRAME].getThrirdScore();
				frames[TENTH_FRAME].setFrameScore(nFrameScore);
				
			} else {
				int nFrameScore= frames[nthFrame - 1].getFrameScore() + frames[TENTH_FRAME].getTotalScore();
				frames[TENTH_FRAME].setFrameScore(nFrameScore);
				
			}
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
		Scanner scanner = new Scanner(System.in);
		for (int nthFrame = 0; nthFrame < NUMBER_OF_FRAMES; nthFrame++) {
			if(nthFrame == TENTH_FRAME ) {
				System.out.print(String.format("[%d|%d|%d][%d] || ", frames[TENTH_FRAME].getFirstScore(), frames[TENTH_FRAME].getSndScore(), frames[TENTH_FRAME].getThrirdScore(),  frames[TENTH_FRAME].getFrameScore()));
			} else
				System.out.print(String.format("[%d|%d][%d] || ", frames[nthFrame].getFirstScore(), frames[nthFrame].getSndScore(), frames[nthFrame].getFrameScore()));
		}
		scanner.nextLine();
	}
}
