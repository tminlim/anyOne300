package anyOne300;

public class ScoreSheet{
	EachFrame[] frames;
//	EachFrame currentFrame = new EachFrame();
//	EachFrame nextFrame = new EachFrame();
	
	static enum NumFrame {
		first,
		tenth,
		between
		//리팩토링에 사용 될수도 
	} 

	void initFrame() {
		frames = new EachFrame[10];
	}

	void receiveScore() {
		for (int nthFrame = 0; nthFrame < frames.length; ++nthFrame) {
			frames[nthFrame] = new EachFrame();
			frames[nthFrame].knockOver();
			totalFrameScore(nthFrame); 
		}
	}

	private void totalFrameScore(int nthFrame) {
		byFrameTotalScore(nthFrame);
	}

	private void byFrameTotalScore(int nthFrame) {
		int sndTotalFrames = 0;
		if(notFirstFrame(nthFrame)) {
			tenPinsEvent(nthFrame);	
			//주먹구구식이지만 우선 결과값이 나오도록 
			sndTotalFrames = firstScoreTenEvent();
			sumFrameScore(nthFrame);
			
			frames[nthFrame].frameScore = frames[nthFrame - 1].frameScore + frames[nthFrame].totalScore;
		} else {			
			isFirstFrame(nthFrame, sndTotalFrames);
		}
		//else 부분 피할 수 있는 방법 
	}

	private void isFirstFrame(int nthFrame, int sndTotalFrames) {
		sumFrameScore(nthFrame);
		if(strikeFirstFrame()) {
			frames[0].frameScore = sndTotalFrames + 10;
		}
	}

	private void sumFrameScore(int nthFrame) {
		frames[nthFrame].frameScore = frames[nthFrame].totalScore;
	}

	private boolean strikeFirstFrame() {
		return frames[0].firstScore == 10;
	}

	private int firstScoreTenEvent() {
		return frames[1].totalScore;
	}

	private boolean notFirstFrame(int nthFrame) {
		return nthFrame > 0;
	}
	
	private void tenPinsEvent(int nthFrame) {
		if(strike(nthFrame)) {				
			frames[nthFrame - 1].frameScore = frames[nthFrame].totalScore + frames[nthFrame - 1].frameScore;
		} else if(spare(nthFrame)) {
			frames[nthFrame - 1].frameScore = frames[nthFrame].firstScore + frames[nthFrame - 1].frameScore;
		}
	}

	private boolean spare(int nthFrame) {
		return frames[nthFrame - 1].totalScore == 10;
	}

	private boolean strike(int nthFrame) {
		return frames[nthFrame - 1].firstScore == 10;
	}
	
	void renderScore() {
		for (EachFrame eachFrame : frames) {
			System.out.print(String.format("%d + %d = %d (%d) | ", eachFrame.firstScore, eachFrame.sndScore, eachFrame.totalScore, eachFrame.frameScore));
		}
	}
}
