

import javax.swing.SwingUtilities;


public class RunLabelDemo {

	public static void main(String[] args) {
		// Create the frame on the event dispatching thread. 
	    SwingUtilities.invokeLater(new Runnable() { 
	      public void run() { 
	        new LabelDemo(); 
	      } 
	    }); 
	  } 
}
