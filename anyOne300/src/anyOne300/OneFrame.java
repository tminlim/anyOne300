package anyOne300;

import java.util.Random;

class OneFrame {
	private static final int ALLPIN = 10;		
	private static final int TNEPINS = 10;
		
	private int firstScore;
	private int sndScore;
	private int totalScore;
	
	void knockOver() {
		oneOrTwoShotFactor();
	}

	private void oneOrTwoShotFactor() {
		if(_randomShot(TNEPINS) != ALLPIN) {
			setFirstScore(_randomShot(TNEPINS)); 
			sndKnockOver();
		}
		totalPoint();	
	}
	
	private void sndKnockOver() {
		setSndScore(_randomShot(_rangeSndPoint()));
	}
	
	private int _rangeSndPoint() {
		return ALLPIN - getFirstScore();
	}


	private void totalPoint() {
		setTotalScore(getFirstScore() + getSndScore());
	}	

	int _randomShot(int maxRemainPins) {
		Random random = new Random();
		return random.nextInt(maxRemainPins + 1);		
	}
	
	public int getFirstScore() {
		return firstScore;
	}
	
	int getSndScore() {
		return sndScore;
	}
	
	public int getTotalScore() {
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
}
