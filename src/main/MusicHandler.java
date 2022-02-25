package main;

import java.util.ArrayList;
import java.util.Arrays;

import graphics.Measure;
import music.Note;
import music.Rest;
import music.TimeElement;

public class MusicHandler {
	private static int currentMeasure = 0;
	public static ArrayList<Measure> measures = new ArrayList<Measure>(Arrays.asList(new Measure()));
		
	public static void addElement(TimeElement element) {
		if(element.duration > Measure.size) {
			Main.close();
		}
		
		else if(measures.get(currentMeasure).canAddElement(element)) {
			measures.get(currentMeasure).addElement(element);
		}
		
		else {
			int width = Main.screenWidth.get();
			double startLoc = width/90 +  (1.5*Constants.barDistance.get());
			measures.get(currentMeasure).numNotes = measures.get(currentMeasure).size;
			measures.add(new Measure());
			currentMeasure++;
			measures.get(currentMeasure).addElement(element);
		}
	}
}
