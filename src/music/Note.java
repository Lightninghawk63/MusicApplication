package music;

import main.Constants;

public class Note extends TimeElement{
	
	public String enteredPitch;
	public int pitch;
	public int numLedgerLines;
	public int yModifier;
	public Note(String enteredPitch,  double duration) {
		super(duration);
		this.enteredPitch = enteredPitch;
		pitch = convertPitch();
		numLedgerLines = findLedgerLines();
		imageFileName = findImageFile(duration);
		if(pitch > 28) {
			yModifier = Constants.barDistance.get()*3;
		}
	}
	
	private int convertPitch() {
		int value = 0;
		int octave = 0;
		
		octave = Integer.parseInt(enteredPitch.substring(1));
		value = enteredPitch.substring(0,1).charAt(0)-65+(octave-1)*7;
		return value;
	}
	
	private int findLedgerLines() {
		int numLedgerLines = 0;
		if(pitch < 25) {
			numLedgerLines = (int) -((25-pitch)/2);
		}
		else if(pitch > 33) {
			numLedgerLines = (int) ((pitch-33)/2);
		}
		return numLedgerLines;
	}
	
	public String findImageFile(double duration) {
		String imageFile = "error";
		if(pitch > 28) {
			if(duration == 16) {
				imageFile = Constants.sixteenth_high;
			}
			
			else if(duration == 8) {
				imageFile = Constants.eighth_high;
			}
			
			else if(duration == 4) {
				imageFile = Constants.quarter_high;
			}
			
			else if(duration == 2 || duration == 12) {
				imageFile = Constants.half_high;
			}
			
			else if(duration == 1 || duration == 24) {
				imageFile = Constants.whole;
			}
		}
		
		else {
			if(duration == 16) {
				imageFile = Constants.sixteenth_low;
			}
			
			else if(duration == 8) {
				imageFile = Constants.eighth_low;
			}
			
			else if(duration == 4) {
				imageFile = Constants.quarter_low;
			}
			
			else if(duration == 2) {
				imageFile = Constants.half_low;
			}
			
			else if(duration == 1) {
				imageFile = Constants.whole;
			}
		}
		return imageFile;
	}
}
