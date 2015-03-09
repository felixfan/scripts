package jpasswordfielddemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class JPasswordFieldDemo {
	  JLabel jlabPW; 	  
	  JPasswordField jpswd; 
	 
	  public JPasswordFieldDemo() { 
	    JFrame jfrm = new JFrame("Use JPasswordField"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(240, 100); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	    jlabPW = new JLabel("Enter Password"); 
	    jpswd = new JPasswordField(15); 
	 
	    // Add an action listener for the password field. 
	    // Each time the user presses enter, the contents of the password field are checked against the password.  
	    jpswd.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {    
	        char pw[] = { 't', 'e', 's', 't' }; 	 
	        char userSeq[] = jpswd.getPassword(); 
	 
	        // Test for valid password. 
	        if(Arrays.equals(userSeq, pw)){
	        	jlabPW.setText("Password Valid"); 
	        }else{
	        	jlabPW.setText("Password Invalid -- Try Again"); 
	        	jpswd.setText(null);
	        }
	 
	        // Clear both arrays on exit. 
	        Arrays.fill(pw, (char) 0); 
	        Arrays.fill(userSeq, (char) 0); 
	      }    
	    });    
	 
	    jfrm.add(jpswd);  
	    jfrm.add(jlabPW); 
	    jfrm.setVisible(true); 
	  } 
}
