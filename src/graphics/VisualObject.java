package graphics;
import javax.swing.*;
import java.awt.*;

public abstract class VisualObject {
	protected int startingX;
	protected int startingY;
	
	public VisualObject(int startingX, int startingY) {
		this.startingX = startingX;
		this.startingY = startingY;
	}
	
	public int getX() {
		return startingX;
	}
	
	public int getY() {
		return startingY;
	}
	
	abstract void paint(Graphics g, Canvas canvas);
}
