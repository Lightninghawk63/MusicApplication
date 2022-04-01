package music;

import main.Constants;

public class Rest extends TimeElement{

	public Rest(double duration) {
		super(duration);
	}
	
	protected String findImageFile(double duration) {
		String imageFile = "error";
		if(duration == 1) {
			imageFile = Constants.sixteenthRest;
		}
		
		else if(duration == 2 || duration == 3) {
			imageFile = Constants.eighthRest;
		}
		
		else if(duration == 4 || duration == 6) {
			imageFile = Constants.quarterRest;
		}
		
		else if(duration == 8 || duration == 12) {
			imageFile = Constants.halfRest;
		}
		
		else if(duration == 16 || duration == 24) {
			imageFile = Constants.wholeRest;
		}
	
		return imageFile;
	}

}
