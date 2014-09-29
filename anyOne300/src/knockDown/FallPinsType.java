package knockDown;

abstract class FallPinsType {
	abstract int getTypeEvent();
	
	static FallPinsType fallType (int _type) {
		switch (_type) {
		case STRIKE_NOT_FIRST_FRAME:
			return new StrikeNotFirstFrame();
		case SPARE_NOT_FIRST_FRAME:
			return new SpareFirstNotFrame();
		case NOT_TEN_NOT_FIRST_FRAME:
			return new NotStrikeNotFirst();
		default:
			throw new IllegalArgumentException("볼링핀에서 일어나지 않는 상황! ");		
		}
	}	
	
	static final int STRIKE_NOT_FIRST_FRAME = 0;
	static final int SPARE_NOT_FIRST_FRAME = 1;
	static final int NOT_TEN_NOT_FIRST_FRAME = 2;

	
}
