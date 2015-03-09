package scrollbardemo;

import java.awt.Adjustable;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ScrollBarDemo {
	  JLabel jlabVert,jlabHoriz,jlabSBInfo; 
	  JScrollBar jsbVert,jsbHoriz; 
	  
	  ScrollBarDemo() {   
	    JFrame jfrm = new JFrame("Demonstrate Scroll Bars");  
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(260, 500);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    jlabVert = new JLabel("Value of vertical scroll bar: 0");  
	    jlabHoriz = new JLabel("Value of horizontal scroll bar: 250");  
	 
	    // Create default vertical and horizontal scroll bar. 
	    // jsbVert = new JScrollBar(); // vertical by default 
	    // jsbHoriz = new JScrollBar(Adjustable.HORIZONTAL); 
	    
	    // Specify values for scroll bars. 
	    jsbVert = new JScrollBar(JScrollBar.VERTICAL, 
	                             0, // initial value 
	                             5, // extent 
	                             0, // minimum 
	                             500); // maximum 
	    jsbHoriz = new JScrollBar(Adjustable.HORIZONTAL, 
	                              250, // initial value 
	                              0, // extent 
	                              0, // minimum 
	                              500); // maximum 
	    
	    // Specify preferred size for scroll bars.  
	    // The vertical scroll bar will be wide. 
	    jsbVert.setPreferredSize(new Dimension(30, 200)); 
	    // The horizontal scroll bar will be narrow. 
	    jsbHoriz.setPreferredSize(new Dimension(200, 10)); 
	    
	    // Set the block increment size for the horizontal bar. 
	    jsbHoriz.setBlockIncrement(25); 
	    
	    // Add adjustment listeners for the scroll bars. 
	    // The vertical scroll bar waits until the user stops changing the scroll bar's value before it responds.  
	    jsbVert.addAdjustmentListener(new AdjustmentListener() {  
	    	public void adjustmentValueChanged(AdjustmentEvent ae) {  
	    		// If the scroll bar is in the process of being changed, simply return.  
	    		if(jsbVert.getValueIsAdjusting()) {
	    			return; 
	    		}
	    		// Display the new value. 
	    		jlabVert.setText("Value of vertical scroll bar: " + ae.getValue());         
	    	} 
	    });  
	 
	    // The horizontal scroll bar handler responds to all adjustment events, including those generated while 
	    // the scroll bar is in the process of being changed. 
	    jsbHoriz.addAdjustmentListener(new AdjustmentListener() {  
	    	public void adjustmentValueChanged(AdjustmentEvent ae) {  
	    		// Display the new value. 
	    		jlabHoriz.setText("Value of horizontal scroll bar: " + ae.getValue());                     
	    	} 
	    });  
	 
	    // Display the scroll bar defaults.   
	    jlabSBInfo = new JLabel("<html>Scroll Bar Defaults<br>" + 
	                       "Minimum value: " + 
	                       jsbVert.getMinimum() + "<br>" + 
	                       "Maximum value: " + 
	                       jsbVert.getMaximum() + "<br>" + 
	                       "Visible amount (extent): " + 
	                       jsbVert.getVisibleAmount() + "<br>" + 
	                       "Block increment: " + 
	                       jsbVert.getBlockIncrement() + "<br>" + 
	                       "Unit increment: " + 
	                       jsbVert.getUnitIncrement()); 
	    
	    jfrm.add(jsbVert); 
	    jfrm.add(jsbHoriz); 
	    jfrm.add(jlabVert); 
	    jfrm.add(jlabHoriz); 
	    jfrm.add(jlabSBInfo); 
	 
	    jfrm.setVisible(true); 
	  }
}
