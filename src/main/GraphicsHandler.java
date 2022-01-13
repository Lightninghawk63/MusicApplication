package main;
import java.awt.*;
import javax.swing.*;

import graphics.StaffBar;

public class GraphicsHandler {
	public static void paintStaffLine(Graphics g, int startingY) {
		StaffBar[] bar = new StaffBar[5];
		
		for(int i = 0; i < bar.length; i++) {
			bar[i] = new StaffBar(startingY + i*20);
			bar[i].paint(g);
		}
	}
}
