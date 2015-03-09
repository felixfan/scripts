package spinnerdates;

import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerDates {
	  JSpinner jspin; 
	  JLabel jlab; 
	 
	  SpinnerDates() {  
	    JFrame jfrm = new JFrame("Spin Dates");     
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(300, 120);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	 
	    // Create a Calendar object that contains the current date. 
	    GregorianCalendar g = new GregorianCalendar(); 
	 
	    // Get the current date. 
	    Date curDate = new Date(); 
	 
	    // Set start date one month prior to current date and end date one month after current date. 
	    g.add(Calendar.MONTH, -1);  
	    Date begin = g.getTime(); 
	    g.add(Calendar.MONTH, 2); 
	    Date end = g.getTime(); 
	 
	    // Create a date spinner model. 
	    SpinnerDateModel spm = new SpinnerDateModel(curDate, begin, end, Calendar.HOUR); 
	      	  
	    // Create a JSpinner using the model. 
	    jspin = new JSpinner(spm); 
	 
	    // Make a label that displays the selected date. 
	    jlab = new JLabel(" Selected date is: " + curDate); 
	 
	    // Add change listener for the spinner. 
	    jspin.addChangeListener(new ChangeListener() {  
	      public void stateChanged(ChangeEvent ce) {  
	        // Get the date. 
	        Date date = (Date) jspin.getValue(); 
	 
	        // Report the date. 
	        jlab.setText(" Selected date is: " + date + " "); 
	      }  
	    });  

	    jfrm.add(jspin); 
	    jfrm.add(jlab); 
	    jfrm.setVisible(true);  
	  }  
}
