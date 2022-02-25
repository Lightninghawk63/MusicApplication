package music;

import main.Constants;

public class Note extends TimeElement{
	
	public String enteredPitch;
	public int pitch;
	public int numLedgerLines;
	
	public Note(String enteredPitch,  int duration) {
		super(duration);
		this.enteredPitch = enteredPitch;
		pitch = convertPitch();
		numLedgerLines = findLedgerLines();
	}
	
	private int convertPitch() {
		int value = 0;
		int octave = 0;
		
		octave = Integer.parseInt(enteredPitch.substring(1));
		value = enteredPitch.substring(0,1).charAt(0)-65+(octave-1)*7;
		return value;
	}
	
	private int findLedgerLines() {
		return 1;
	}
	
	protected String findImageFile(double duration) {
		String imageFile = "error";
		if(duration == 1) {
			imageFile = Constants.sixteenth;
		}
		
		else if(duration == 2) {
			imageFile = Constants.eighth;
		}
		
		else if(duration == 4) {
			imageFile = Constants.quarter;
		}
		
		else if(duration == 8) {
			imageFile = Constants.half;
		}
		
		else if(duration == 16) {
			imageFile = Constants.whole;
		}
		
		return imageFile;
	}
}
