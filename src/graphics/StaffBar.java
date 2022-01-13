package graphics;
import java.awt.*;

import main.*;
import javax.swing.text.StyleConstants.CharacterConstants;

public class StaffBar extends VisualObject{

	public StaffBar(int startingY) {
		super(10, startingY);
	}

	@Override
	public void paint(Graphics g) {
		
		g.fillRect(startingX,startingY,(int) (Constants.screenWidth - 40), (int) (Constants.screenHeight/400) );
	}
}
