package progressBarDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarDemo {
	  JLabel jlabVert,jlabHoriz; 
	  JProgressBar jprogHoriz,jprogVert; 
	 
	  JButton jbtn; 
	  
	  ProgressBarDemo() {   
	    JFrame jfrm = new JFrame("Demonstrate Progress Bars");  
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(280, 270);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    // Create default vertical and horizontal progress bar. 
	    jprogVert = new JProgressBar(JProgressBar.VERTICAL); 
	    jprogHoriz = new JProgressBar(); // horizontal by default 
	 
	    // Display the percentage string. 
	    jprogVert.setStringPainted(true); 
	    jprogHoriz.setStringPainted(true); 
	 
	    jbtn = new JButton("Push Me"); 
	 
	    // These labels display the current progress bar value. 
	    jlabHoriz = new JLabel("Value of horizontal progress bar: " + jprogHoriz.getValue());  	                           
	    jlabVert = new JLabel("Value of vertical progress bar: " + jprogVert.getValue());  
	                          	 
	    // Increment the progress bars each time the Push Me button is pressed.  
	    // When the value reaches the maximum, no further action is taken. 
	    jbtn.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        int hVal = jprogHoriz.getValue(); 
	        int vVal = jprogVert.getValue(); 
	 
	        if(hVal >= jprogHoriz.getMaximum()) {
	        	return; 
	        }else{
	        	jprogHoriz.setValue(hVal + 10); 
	        }
	 
	        if(vVal >= jprogHoriz.getMaximum()) {
	        	return; 
	        }else{
	        	jprogVert.setValue(vVal + 10); 
	        }
	        	 
	        jlabHoriz.setText("Value of horizontal progress bar: " + jprogHoriz.getValue());           
	        jlabVert.setText("Value of vertical progress bar: " + jprogVert.getValue());                 
	      } 
	    });  
	 
	    jfrm.add(jprogHoriz); 
	    jfrm.add(jprogVert); 
	    jfrm.add(jlabHoriz); 
	    jfrm.add(jlabVert); 
	    jfrm.add(jbtn); 

	    jfrm.setVisible(true);  
	  }  
}
