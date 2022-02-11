package main;
import java.io.*; 
import java.util.*;
import java.awt.*;
import javax.sound.sampled.*;
import javax.swing.*;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.TransformType;

import graphics.Title;
import music.Note;


public class Main extends Canvas{
	private static final long serialVersionUID = -5968742390812682346L;
	private static File readFile; 
	public static String title;
	public static int beat; 
	public static int numBeats;
	
	private static Canvas canvas = new Main();
	
	private static JFrame frame = new JFrame("Music Reader");
	private static JPanel panel = new JPanel();
	public static void main(String[] args) throws IOException {
		readFile = new File("input.txt");
		Scanner reader = new Scanner(readFile);
		
		getInitialInformation(reader);
		
		initGUI();
	}
	
	public void paint(Graphics g) {
		GraphicsHandler.paintStaffLine(g, 100);
		GraphicsHandler.paintTimeSignature(g, Toolkit.getDefaultToolkit().getImage(Constants.sixteenthRest), Toolkit.getDefaultToolkit().getImage(Constants.half), 100, this);
		
	}
	
	public static void getInitialInformation(Scanner reader) {
		title = reader.nextLine(); 
	}
	
	public static void initGUI() {
		canvas.setSize((int)Constants.screenWidth, (int)Constants.screenHeight);

		panel.add(canvas);
		
        frame.add(panel);
        //Title.drawTitle(frame, title);
		
        frame.pack();
        frame.setVisible(true);
	}
}


