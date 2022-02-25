package graphics;

import java.awt.Graphics;

import main.Constants;
import main.Main;

public class BarLine extends VisualObject{
	public BarLine(int startingX, int startingY) {
		super(startingX, startingY);
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(startingX, startingY,(int) (Main.screenWidth.get()/500), Constants.barDistance.get()*4);
	}
}
