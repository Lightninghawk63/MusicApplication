package graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Main;
import music.TimeElement;

public class Measure extends VisualObject{

	public ArrayList<TimeElement> timeElements;
	public static int size = Main.numBeats*16/Main.beat;
	private int availibleSize;
	public int numNotes;
	
	public Measure(int startingX, int startingY) {
		super(startingX, startingY);
		this.timeElements = new ArrayList<TimeElement>();
		availibleSize = size;
	}
	
	public boolean canAddElement(TimeElement timeElement) {
		return availibleSize - timeElement.duration >= 0;
	}
	
	
	public void addElement(TimeElement timeElement) {
		timeElements.add(timeElement);
		availibleSize -= timeElement.duration;
	}
	
	public void printMeasure() {
		for(int i = 0; i < timeElements.size(); i ++) {
			System.out.println("X: " + startingX + "Y: " + startingY);
		}
	}
	
	@Override
	void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
