package main;
import java.io.*; 
import java.util.*;
import java.util.function.Supplier;
import java.awt.*;
import javax.swing.*;

import graphics.Measure;
import music.Note;
import music.Rest;


public class Main extends Canvas{
	public static int numLines;
	private static final long serialVersionUID = -5968742390812682346L;
	private static File readFile; 
	private static Scanner reader;
	
	public static String title;
	public static int beat; 
	public static int numBeats;
	public static String backgroundColor;
	
	public Thread runThread;
	private static Canvas canvas = new Main();
	
	public static Supplier<Integer> screenWidth = () -> canvas.getWidth();
	public static Supplier<Integer> screenHeight = ()-> canvas.getHeight();
	
	private static JFrame frame;
	private static JPanel panel = new JPanel();
	
	public static void main(String[] args) throws IOException{
		readFile = new File("input.txt");
		reader = new Scanner(readFile);
		
		getInitialInformation();
		frame = new JFrame(title);
		initGUI();
		
		addMusic();
		numLines = MusicHandler.measures.size()/9;
		
		for(Measure m : MusicHandler.measures) {
			m.printMeasure();
		}
		System.out.println(MusicHandler.measures.size());
	}

	public void paint(Graphics g) {
		GraphicsHandler.drawBackground(g, backgroundColor);
		g.setColor(Constants.black);
		
		for(int i = 0; i < numLines+1; i++) {
			GraphicsHandler.paintStaffLine(g, i);
			GraphicsHandler.paintTimeSignature(g, Toolkit.getDefaultToolkit().getImage(Constants.numbers[numBeats]), Toolkit.getDefaultToolkit().getImage(Constants.numbers[beat]), this, i);
		}

		GraphicsHandler.drawBarLines(g);
	}
	
	public static void getInitialInformation() {
		title = reader.nextLine(); 
		numBeats = reader.nextInt();
		beat = reader.nextInt();
		backgroundColor = reader.next();
	}
	
	
	public static void initGUI() {
		canvas.setSize(Constants.initialScreenWidth, Constants.initialScreenHeight);

		panel.add(canvas);
		
        frame.add(panel);
       
        frame.pack();
        frame.setVisible(true);
	}
	
	public static void addMusic() {
		while(reader.hasNext()) {
			String firstArguement = reader.next();
			if(firstArguement.charAt(0) != 'r' && firstArguement.charAt(0) != 'R') {
				MusicHandler.addElement(new Note(firstArguement, reader.nextInt()));
			}
			
			else {
				MusicHandler.addElement(new Rest(reader.nextInt()));
			}
		}
	}
	
	public static void close() {
		frame.dispose();
	}
}


