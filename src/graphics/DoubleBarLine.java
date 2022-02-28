package graphics;

import java.awt.Graphics;

import main.Constants;
import main.GraphicsHandler;
import main.Main;

public class DoubleBarLine extends VisualObject{
	public DoubleBarLine(int startingX, int startingY) {
		super(startingX, startingY);
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(startingX, startingY,(int) (Main.screenWidth.get()/500), Constants.barDistance.get()*4);
		g.fillRect((int) (startingX+Main.screenWidth.get()/200), startingY, (int) (Main.screenWidth.get()/250), Constants.barDistance.get()*4);
		g.setColor(GraphicsHandler.getColor(Main.backgroundColor));
		g.fillRect((int) (startingX+Main.screenWidth.get()/200 + Main.screenWidth.get()/250), startingY, 2000, 2000);
	}
}
