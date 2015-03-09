

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonDemo implements ActionListener {
	JLabel jlab;
	ButtonDemo(){
		// Create a new JFrame container.
		JFrame jfrm =new JFrame("Button Demo");
	 
	    // Specify FlowLayout for the layout manager. 
		jfrm.getContentPane().setLayout(new FlowLayout());
	 
	    // Give the frame an initial size. 
		jfrm.setSize(200,90);
	 
	    // Terminate the program when the user closes the application. 
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	    // Make two buttons. 
		JButton jbtn1 = new JButton("First");
		JButton jbtn2 = new JButton("Second");
	 
	    // Add action listeners. 
	    jbtn1.addActionListener(this); 
	    jbtn2.addActionListener(this); 
	 
	    // Add the buttons to the content pane. 
	    jfrm.getContentPane().add(jbtn1);  
	    jfrm.getContentPane().add(jbtn2);  
	 
	    // Create a text-based label. 
	    jlab = new JLabel("Press a button."); 
	 
	    // Add the label to the frame. 
	    jfrm.getContentPane().add(jlab); 
	 
	    // Display the frame. 
	    jfrm.setVisible(true); 
	}
	
	// Handle button events. 
	  public void actionPerformed(ActionEvent ae) { 
	    
	    if(ae.getActionCommand().equals("First"))  
	      jlab.setText("First button was pressed."); 
	    else 
	      jlab.setText("Second button was pressed. "); 
	  } 
}
