package customjpanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel jlab;    
	  JButton jbtnRed,jbtnBlue;  
	   
	  CustomJPanel() {   
	 
	    // Ensure that the panel is opaque. 
	    setOpaque(true); 
	 
	    // Start with a green, 5-pixel border. 
	    setBorder(BorderFactory.createLineBorder(Color.GREEN, 5)); 
 
	    jlab = new JLabel("Select Border Color");   
 
	    jbtnRed = new JButton("Red"); 
	    jbtnBlue = new JButton("Blue");   
	  
	    jbtnRed.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        setBorder(BorderFactory.createLineBorder(Color.RED, 5)); 	          
	      }  
	    });  
	  
	    jbtnBlue.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        setBorder(BorderFactory.createLineBorder(Color.BLUE, 5)); 
	      }  
	    });  

	    add(jbtnRed);    
	    add(jbtnBlue);    
	    add(jlab); 
	 
	  } 
	} 
	 
	// Create a top-level container and use the panel created by CustomJPanel as the content pane. 
	class CustomJPanelDemo { 
		CustomJPanelDemo() { 
	    JFrame jfrm = new JFrame("Set the Content Pane"); 
	    jfrm.setSize(240, 150);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	   
	    // Create an instance of the custom content pane. 
	    CustomJPanel mcp = new CustomJPanel(); 
	 
	    // Make mcp the content pane. 
	    jfrm.setContentPane(mcp); 
	 
	    jfrm.setVisible(true);   
	  }
}
