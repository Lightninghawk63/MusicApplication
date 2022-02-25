package music;

import main.Constants;

public class Rest extends TimeElement{

	public Rest(int duration) {
		super(duration);
	}
	
	protected String findImageFile(double duration) {
		String imageFile = "error";
		if(duration == 1) {
			imageFile = Constants.sixteenthRest;
		}
		
		else if(duration == 2) {
			imageFile = Constants.eighthRest;
		}
		
		else if(duration == 4) {
			imageFile = Constants.quarterRest;
		}
		
		else if(duration == 8) {
			imageFile = Constants.halfRest;
		}
		
		else if(duration == 16) {
			imageFile = Constants.wholeRest;
		}
		
		return imageFile;
	}

}
