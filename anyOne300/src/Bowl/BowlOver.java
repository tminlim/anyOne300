package Bowl;

public class BowlOver {
	int point;
	private final int ALLPINS = 10;

	public BowlOver() {
	}

	public int knockOver(int pinFall) {
		return this.point = pinFall;
	}

	int remainPins() {
		int maxRemainPins = ALLPINS - point;
		return maxRemainPins;
	}

	boolean rangeSndPoint(int nPinFall) {
		int maxRemainPins = remainPins();
		if(nPinFall <= maxRemainPins)
			return true;			
		return false;
	}
//sndShot()안에 knockOver() 기능이 있어서 추가하려고 했으나 못함 
	void sndShot(int pinFall) {
		if(rangeSndPoint(pinFall))
			this.point += pinFall;
	}
	
	
}
