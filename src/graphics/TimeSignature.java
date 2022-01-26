package graphics;

import java.awt.*;

import main.Constants;
import javax.swing.*;

public class TimeSignature extends VisualObject{

	public Image numBeats;
	public Image beat;
	public Canvas canvas;
	
	public TimeSignature(int startingY, Image numBeats, Image beat, Canvas canvas) {
		super(10, startingY);
		this.numBeats = numBeats;
		this.beat = beat;
		this.canvas = canvas;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(numBeats, startingX, startingY, canvas);
		g.fillRect(startingX,startingY+10, (int) (Constants.screenWidth/400), (int) (Constants.screenHeight/400) );
		g.drawImage(numBeats, startingX, startingY+20, canvas);
	}
}