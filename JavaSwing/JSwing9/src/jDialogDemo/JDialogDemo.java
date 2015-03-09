package jDialogDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogDemo {
	  JLabel jlab; 	  
	  JButton jbtnShow, jbtnReset; 
	 
	  // These buttons are contained within the dialog. 
	  JButton jbtnUp, jbtnDown; 
	 
	  JDialog jdlg; 
	 
	  JDialogDemo() {      
	    JFrame jfrm = new JFrame("JDialog Demo");      
	    jfrm.setLayout(new FlowLayout());       
	    jfrm.setSize(400, 200);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
	    jlab = new JLabel("Direction is pending."); 
	    
	    // Create button that will show the dialog. 
	    jbtnShow = new JButton("Show Dialog"); 
	 
	    // Create button that will reset the Direction 
	    jbtnReset = new JButton("Reset Direction"); 
	 
	    // Create a simple non-modal dialog. 
	    jdlg = new JDialog(jfrm, "Direction", true); 
	    jdlg.setSize(200, 100); 
	    jdlg.setLayout(new FlowLayout());    
	 
	    // Create buttons used by the dialog. 
	    jbtnUp = new JButton("Up"); 
	    jbtnDown = new JButton("Down"); 
	 
	    // Add buttons to the dialog. 
	    jdlg.add(jbtnUp); 
	    jdlg.add(jbtnDown); 
	 
	    // Add a label to the dialog. 
	    jdlg.add(new JLabel("Press a button.")); 
	 
	    // Show the dialog when the Show button is pressed. 
	    jbtnShow.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        jdlg.setVisible(true); 
	      }     
	    });     
	 
	    // Reset the direction when the Reset Direction button is pressed. 
	    jbtnReset.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        jlab.setText("Direction is Pending."); 
	      }     
	    });     
	 
	    // Respond to the Up button in the dialog. 
	    jbtnUp.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        jlab.setText("Direction is Up"); 
	 
	        // Hide the dialog after the user selects a direction.  
	        jdlg.setVisible(false); 
	      }     
	    });     
	 
	    // Respond to the Down button in the dialog. 
	    jbtnDown.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        jlab.setText("Direction is Down"); 
	 
	        // Hide the dialog after the user selects a direction. 
	        jdlg.setVisible(false); 
	      }     
	    });     
	 
	    jfrm.add(jbtnShow); 
	    jfrm.add(jbtnReset); 
	    jfrm.add(jlab); 
	    
	    jfrm.setVisible(true);    
	  }    

}
