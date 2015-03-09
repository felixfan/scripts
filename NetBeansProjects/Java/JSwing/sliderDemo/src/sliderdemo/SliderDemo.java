package sliderdemo;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo {
	  JLabel jlabVert,jlabHoriz; 	 
	  JSlider jsldrHoriz,jsldrVert; 
	  
	  SliderDemo() {  	  
	    JFrame jfrm = new JFrame("Demonstrate Sliders");  
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(300, 300);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    // Create default vertical and horizontal slider. 
	    jsldrVert = new JSlider(JSlider.VERTICAL); 
	    jsldrHoriz = new JSlider(); // horizontal by default 
	 
	    // Add major tick marks. 
	    jsldrVert.setMajorTickSpacing(10); 
	    jsldrHoriz.setMajorTickSpacing(20); 
	 
	    // Use minor tick marks on the vertical slider. 
	    jsldrVert.setMinorTickSpacing(5); 
	 
	    // Create standard numeric labels. 
	    jsldrVert.setLabelTable(jsldrVert.createStandardLabels(10)); 
	    jsldrHoriz.setLabelTable(jsldrHoriz.createStandardLabels(20)); 
	 
	    // Cause the tick marks to be displayed. 
	    jsldrVert.setPaintTicks(true); 
	    jsldrHoriz.setPaintTicks(true); 
	 
	    // Cause the labels to be displayed. 
	    jsldrVert.setPaintLabels(true); 
	    jsldrHoriz.setPaintLabels(true); 
	 
	    // These labels display the current slider value. 
	    jlabHoriz = new JLabel("Value of horizontal slider: " + jsldrHoriz.getValue());  	                            
	    jlabVert = new JLabel("Value of vertical slider: " + jsldrVert.getValue());  
	                            
	    // Add change listeners for the sliders. 
	    // The horizontal slider waits until the user stops changing the slider's value before it responds.  
	    jsldrHoriz.addChangeListener(new ChangeListener() {  
	    	public void stateChanged(ChangeEvent ce) {  
	    		// If the slider is in the process of being changed, simply return.  
	    		if(jsldrHoriz.getValueIsAdjusting()) {
	    			return; 
	    		}
	 
	    		// Display the new value. 
	    		jlabHoriz.setText("Value of horizontal slider: " + jsldrHoriz.getValue());                   
	    	} 
	    });  
	 
	    // The vertical slider handler responds to all change events, including those generated while the slider is in the process of being changed. 
	    jsldrVert.addChangeListener(new ChangeListener() {  
	    	public void stateChanged(ChangeEvent ce) {  
	    		// Display the new value. 
	    		jlabVert.setText("Value of vertical slider: " + jsldrVert.getValue()); 	                                  
	    	} 
	    });  
	 	   
	    jfrm.add(jsldrHoriz); 
	    jfrm.add(jsldrVert); 
	    jfrm.add(jlabHoriz); 
	    jfrm.add(jlabVert); 
 
	    jfrm.setVisible(true);  
	  }  

}
