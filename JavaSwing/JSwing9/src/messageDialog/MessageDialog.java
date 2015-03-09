package messageDialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MessageDialog {
	  JLabel jlab; 
	  JButton jbtnShow; 
	  JFrame jfrm; 
	 
	  MessageDialog() {        
	    jfrm = new JFrame("Simple Message Dialog");     
	    jfrm.setLayout(new FlowLayout());     
	    jfrm.setSize(200, 200);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	 
	    // Create a label that will shows when the dialog returns. 
	    jlab = new JLabel(); 
	    
	    // Create button that will display the dialog. 
	    jbtnShow = new JButton("Show Dialog"); 
	 
	    // Add action listener for the button. 
	    jbtnShow.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        // Create a dialog that shows a message. 
	        JOptionPane.showMessageDialog(jfrm, "Disk Space is Low."); 
	  
	        // This statement won't execute until the call to showMessageDialog() returns. 
	        jlab.setText("Dialog Closed"); 
	      }     
	    });     
	 
	    // Add the button and label to the content pane. 
	    jfrm.add(jbtnShow); 
	    jfrm.add(jlab); 
	   
	    jfrm.setVisible(true);    
	  }    

}
