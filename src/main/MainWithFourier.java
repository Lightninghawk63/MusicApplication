package main;
/*import java.io.*; 
import java.util.*;
import java.awt.*;
import javax.sound.sampled.*;
import javax.swing.*;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.TransformType;


public class MainWithFourier extends Canvas{
	private static final long serialVersionUID = -5968742390812682346L;
	
	private static ArrayList<ArrayList<Complex>> transformedPressures = new ArrayList<ArrayList<Complex>>();
	private static Canvas canvas = new MainWithFourier();
	private static double realMax = Integer.MIN_VALUE;
	private static double realMin = Integer.MAX_VALUE;
	private static double imaginaryMax = Integer.MIN_VALUE;
	private static double imaginaryMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Constants.readFile);
			int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
			int numBytes = 1024 * bytesPerFrame; 
			
			byte[] audioBytes = new byte[numBytes];
			
			try {
				@SuppressWarnings("unused")
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
	
			System.out.println("done");
			System.out.println("Real: " + realMin + ", " +realMax);
			System.out.println("Imaginary: " + imaginaryMin + ", " +imaginaryMax);
			System.out.println("SizeX: " + Constants.screenWidth + " SizeY:" + Constants.screenHeight);
		} catch (Exception e) {}
	}*/
