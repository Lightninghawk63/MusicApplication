package main;
import java.awt.*;
import javax.swing.*;

import graphics.StaffBar;
import graphics.TimeSignature;

public class GraphicsHandler {
	public static void paintStaffLine(Graphics g, int startingY) {
		StaffBar[] bar = new StaffBar[5];
		
		for(int i = 0; i < bar.length; i++) {
			bar[i] = new StaffBar(startingY + i*20);
			bar[i].paint(g);
		}
	}	
	
	public static void paintTimeSignature(Graphics g, int startingY, Image numBeats, Image beat, Canvas canvas) {
		TimeSignature t = new TimeSignature(startingY, numBeats, beat, canvas);
		t.paint(g);
	}
}
