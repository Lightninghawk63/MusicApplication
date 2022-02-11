package graphics;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Constants;

public class Title{
	
	private static JLabel title = new JLabel();
	
	public static void drawTitle(JFrame f, String text) {
		title.setText(text);
		f.add(title);
	}
}
