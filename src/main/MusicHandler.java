package main;

import java.util.ArrayList;
import java.util.Arrays;

import graphics.Measure;
import music.Note;
import music.Rest;
import music.TimeElement;

public class MusicHandler {
	private static int currentMeasure = 0;
	public static ArrayList<Measure> measures = new ArrayList<Measure>(Arrays.asList(new Measure(0,0)));
		
	public static void addElement(TimeElement element) {
		if(element.duration > Measure.size) {
			Main.close();
		}
		
		else if(measures.get(currentMeasure).canAddElement(element)) {
			measures.get(currentMeasure).addElement(element);
		}
		
		else {
			int width = Main.screenWidth.get();
			measures.get(currentMeasure).numNotes = measures.get(currentMeasure).size;
			Measure newMeasure = new Measure(Constants.startingLocation.get()+(measures.size()%Constants.numMeasuresInRow.get())*Constants.measureSize.get(),
					Main.screenHeight.get()/12 + (Constants.numMeasuresInRow.get()/measures.size()*6)*Constants.barDistance.get());
			measures.add(newMeasure);
			currentMeasure++;
			measures.get(currentMeasure).addElement(element);
		}
	}
}
