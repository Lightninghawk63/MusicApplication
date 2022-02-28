package main;
import java.awt.*;
import java.io.File;
import java.util.function.Supplier;

import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;

public class Constants {
	//Dimensions
	public static Dimension initialScreenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	public static int initialScreenWidth = (int) initialScreenSize.getWidth();
	public static int initialScreenHeight = (int) initialScreenSize.getHeight();
	public static Supplier<Integer> measureSize = () -> (int) (Main.screenWidth.get()/10);
	public static Supplier<Integer> startingLocation = () -> (int) (Main.screenWidth.get()/90);
	
	//Colors
	public static Color black = new Color(0,0,0);
	public static Color red = new Color(221, 157, 157);
	public static Color blue = new Color(157, 157, 221);
	public static Color green = new Color(157, 221, 157);
	public static Color yellow = new Color(255, 255, 200);
	public static Color purple = new Color(221, 190, 221);
	public static Color orange = new Color(255, 210, 101);
	public static Color white = new Color(255, 255, 255);
	
	// General Files
	public static File readFile = new File("TestFile.wav");
	
	//Math Stuff
	public static FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	public static Supplier<Integer> barDistance = () -> Main.screenHeight.get()/50;
	public static Supplier<Integer> numMeasuresInRow = () -> (int)((Main.screenWidth.get()-startingLocation.get())/measureSize.get());
	//Image references
	public static String numberImagePrefix = "H:\\ComputerScienceHL-Project\\MusicMaker\\resources\\images\\numbers\\";
	public static String noteImagePrefix = "H:\\ComputerScienceHL-Project\\MusicMaker\\resources\\images\\notes\\";
	public static String restImagePrefix = "H:\\ComputerScienceHL-Project\\MusicMaker\\resources\\images\\rests\\";
	
	public static String[] numbers = new String[] {
			numberImagePrefix + "zero.png", numberImagePrefix + "one.png", numberImagePrefix + "two.png",
			numberImagePrefix + "three.png", numberImagePrefix + "four.png", numberImagePrefix + "five.png",
			numberImagePrefix + "six.png", numberImagePrefix + "seven.png", numberImagePrefix + "eight.png",
			numberImagePrefix + "nine.png"
	};
	
	public static String whole = noteImagePrefix + "whole.png";
	public static String half = noteImagePrefix + "half.png";
	public static String quarter = noteImagePrefix + "quarter.png";
	public static String eighth = noteImagePrefix + "eighth.png";
	public static String sixteenth = noteImagePrefix + "sixteenth.png";
	public static String dot = noteImagePrefix + "dot.png";
	
	public static String wholeRest = restImagePrefix + "whole.png";
	public static String halfRest = restImagePrefix + "half.png";
	public static String quarterRest = restImagePrefix + "quarter.png";
	public static String eighthRest = restImagePrefix + "eighth.png";
	public static String sixteenthRest = restImagePrefix + "sixteenth.png";
	
	
}
