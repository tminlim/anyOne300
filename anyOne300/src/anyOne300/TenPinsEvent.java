package anyOne300;

public class TenPinsEvent {
	private static final int TEN_POINT = 10;
	
	private final ScoreSheet scoreSheet;
	private int nthFrame;
	private EachFrame[] frames;
	
	TenPinsEvent(ScoreSheet _scoreSheet, EachFrame[] _eachFrames, int _nthFrame) {
		scoreSheet = _scoreSheet;
		frames = _eachFrames;
		nthFrame = _nthFrame;
	}
	
	ScoreSheet tenPinsEvent() {
		if(_strike(nthFrame)) {				
			int frameScore= frames[nthFrame].getTotalScore() + frames[nthFrame - 1].getFrameScore();
			frames[nthFrame - 1].setFrameScore(frameScore); 
		} else if(_spare(nthFrame)) {
			int frameScore= frames[nthFrame].getFirstScore() + frames[nthFrame - 1].getFrameScore();
			frames[nthFrame - 1].setFrameScore(frameScore);
		}
		return scoreSheet;
	}

	private boolean _spare(int nthFrame) {
		return frames[nthFrame - 1].getTotalScore() == TEN_POINT;
	}

	private boolean _strike(int nthFrame) {
		return frames[nthFrame - 1].getFirstScore() == TEN_POINT;
	}
}
