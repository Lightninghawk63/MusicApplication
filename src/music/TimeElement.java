package music;

public abstract class TimeElement {

public String imageFileName;
	protected int locationInMeasure;
	public double duration;
	
	public TimeElement(double duration) {
		duration = 16/duration;
		this.duration = duration;
		imageFileName = findImageFile(duration);
	}
	
	protected abstract String findImageFile(double duration);
	
	public void setLocationInMeasure(int index) {
		locationInMeasure = index;
	}
}
