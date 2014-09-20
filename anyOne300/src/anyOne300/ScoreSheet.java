package anyOne300;

public class ScoreSheet{
	EachFrame[] frames;

	void initFrame() {
		frames = new EachFrame[10];
	}

	void receiveScore() {
		for (int i = 0; i < frames.length; i++) {
			frames[i] = new EachFrame();
			frames[i].knockOver();
			frames[i].sndKnockOver();
			frames[i].totalPoint();
		}
	}

	void renderScore() {
		for (EachFrame eachFrame : frames) {
			System.out.print(String.format("%d + %d = %d | ", eachFrame.firstScore, eachFrame.sndScore, eachFrame.totalScore));
		}
	}
	
	
	
	
	

}
