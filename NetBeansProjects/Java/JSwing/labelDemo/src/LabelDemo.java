

import javax.swing.JFrame;
import javax.swing.JLabel;


public class LabelDemo {
	LabelDemo() { 
		 
	    // Create a new JFrame container. 
	    JFrame jfrm = new JFrame("Label Demo"); 
	 
	    // Give the frame an initial size. 
	    jfrm.setSize(275, 100); 
	 
	    // Terminate the program when the user closes the application. 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 
	    // Create a text-based label. 
	    JLabel jlab = new JLabel(" Swing powers the modern Java GUI."); 
	 
	    // Add the label to the content pane. 
	    jfrm.getContentPane().add(jlab); 
	 
	    // Display the frame. 
	    jfrm.setVisible(true); 
	  } 
}


