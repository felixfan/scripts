package confirmdialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConfirmDialog {
	  JLabel jlab; 
	  JButton jbtnShow; 
	  JFrame jfrm; 
	 
	  ConfirmDialog() {    
	    jfrm = new JFrame("A Confirmation Dialog");   
	    jfrm.setLayout(new FlowLayout());      
	    jfrm.setSize(400, 250);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	 
	    // Create a label that will show the user's response. 
	    jlab = new JLabel(); 
	    
	    // Create button that will display the dialog. 
	    jbtnShow = new JButton("Show Dialog"); 
	 
	    // Add action listener for the button. 
	    jbtnShow.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        // Create a confirmation dialog. 
	    	// yes/no/cancel
	    	int response = JOptionPane.showConfirmDialog(jfrm, "Remove unused files?");
	    	
	    	// yes/no
	        // int response = JOptionPane.showConfirmDialog(jfrm, "Remove unused files?", "Disk Space is Low", JOptionPane.YES_NO_OPTION); 
	 
	        // Show the response. 
	        switch(response) { 
	          case JOptionPane.YES_OPTION:{
	            	jlab.setText("You answered Yes."); 
		            break;
	            }
	          case JOptionPane.NO_OPTION:{
		            jlab.setText("You answered No."); 
		            break; 
	          }
	          case JOptionPane.CANCEL_OPTION:{
		            jlab.setText("Cancel pressed."); 
		            break; 
	          }
	          case JOptionPane.CLOSED_OPTION:{
		            jlab.setText("Dialog closed without response."); 
		            break;
	          } 
	        } 
	      }     
	    });     
	 
	    jfrm.add(jbtnShow); 
	    jfrm.add(jlab); 
	    
	    jfrm.setVisible(true);    
	  }    

}
