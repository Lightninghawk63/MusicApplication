package main;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.awt.*;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

import graphics.TimeSignature;
import graphics.Title;

public class Main extends Canvas{
	private static final long serialVersionUID = -5968742390812682346L;
	
	private static ArrayList<ArrayList<Complex>> transformedPressures = new ArrayList<ArrayList<Complex>>();
	private static Canvas canvas = new Main();
	private static double realMax = Integer.MIN_VALUE;
	private static double realMin = Integer.MAX_VALUE;
	private static double imaginaryMax = Integer.MIN_VALUE;
	private static double imaginaryMin = Integer.MAX_VALUE;
	
	private static JFrame frame = new JFrame("My Drawing");
	private static JPanel panel = new JPanel();
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public static void main(String[] args) throws IOException {
		initGUI();
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Constants.readFile);
			int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
			int numBytes = 1024 * bytesPerFrame; 
			
			byte[] audioBytes = new byte[numBytes];
			
			try {
				int numBytesRead = 0;
				
				double[] pressureAsDouble = new double[audioBytes.length];
				while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
					for(int i = 0; i < audioBytes.length; i++) {
						pressureAsDouble[i] = audioBytes[i];
					}
					
					Complex[] indexAsArray = Constants.transformer.transform(pressureAsDouble, TransformType.FORWARD);
					ArrayList<Complex> indexAsList = new ArrayList<Complex>();
					
					for(int i = 0; i < indexAsArray.length; i++) {
						if(indexAsArray[i].getReal() > realMax) {
							realMax = indexAsArray[i].getReal();
						}
						
						else if(indexAsArray[i].getReal() < realMin) {
							realMin = indexAsArray[i].getReal();
						}
						
						if(indexAsArray[i].getImaginary() > imaginaryMax) {
							imaginaryMax = indexAsArray[i].getImaginary();
						}
						
						else if(indexAsArray[i].getImaginary() < imaginaryMin) {
							imaginaryMin = indexAsArray[i].getImaginary();
						}
						
						indexAsList.add(indexAsArray[i]);
					}
					
					transformedPressures.add(indexAsList);
					
				}		
			} catch (Exception e) {}
	
			canvas.repaint();
			System.out.println("done");
			System.out.println("Real: " + realMin + ", " +realMax);
			System.out.println("Imaginary: " + imaginaryMin + ", " +imaginaryMax);
			System.out.println("SizeX: " + Constants.screenWidth + " SizeY:" + Constants.screenHeight);
		} catch (Exception e) {}
	}
	
	public void paint(Graphics g) {
		/*if(transformedPressures != null) {
			for(int i = 0; i < transformedPressures.size(); i++) {
				for(int j = 0; j < transformedPressures.get(i).size(); j++) {
					g.fillOval((int) transformedPressures.get(i).get(j).getReal()/23+966,(int) transformedPressures.get(i).get(j).getImaginary()/23+540, 10, 10);
				}
			}
		}*/
		
		GraphicsHandler.paintStaffLine(g, 100);
		GraphicsHandler.paintTimeSignature(g, 100, toolkit.getImage("eight.png"), toolkit.getImage("four.png"), this);
    }
	
	public static void initGUI() {
		//panel.add(new JLabel(Constants.readFile.getName()));
		canvas.setSize((int)Constants.screenWidth, (int)Constants.screenHeight);

		panel.add(canvas);
		
        frame.add(panel);
   
        frame.pack();
        frame.setVisible(true);
	}
}
