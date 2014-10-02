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
		System.out.print("볼링 게임을 시작합니다! Enter를 힘차게 눌러 볼링공을 던져보세요!!!!");
		for (int nthFrame = 0; nthFrame < NUMBER_OF_FRAMES; nthFrame++) {
			scanner.nextLine();
			System.out.print(String.format("%d번째 프레임입니다. ",nthFrame+1));
			if(nthFrame == TENTH_FRAME ) {
				System.out.print(String.format("[ 1세트 : %d점 ] [ 2세트 : %d점 ] [ 3세트 : %d ]  =  총 %d점!  \n ", frames[TENTH_FRAME].getFirstScore(), frames[TENTH_FRAME].getSndScore(), frames[TENTH_FRAME].getThrirdScore(),  frames[TENTH_FRAME].getFrameScore()));
			} else
				System.out.print(String.format("[ 1세트 : %d점 ] [ 2세트 : %d점 ]  =  총 %d점  \n ", frames[nthFrame].getFirstScore(), frames[nthFrame].getSndScore(), frames[nthFrame].getFrameScore()));
		}
	}
}
