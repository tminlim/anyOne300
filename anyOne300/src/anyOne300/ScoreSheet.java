package anyOne300;

public class ScoreSheet{
	EachFrame[] frames;
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
		if(notFirstFrame(nthFrame)) {
			tenPinsEvent(nthFrame);	
			frames[nthFrame].frameScore = frames[nthFrame - 1].frameScore + frames[nthFrame].totalScore;
		} else {			
			frames[nthFrame].frameScore = frames[nthFrame].totalScore;
//			if(frames[0].firstScore == 10) {
//				int tmp = frames[1].totalScore;
//				frames[0].frameScore = tmp + 10;
//				frames[0].frameScore = " ";
//			}
		}
		//else 부분 피할 수 있는 방법 
	}

	private boolean notFirstFrame(int nthFrame) {
		return nthFrame > 0;
	}
	
	private void tenPinsEvent(int nthFrame) {
		if(strike(nthFrame)) {				
			frames[nthFrame - 1].frameScore = frames[nthFrame].totalScore + frames[nthFrame - 1].frameScore;
		}
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
