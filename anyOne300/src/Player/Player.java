package Player;
import Bowl.BowlOver;

public class Player extends BowlOver {		
	BowlOver bowl = new BowlOver();

	public String firstShot() {
		if(allTenPoint()) {
			return "/";
		} 
		return null;	
	}

	private boolean allTenPoint() {
		if(this.countOnePins == 10) {
			return true;
		} 
		return false;
	}

	void notTenPins(int sndShot) {
		this.sndShot(sndShot);
	}


	
}
