package main;
import java.awt.*;
import java.io.File;

import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;

public class Constants {
	//Dimensions
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	public static double screenWidth = screenSize.getWidth();
	public static double screenHeight = screenSize.getHeight();
	
	// General Files
	public static File readFile = new File("TestFile.wav");
	
	//Math Stuff
	public static FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	
	//Image references
	public static String numberImagePrefix = "H:\\ComputerScienceHL-Project\\MusicMaker\\resources\\images\\numbers\\";
	public static String noteImagePrefix = "H:\\ComputerScienceHL-Project\\MusicMaker\\resources\\images\\notes\\";
	public static String restImagePrefix = "H:\\ComputerScienceHL-Project\\MusicMaker\\resources\\images\\rests\\";
	
	public static String one = numberImagePrefix + "one.png";
	public static String two = numberImagePrefix + "two.png";
	public static String three = numberImagePrefix + "three.png";
	public static String four = numberImagePrefix + "four.png";
	public static String five = numberImagePrefix + "five.png";
	public static String six = numberImagePrefix + "six.png";
	public static String seven = numberImagePrefix + "seven.png";
	public static String eight = numberImagePrefix + "eight.png";
	public static String nine = numberImagePrefix + "nine.png";
	
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
