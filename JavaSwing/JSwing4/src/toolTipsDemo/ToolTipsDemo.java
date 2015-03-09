package toolTipsDemo;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ToolTipsDemo {
	  ToolTipsDemo() {  
		    JFrame jfrm = new JFrame("Add Tooltips");   
		    jfrm.setLayout(new FlowLayout());   
		    jfrm.setSize(300, 150);    
		    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		    JButton jbtnAlpha = new JButton("Alpha"); 
		    JButton jbtnBeta = new JButton("Beta"); 
		 
		    // Set tooltips. 
		    jbtnAlpha.setToolTipText("This activates the Alpha option."); 
		    jbtnBeta.setToolTipText("This activates the Beta option."); 
		 
		    jfrm.add(jbtnAlpha); 
		    jfrm.add(jbtnBeta); 
		    jfrm.setVisible(true);  
		  }  
		 
}
