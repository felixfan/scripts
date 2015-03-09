

import javax.swing.SwingUtilities;

public class RunButtonDemo {

	public static void main(String[] args) {
		// Create the frame on the event dispatching thread. 
	    SwingUtilities.invokeLater(new Runnable() { 
	      public void run() { 
	        new ButtonDemo(); 
	      } 
	    }); 

	}

}
