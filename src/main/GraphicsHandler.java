package main;
import java.awt.*; 
import javax.swing.*;

import graphics.BarLine;
import graphics.DoubleBarLine;
import graphics.StaffBar;
import graphics.VisualObject;

public class GraphicsHandler {
	public static void paintStaffLine(Graphics g, int lineNumber) {
		StaffBar[] bar = new StaffBar[5];
		
		for(int i = 0; i < bar.length; i++) {
			bar[i] = new StaffBar(Main.screenHeight.get()/12 + (i + lineNumber*Constants.numBarSpacing)*Constants.barDistance.get());
			bar[i].paint(g, null);
		}
		
	}	
	
	public static void paintTimeSignature(Graphics g, Image numBeats, Image beat, Canvas canvas, int lineNumber) {
			g.drawImage(numBeats, (int) (Main.screenWidth.get()/90), 
					Main.screenHeight.get()/12+lineNumber*Constants.numBarSpacing*Constants.barDistance.get(), 
					(int) (1.2*Constants.barDistance.get()), 2*Constants.barDistance.get(), canvas);
			g.drawImage(beat, (int) (Main.screenWidth.get()/90), 
					(int) (Main.screenHeight.get()/12+(lineNumber*Constants.numBarSpacing+2)*Constants.barDistance.get()), 
					(int) (1.2*Constants.barDistance.get()), 2*Constants.barDistance.get(), canvas);
	}
	
	public static void drawBarLines(Graphics g) {
		int currentX = (int)(Constants.startingLocation.get() + 1.5*Constants.barDistance.get() + Constants.measureSize.get());
		int currentY = (int) (Main.screenHeight.get()/12);
		BarLine firstLine = new BarLine(currentX, currentY);
		firstLine.paint(g, null);
		for(int i = 0; i < MusicHandler.measures.size()-2; i++) {
			if(currentX + Constants.measureSize.get() < Main.screenWidth.get()) {
				currentX += Constants.measureSize.get();
			}
			else {
				currentX = (int)(Constants.startingLocation.get() + 1.5*Constants.barDistance.get() + Constants.measureSize.get());
				currentY += Constants.barDistance.get()*Constants.numBarSpacing;
			}
			
			BarLine line = new BarLine(currentX, currentY);
			line.paint(g, null);
		}
		if(currentX + Constants.measureSize.get() < Main.screenWidth.get()) {
			currentX += Constants.measureSize.get();
		}
		else {
			g.setColor(getColor(Main.backgroundColor));
			g.fillRect(currentX+3, currentY, Main.screenWidth.get(), Main.screenHeight.get());
			currentX = (int)(Constants.startingLocation.get() + 1.5*Constants.barDistance.get() + Constants.measureSize.get());
			currentY += Constants.barDistance.get()*Constants.numBarSpacing;
			g.setColor(Constants.black);
		}
		
		DoubleBarLine line = new DoubleBarLine(currentX, currentY);
		line.paint(g, null);
	}
	
	public static void drawBackground(Graphics g, String color) {
		g.setColor(getColor(color));
		g.fillRect(0, 0, Main.screenWidth.get(), Main.screenHeight.get());
	}
	
	public static void drawMeasures(Graphics g, Canvas canvas) {
		for(int i = 0; i < MusicHandler.measures.size(); i++) {
			MusicHandler.measures.get(i).paint(g, canvas);
		}
	}
	
	public static Color getColor(String color) {
		if(color.equalsIgnoreCase("red")) {
			return Constants.red;
		}
		
		else if(color.equalsIgnoreCase("blue")) {
			return Constants.blue;
		}
		
		else if(color.equalsIgnoreCase("yellow")) {
			return Constants.yellow;
		}
		
		else if(color.equalsIgnoreCase("green")) {
			return Constants.green;
		}
		
		else if(color.equalsIgnoreCase("orange")) {
			return Constants.orange;
		}
		
		else if(color.equalsIgnoreCase("purple")) {
			return Constants.purple;
		}
		return Constants.white;
	}
}	
