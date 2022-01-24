package main;
import java.awt.*;
import java.io.File;

import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;

public class Constants {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	public static double screenWidth = screenSize.getWidth();
	public static double screenHeight = screenSize.getHeight();
	
	public static File readFile = new File("TestFile.wav");
	
	public static FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	
	public static int beat = 0;
	public static int numBeats =  0;
}
