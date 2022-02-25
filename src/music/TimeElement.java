package music;

public abstract class TimeElement {

public String imageFileName;
	
	public double duration;
	public TimeElement(int duration) {
		duration = 16/duration;
		this.duration = duration;
		imageFileName = findImageFile(duration);
	}
	
	protected abstract String findImageFile(double duration);
}
