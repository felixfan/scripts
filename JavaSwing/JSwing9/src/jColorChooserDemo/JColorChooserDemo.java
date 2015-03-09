package jColorChooserDemo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JColorChooserDemo {
	  JLabel jlab; 
	  JButton jbtnShow; 
	 
	  JColorChooserDemo() {    	  
	    JFrame jfrm = new JFrame("Color Chooser Demo");  	   	   
	    jfrm.setLayout(new FlowLayout());       
	    jfrm.setSize(400, 200);     
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	 
	    // Create a label that will show the color chooser. 
	    jlab = new JLabel(); 
	    
	    // Create button that will show the dialog. 
	    jbtnShow = new JButton("Show Color Chooser"); 
	 
	    // Show the color chooser when the Show button is pressed. 
	    jbtnShow.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent le) { 
	        // Pass null for the parent. This centers the dialog on the screen. The initial color is red. 
	        Color color = JColorChooser.showDialog(null, "Choose Color", Color.RED); 
	 
	        if(color != null) {
		        jlab.setText("Selected color is " + color.toString()); 
	        } else {
	            jlab.setText("Color selection was cancelled."); 
	        }
	         
	      }     
	    });  

	    jfrm.add(jbtnShow); 
	    jfrm.add(jlab);   
	    jfrm.setVisible(true);    
	  }    

}
