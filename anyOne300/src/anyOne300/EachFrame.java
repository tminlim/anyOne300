package anyOne300;
import java.util.Random;

public class EachFrame {
	public final static int ALLPIN = 10;
	
	int firstScore;
	int sndScore;
	int totalScore;
	int frameScore;
	

	int randomFirstShot() {
		Random firstRandom = new Random();
		int firstShot = firstRandom.nextInt(11);
		return firstShot;
	}

	void knockOver() {
		int shot = randomFirstShot();
		this.firstScore = shot;
		if(shot != ALLPIN) {
			sndKnockOver();
			totalPoint();			
		}
		if(shot == ALLPIN) {
			totalPoint();			
			return;
		}
	}

	int rangeSndPoint() {
		return ALLPIN - firstScore;
	}

	int randomSndShot() {
		int maxRemainPins =rangeSndPoint();
		Random sndRandom = new Random();
		int sndShot = sndRandom.nextInt(maxRemainPins + 1);
		return sndShot;
	}

	void sndKnockOver() {
		int sndShot = randomSndShot();
		this.sndScore = sndShot;
	}

	void totalPoint() {
		this.totalScore = firstScore + sndScore;
	}
}
