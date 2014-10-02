package anyOne300;

public class TenthFrame extends OneFrame {
	private int thirdScore;
	private EachFrame eachFrame;
	
	public TenthFrame() {
	}
	
	public TenthFrame(EachFrame eachFrame, int thirdScore) {
		this.eachFrame = eachFrame;
		this.setThirdScore(thirdScore);
	}
	
	private void oneOrTwoOrThreeShotFactor() {
		if(_randomShot(TENPINS) != ALLPIN) {
			setFirstScore(_randomShot(TENPINS)); 
			sndKnockOver();
		} else if (_randomShot(TENPINS) == ALLPIN){
			eachFrame.setFirstScore(TENPINS);

			
		}
		totalPoint();	
	}
	
//	void knockOver() {
//		oneOrTwoShotFactor();
//	}
//
//	private void oneOrTwoShotFactor() {
//		if(_randomShot(TENPINS) != ALLPIN) {
//			setFirstScore(_randomShot(TENPINS)); 
//			sndKnockOver();
//		}
//		totalPoint();	
//	}
	
	

	public int getThirdScore() {
		return thirdScore;
	}

	public void setThirdScore(int thirdScore) {
		this.thirdScore = thirdScore;
	}
}
