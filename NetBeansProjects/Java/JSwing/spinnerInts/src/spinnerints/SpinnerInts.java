package spinnerints;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerInts {
	  JSpinner jspin; 
	  JLabel jlab; 
	 
	  SpinnerInts() {  
	    JFrame jfrm = new JFrame("Spin Integers");   
	    jfrm.setLayout(new FlowLayout());    
	    jfrm.setSize(200, 120);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	 
	    // Create an integer spinner model. 
	    SpinnerNumberModel spm = new SpinnerNumberModel(1, 1, 10, 1); 
	           	  
	    // Create a JSpinner using the model. 
	    jspin = new JSpinner(spm); 
	 
	    // Set the preferred size of the spinner. 
	    jspin.setPreferredSize(new Dimension(40, 20)); 
	 
	    // Make a label that displays the selection. 
	    jlab = new JLabel(" Current border size is: 1 "); 
	    jlab.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	 
	    // Add change listener for the spinner. 
	    jspin.addChangeListener(new ChangeListener() {  
	      public void stateChanged(ChangeEvent ce) {  
	        // Get the curent size. 
	        Integer bSize = (Integer) jspin.getValue(); 
	 
	        // Report the current size. 
	        jlab.setText(" Current border size is: " +  bSize + " "); 
	                    
	        // Set the label's border size based on the value selected. 
	        jlab.setBorder(BorderFactory.createLineBorder(Color.BLACK, bSize.intValue())); 	          	 
	      }  
	    });  

	    jfrm.add(jspin); 
	    jfrm.add(jlab); 
	    jfrm.setVisible(true);  
	  }  
}
