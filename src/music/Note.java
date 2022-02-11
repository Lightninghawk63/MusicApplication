package music;

public class Note {
	public String imageFileName;
	public double duration;
	public String enteredPitch;
	public int pitch;
	public int numLedgerLines;
	
	public Note(String imageFileName, double duration, String enteredPitch) {
		this.imageFileName = imageFileName;
		this.duration = duration;
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
}
