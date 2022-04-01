package graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import main.Constants;
import main.Main;
import music.Note;
import music.Rest;
import music.TimeElement;

public class Measure extends VisualObject{

	public ArrayList<TimeElement> timeElements;
	public static int size = Main.numBeats*16/Main.beat;
	private int availibleSize;
	public int numNotes;
	private int distance; 
	
	public Measure(int startingX, int startingY) {
		super(startingX, startingY);
		this.timeElements = new ArrayList<TimeElement>();
		availibleSize = size;
	}
	
	public boolean canAddElement(TimeElement timeElement) {
		return availibleSize - timeElement.duration >= 0;
	}
	
	
	public void addElement(TimeElement timeElement) {
		timeElement.setLocationInMeasure(timeElements.size());
		timeElements.add(timeElement);
		availibleSize -= timeElement.duration;
	}
	
	public void printMeasure() {
		for(int i = 0; i < timeElements.size(); i ++) {
			}
	}
	
	@Override
	public void paint(Graphics g, Canvas canvas) {
		numNotes = timeElements.size();
		distance = Constants.measureSize.get()/numNotes;
		
		for(int i = 0; i < timeElements.size(); i++) {
			Image image = Toolkit.getDefaultToolkit().getImage(timeElements.get(i).imageFileName);
			int startingXPos = 0;
			int startingYPos = 0;
			int width = 0;
			int height = 0;
			if(timeElements.get(i) instanceof Rest) {
				Rest rest = (Rest) timeElements.get(i);
				
				if(rest.duration == 16) {
					startingXPos = startingX+distance*i+2*Constants.barDistance.get(); 
					startingYPos = startingY+2*Constants.barDistance.get();
					width = (int) (4*37/68*Constants.barDistance.get()); 
					height = (int) (4*Constants.barDistance.get());
				}
				
				else if(rest.duration == 8) {
					startingXPos = startingX+distance*i+2*Constants.barDistance.get();
					startingYPos = (int) (startingY+1.5*Constants.barDistance.get());
					width = (int) (4*37/68*Constants.barDistance.get());
					height = (int) (4*Constants.barDistance.get());
				}
				
				else if(rest.duration == 4) {
					startingXPos = startingX+distance*i+2*Constants.barDistance.get();
					startingYPos = (int) (startingY);
					width = (int) (10*37/68/3*Constants.barDistance.get());
					height = (int) (10/3*Constants.barDistance.get());
				}
				
				else {
					startingXPos = startingX+distance*i+2*Constants.barDistance.get();
					startingYPos = (int) (startingY+Constants.barDistance.get());
					width = (int) (8*37/68/3*Constants.barDistance.get());
					height = (int) (8/3*Constants.barDistance.get());
				}
			}
			
			else{
				Note note = (Note) timeElements.get(i);
				startingXPos = startingX+distance*i+2*Constants.barDistance.get();
				startingYPos = (int) (startingY + (0.5)*(26-note.pitch)*Constants.barDistance.get()); 
				
				g.setColor(Constants.black);
				if(note.numLedgerLines != 0) {
					int remainingLedgerLines = note.numLedgerLines;
					while(remainingLedgerLines != 0) {
						if(remainingLedgerLines > 0) {
							g.fillRect(startingXPos, startingY-(Constants.barDistance.get()*remainingLedgerLines), 40, 3);
							remainingLedgerLines --;
						}
						else {
							g.fillRect(startingXPos, startingY+Constants.barDistance.get()*4-(Constants.barDistance.get()*remainingLedgerLines), 40, 3);
							remainingLedgerLines ++;
							
						}
					}
				}
				
				width =(int) (4*37/68*Constants.barDistance.get());
				height = (int) (4*Constants.barDistance.get());
				note.findImageFile(note.duration);
				startingYPos += note.yModifier;
			}
			
			
			g.drawImage(image, startingXPos, startingYPos, width, height, canvas);
		}
	}
}
