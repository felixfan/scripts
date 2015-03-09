package timerstopwatch;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerStopWatch {
	  JLabel jlab; // display the elapsed time 	 
	  JButton jbtnStart, jbtnStop; // start/stop the stopwatch  	 
	  long start; // holds the start time in milliseconds 	 
	  Timer swTimer; // the timer for the stopwatch 
	 
	  TimerStopWatch() { 
	    JFrame jfrm = new JFrame("Timer-based Stopwatch"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(230, 90);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    jlab = new JLabel("Press Start to begin timing."); 	
	    jbtnStart = new JButton("Start"); 
	    jbtnStop = new JButton("Stop"); 
	    jbtnStop.setEnabled(false); 
	 
	    // This action listener is called when the timer goes off. 
	    ActionListener timerAL = new ActionListener() { 
	      public void actionPerformed(ActionEvent ae) { 
	        updateTime(); 
	      } 
	    }; 
	 
	    // Create a timer that goes off every tenth of a second. 
	    swTimer = new Timer(100, timerAL); 
	 
	    // Add the action listeners for the start and stop buttons. 
	    jbtnStart.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent ae) { 
	 
	        // Store start time. 
	        start = Calendar.getInstance().getTimeInMillis(); 
	 
	        // Reverse the state of the buttons. 
	        jbtnStop.setEnabled(true); 
	        jbtnStart.setEnabled(false); 
	 
	        // Start the stopwatch. 
	        swTimer.start(); 
	      } 
	    }); 
	 
	    jbtnStop.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent ae) { 
	        long stop = Calendar.getInstance().getTimeInMillis(); 
	 
	        // Compute the elapsed time. 
	        jlab.setText("Elapsed time is " + (double) (stop - start)/1000); 
	 
	        // Reverse the state of the buttons. 
	        jbtnStart.setEnabled(true); 
	        jbtnStop.setEnabled(false); 
	 
	        // Stop the stopwatch. 
	        swTimer.stop(); 
	      } 
	    }); 

	    jfrm.add(jbtnStart);  
	    jfrm.add(jbtnStop);  
	    jfrm.add(jlab); 
	 
	    jfrm.setVisible(true); 
	  } 
	 
	  // Update the elapsed time display. Notice that the running variable is no longer needed. 
	  void updateTime() { 
	    long temp = Calendar.getInstance().getTimeInMillis(); 
	    jlab.setText("Elapsed time is " + (double) (temp - start)/1000); 
	  } 

}
