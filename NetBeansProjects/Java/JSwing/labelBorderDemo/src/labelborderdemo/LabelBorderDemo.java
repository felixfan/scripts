package labelborderdemo;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelBorderDemo {
	LabelBorderDemo(){  
	    JFrame jfrm = new JFrame("Use Line and Etched Borders");   
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(280, 280);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    JLabel jlab0 = new JLabel("          Empty Border       ");
	  
	    JLabel jlab1 = new JLabel(" This uses a line border. ");
	    jlab1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    JLabel jlab2 = new JLabel(" This uses a line border. ");
	    jlab2.setBorder(BorderFactory.createLineBorder(Color.RED));
	  
	    JLabel jlab3 = new JLabel(" This uses an etched border. ");  
	    jlab3.setBorder(BorderFactory.createEtchedBorder());
	    
	    JLabel jlab4 = new JLabel(" This uses a Lowered Bevel border. ");  
	    jlab4.setBorder(BorderFactory.createLoweredBevelBorder());
	    
	    JLabel jlab5 = new JLabel(" This uses a Raised Bevel border. ");  
	    jlab5.setBorder(BorderFactory.createRaisedBevelBorder());
	    
	    jfrm.add(jlab0);
	    jfrm.add(jlab1);  
	    jfrm.add(jlab2); 
	    jfrm.add(jlab3);
	    jfrm.add(jlab4);
	    jfrm.add(jlab5);
	  
	    jfrm.setVisible(true); 
	}

}
