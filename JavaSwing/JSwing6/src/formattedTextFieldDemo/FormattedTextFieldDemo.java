package formattedTextFieldDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class FormattedTextFieldDemo {
	  NumberFormat cf; 
	  DateFormat df; 	 
	  JLabel jlab; 	  
	  JFormattedTextField jftfSalary, jftfDate, jftfEmpID; 	  
	  JButton jbtnShow; 	 
	  public FormattedTextFieldDemo() { 
	    JFrame jfrm = new JFrame("JFormattedTextField"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(240, 300); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    jlab = new JLabel(); 
	 
	    // Create a formatted text field for employee ID. 
	    // This uses a mask formatter. 
	    try { 
	      MaskFormatter mf = new MaskFormatter("##-###"); 
	      jftfEmpID = new JFormattedTextField(mf); 
	    } catch (ParseException exc) { 
	      System.out.println("Invalid Format"); 
	      return; 
	    } 
	    jftfEmpID.setColumns(15); 
	    jftfEmpID.setValue("24-895"); 
	 
	    // Create a formatted text field for money. 
	    // This uses a currency formatter. 
	    cf = NumberFormat.getCurrencyInstance(); 
	    cf.setMaximumIntegerDigits(5); 
	    cf.setMaximumFractionDigits(2); 
	    jftfSalary = new JFormattedTextField(cf); 
	    jftfSalary.setColumns(15); 
	    jftfSalary.setValue(new Integer(7000)); 
	 
	    // Create a formatted text field for date. 
	    // This uses a date formatter. 
	    df = DateFormat.getDateInstance(DateFormat.MEDIUM); 
	    jftfDate = new JFormattedTextField(df); 
	    jftfDate.setColumns(15); 
	    jftfDate.setValue(new Date()); // init to current date 
	     
	    // Add property change listener for the employee ID field. 
	    jftfEmpID.addPropertyChangeListener("value",  new PropertyChangeListener() {    
	      public void propertyChange(PropertyChangeEvent pe) {    
	        jlab.setText("Employee ID changed."); 
	      }    
	    }); 
	 
	    // Add property change listener for the salary field. 
	    jftfSalary.addPropertyChangeListener("value", new PropertyChangeListener() {    
	      public void propertyChange(PropertyChangeEvent pe) {    
	        jlab.setText("Monthly salary changed."); 
	      }    
	    }); 
	 
	    // Add property change listener for the date field. 
	    jftfDate.addPropertyChangeListener("value", new PropertyChangeListener() {    
	      public void propertyChange(PropertyChangeEvent pe) {    
	        jlab.setText("Date hired changed."); 
	      }    
	    }); 
	 
	    // Create the Show Updates button. 
	    jbtnShow = new JButton("Show Updates"); 
	 
	    // Add action listener for the Show Updates button. 
	    jbtnShow.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {    
	        // Display formatted contents. 
	    	// Note that the salary and date info is formatted using the same formatters as the edit fields.
	        // The value retrieved from the employee ID field is already formatted. 
	        jlab.setText("<html>Employee ID: " + jftfEmpID.getValue() +  
	                     "<br>Monthly Salary: " + cf.format(jftfSalary.getValue()) + 
	                     "<br>Date Hired: " + df.format(jftfDate.getValue())); 
	      }    
	    });  
	 
	    jfrm.add(new JLabel("Employee ID")); 
	    jfrm.add(jftfEmpID);  
	    jfrm.add(new  JLabel("Monthly Salary")); 
	    jfrm.add(jftfSalary); 
	    jfrm.add(new JLabel("Date Hired")); 
	    jfrm.add(jftfDate); 
	    jfrm.add(jbtnShow); 
	    jfrm.add(jlab); 
	 
	    jfrm.setVisible(true); 
	  } 
	 
}
