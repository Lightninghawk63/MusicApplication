package graphics;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Constants;

public class Title{
	
	private static JLabel title = new JLabel();
	
	public static void drawTitle(JFrame f) {
		title.setText("title");//Constants.readFile.getName());
		/*title.setAlignmentX(50);
		title.setAlignmentY(50);
		title.setEnabled(true);
		title.paint(g);*/
		
		f.add(title);
	}
}
