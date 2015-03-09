package threadStopWatch;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ThreadStopWatch {
	  JLabel jlab; // display the elapsed time  	 
	  JButton jbtnStart, jbtnStop; // start/stop the stopwatch 
      long start; // holds the start time in milliseconds 	 
	  boolean running=false; // true when stopwatch is running 	 
	  Thread thrd; // reference to the timing thread 
	 
	  ThreadStopWatch() { 
	    JFrame jfrm = new JFrame("Thread-based Stopwatch"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(230, 90); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 
	    jlab = new JLabel("Press Start to begin timing."); 
	    jbtnStart = new JButton("Start"); 
	    jbtnStop = new JButton("Stop"); 
	 
	    // Initially disable the Stop button.  
	    jbtnStop.setEnabled(false); 
	 
	    // Create the Runnable instance that will become the second thread. 
	    Runnable myThread = new Runnable() { 
	      // This method will run in the separate thread. 
	      public void run() { 
	        try { 
	          // Report elapsed time every tenth of a second. 
	          for(; ; ) { 
	            // Pause for a tenth of a second. 
	            Thread.sleep(100);  
	 
	            // Invoke updateTime() on the event dispatching thread. 
	            SwingUtilities.invokeLater(new Runnable() {    
	              public void run() {  
	                updateTime(); 
	              }    
	            });    
	          } 
	        } catch(InterruptedException exc) { 
	          System.out.println("Call to sleep was interrupted."); 
	          System.exit(1); 
	        } 
	      } 
	    };  
	 
	    // Create a new thread. 
	    thrd = new Thread(myThread); 
	 
	    // Start the thread. 
	    thrd.start();    
	 
	    // Add the action listeners for the start and stop buttons. 
	    jbtnStart.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent ae) { 
	 
	        // Store start time. 
	        start = Calendar.getInstance().getTimeInMillis(); 
	 
	        // Reverse the state of the buttons. 
	        jbtnStop.setEnabled(true); 
	        jbtnStart.setEnabled(false); 
	 
	        // Start the stopwatch. 
	        running = true; 
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
	        running = false; 
	      } 
	    }); 
	 
	    jfrm.add(jbtnStart);  
	    jfrm.add(jbtnStop);  
	    jfrm.add(jlab); 
	 
	    jfrm.setVisible(true); 
	  } 
	 
	  // Update the elapsed time display. 
	  void updateTime() { 
	    if(!running) {
	    	return; 
	    }
	 
	    long temp = Calendar.getInstance().getTimeInMillis(); 
	    jlab.setText("Elapsed time is " + (double) (temp - start)/1000); 
	  } 
	   

}
