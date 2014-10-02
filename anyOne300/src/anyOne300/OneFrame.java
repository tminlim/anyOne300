package anyOne300;

import java.util.Random;

class OneFrame {
	protected static final int ALLPIN = 10;		
	protected static final int TENPINS = 10;
		
	private int firstScore;
	private int sndScore;
	private int thrirdScore;
	private int totalScore;
	
	void knockOver() {
		oneOrTwoShotFactor();
	}
	
	void thirdKnockOver(){
		setFirstScore(TENPINS);
		setThrirdScore(_randomShot(TENPINS));
	}

	private void oneOrTwoShotFactor() {
		if(_randomShot(TENPINS) != ALLPIN) {
			setFirstScore(_randomShot(TENPINS)); 
			sndKnockOver();
		}
		totalPoint();	
	}
	
	protected void sndKnockOver() {
		setSndScore(_randomShot(_rangeSndPoint()));
	}
	
	private int _rangeSndPoint() {
		return ALLPIN - getFirstScore();
	}

	protected void totalPoint() {
		setTotalScore(getFirstScore() + getSndScore());
	}	

	int _randomShot(int maxRemainPins) {
		Random random = new Random();
		return random.nextInt(maxRemainPins + 1);		
	}
	
	int getFirstScore() {
		return firstScore;
	}
	
	int getSndScore() {
		return sndScore;
	}
	
	int getTotalScore() {
		return totalScore;
	}
	
	void setFirstScore(int nFirstScore) {
		firstScore = nFirstScore;
	}
	
	void setSndScore(int nSndScore) {
		sndScore = nSndScore;
	}
	
	void setTotalScore(int nTotalScore) {
		totalScore = nTotalScore;
	}
	
	int getThrirdScore() {
		return thrirdScore;
	}
	
	void setThrirdScore(int thrirdScore) {
		this.thrirdScore = thrirdScore;
	}		
}
