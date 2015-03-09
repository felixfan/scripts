package progressBarIndeterminateDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarIndeterminateDemo {
	  JLabel jlabVert,jlabHoriz; 
	  JProgressBar jprogHoriz,jprogVert; 
	 
	  JButton jbtn1, jbtn2; 
	  
	  ProgressBarIndeterminateDemo() {   
	    JFrame jfrm = new JFrame("Demonstrate Progress Bars");  
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(350, 300);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    // Create default vertical and horizontal progress bar. 
	    jprogVert = new JProgressBar(JProgressBar.VERTICAL); 
	    jprogHoriz = new JProgressBar(); // horizontal by default 
	 
	    // Display the percentage string. 
	    // jprogVert.setStringPainted(true); 
	    // jprogHoriz.setStringPainted(true); 
	    
	    // Indeterminate state
	    jprogVert.setIndeterminate(false);
	    jprogHoriz.setIndeterminate(false);
	 
	    jbtn1 = new JButton("Start"); 
	    jbtn2 = new JButton("Stop"); 
	    
	    jbtn2.setEnabled(false);
	 
	    // These labels display the current progress bar status. 
	    jlabHoriz = new JLabel("Value of horizontal progress bar: indeterminate state is off");  	                           
	    jlabVert = new JLabel("Value of vertical progress bar: indeterminate state is off");  
	                          	 
	    jbtn1.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	  	    jprogVert.setIndeterminate(true);
		    jprogHoriz.setIndeterminate(true);	 
		    jbtn1.setEnabled(false);
		    jbtn2.setEnabled(true);
	        jlabHoriz.setText("Value of horizontal progress bar: indeterminate state is on");           
	        jlabVert.setText("Value of vertical progress bar: indeterminate state is on");                 
	      } 
	    }); 
	    
	    jbtn2.addActionListener(new ActionListener() {  
		      public void actionPerformed(ActionEvent ae) {  
		  	    jprogVert.setIndeterminate(false);
			    jprogHoriz.setIndeterminate(false);	 
			    jbtn1.setEnabled(true);
			    jbtn2.setEnabled(false);
		        jlabHoriz.setText("Value of horizontal progress bar: indeterminate state is off");           
		        jlabVert.setText("Value of vertical progress bar: indeterminate state is off");                 
		      } 
		    }); 
	 
	    jfrm.add(jprogHoriz); 
	    jfrm.add(jprogVert); 
	    jfrm.add(jlabHoriz); 
	    jfrm.add(jlabVert); 
	    jfrm.add(jbtn1); 
	    jfrm.add(jbtn2); 

	    jfrm.setVisible(true);  
	  }  
}
