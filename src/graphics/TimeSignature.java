package graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Constants;

public class TimeSignature {
	
	public static JLabel numBeatsLabel;
	public static JLabel beatLabel;
	
	public static void initialize(JPanel panel) {
		numBeatsLabel = new JLabel(String.valueOf(Constants.numBeats));
		//beatLabel = new JLabel(String.valueOf(Constants.beat));
		
		numBeatsLabel.setLocation(0,0);
		
		panel.add(numBeatsLabel);
		
		//panel.add(beatLabel);
	}
}
