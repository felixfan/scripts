package jSplitPaneDemo;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class JSplitPaneDemo {
	  JSplitPaneDemo() {  
		    JFrame jfrm = new JFrame("Split Pane Demo");  
		    jfrm.setSize(380, 150);  
		    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		 
		    JLabel jlab = new JLabel(" Left side: ABCDEFGHIJKLMNOPQRSTUVWXYZ"); 		      
		    JLabel jlab2 =  new JLabel(" Right side: ABCDEFGHIJKLMNOPQRSTUVWXYZ"); 
		      		 
		    // Set the minimum size for each label. 
		    jlab.setMinimumSize(new Dimension(90, 30));  
		    jlab2.setMinimumSize(new Dimension(90, 30));  
		 
		    // Create a split pane. 
		    JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jlab, jlab2); 

		    jfrm.add(jsp);  
		    jfrm.setVisible(true);  
		  }  
}
