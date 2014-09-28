package anyOne300;

import knockDown.FallPins;

public class TenPinsEvent {
	private static final int TEN_POINT = 10;
	private static final int STRIKE_FIRST_FRAME = 0;
	private static final int SPARE_FIRST_FRAME = 1;

	private FallPins fallPins = new FallPins();
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
			fallPins.setType(STRIKE_FIRST_FRAME);
			fallPins.countTotalScore(frames, nthFrame);
		} else if(_spare(nthFrame)) {
			fallPins.setType(SPARE_FIRST_FRAME);
			fallPins.countTotalScore(frames, nthFrame);
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
