package graphics;
import java.awt.*;

import main.*;
import javax.swing.text.StyleConstants.CharacterConstants;

public class StaffBar extends VisualObject{

	public StaffBar(int startingY) {
		super((int)(Main.screenWidth.get()/100), startingY);
	}

	@Override
	public void paint(Graphics g, Canvas canvas) {
		g.fillRect(startingX,startingY,
				(int) (Main.screenWidth.get()*.8 + 1.72*Constants.barDistance.get() + 
						Constants.measureSize.get()), (int) (Main.screenWidth.get()/600));
	}
}
