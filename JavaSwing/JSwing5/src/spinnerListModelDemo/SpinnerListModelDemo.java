package spinnerListModelDemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListModelDemo {
	  JSpinner jspin; 
	  JLabel jlab; 
	 
	  // Create an array of RGB colors. 
	  String colors[] = { "Red", "Green", "Blue" }; 
	 
	  SpinnerListModelDemo() {  
	    JFrame jfrm = new JFrame("SpinnerListModel");  
	    jfrm.setLayout(new FlowLayout());   
	    jfrm.setSize(220, 100);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	    SpinnerListModel spm = new SpinnerListModel(colors); 
	    jspin = new JSpinner(spm); 
	 
	    // Set the preferred size of the spinner. 
	    jspin.setPreferredSize(new Dimension(60, 20)); 
	 
	    // Make a label that displays the selection and set its border color.  
	    // Because Red is the first string in the list, it will be selected by default when the spinner is created. 
	    jlab = new JLabel(" Current selection is: Red "); 
	    jlab.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); 
	 
	    // Add change listener for the spinner. 
	    jspin.addChangeListener(new ChangeListener() {  
	      public void stateChanged(ChangeEvent ce) {  
	        // Obtain the current selection. 
	        String color = (String) jspin.getValue(); 
	 
	        // Report the selection in the label. 
	        jlab.setText(" Current selection is: " + color + " ");	                      
	   
	        // Set the label's border color based on the selection.  
	        if(color.equals("Red")) {
	        	  jlab.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	          }else if(color.equals("Green")) {
	        	  jlab.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4)); 
	          }else{
	        	  jlab.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));  
	          }	            
	      }  
	    });  
	 
	    // Add the spinner and label to the content pane. 
	    jfrm.add(jspin); 
	    jfrm.add(jlab);  
	    jfrm.setVisible(true);  
	  }  
}
