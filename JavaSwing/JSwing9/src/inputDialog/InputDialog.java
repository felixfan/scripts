package inputDialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InputDialog {
	  JLabel jlab; 	  
	  JButton jbtnShow; 	  
	  JFrame jfrm; 	 
	  InputDialog() {       
	    jfrm = new JFrame("A Simple Input Dialog");      
	    jfrm.setLayout(new FlowLayout());       
	    jfrm.setSize(400, 250);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

	    jlab = new JLabel(); 
	    jbtnShow = new JButton("Show Dialog"); 
	 
	    // Add action listener for the button. 
	    jbtnShow.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	    	// Create a dialog that lets the user choose from a list of names. 
	    	// String[] names = { "Tom Jones", "Bob Smith", "Mary Doe", "Nancy Oliver" };
	        // String response = (String) JOptionPane.showInputDialog(jfrm, "Choose User", "Select User Name", JOptionPane.QUESTION_MESSAGE, null, names, "Bob Smith");
	    	  
	    	// Create a dialog that inputs a string. 
	        String response = JOptionPane.showInputDialog(jfrm,"Enter Name");
	        
	    	// with default input "Bob Smith"
	    	// String response = JOptionPane.showInputDialog(jfrm, "Enter Name", "Bob Smith");
	        

	 
	        // If the response is null, then the dialog was cancelled or closed. 
	        // If response is a zero-length string, then no input was entered. 
	        // Otherwise, response contains a string entered by the user. 
	        if(response == null) {
	        	jlab.setText("Dialog Cancelled or Closed"); 
	        } else if(response.length() == 0){
	        	jlab.setText("No string entered"); 
	        }else {
	        	jlab.setText("Hi there " + response); 
	        }	          
	      }     
	    });     
	 
	    jfrm.add(jbtnShow); 
	    jfrm.add(jlab); 
	    
	    jfrm.setVisible(true);    
	  }    

}
