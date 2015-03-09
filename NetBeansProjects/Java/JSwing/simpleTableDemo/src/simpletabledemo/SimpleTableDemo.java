package simpletabledemo;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class SimpleTableDemo {
	String[] headings = { "From", "Address", "Subject", "Size" }; 
	 
	  Object[][] data = { 
	        { "Wendy", "Wendy@HerbSchildt.com", "Hello Herb", new Integer(287) }, 
	        { "Alex", "Alex@HerbSchildt.com", "Check this out!", new Integer(308) }, 
	        { "Hale", "Hale@HerbSchildt.com", "Found a bug", new Integer(887) }, 
	        { "Todd", "Todd@HerbSchildt.com", "Did you see this?", new Integer(223) }, 
	        { "Steve", "Steve@HerbSchildt.com", "I'm back", new Integer(357) }, 
	        { "Ken", "Ken@HerbSchildt.com", "Arrival time change", new Integer(512) } 
	  }; 
	 
	  JTable jtabEmail; 
	 
	  SimpleTableDemo() {       
	    JFrame jfrm = new JFrame("Simple Table Demo");     
	    jfrm.setLayout(new FlowLayout());      
	    jfrm.setSize(500, 160);      
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
	    // Create a table that displays the e-mail data. 
	    jtabEmail = new JTable(data, headings); 
	 
	    // Wrap the data in a scroll pane. 
	    JScrollPane jscrlp = new JScrollPane(jtabEmail); 
	 
	    // Set the scrollable viewport size. 
	    jtabEmail.setPreferredScrollableViewportSize(new Dimension(460, 80)); 
	    
	    // change the table selection mode
	    
	    // jtabEmail.setColumnSelectionAllowed(true); // enable column selection
	    // jtabEmail.setRowSelectionAllowed(false); // disable row selection, default is on	    
	    jtabEmail.setCellSelectionEnabled(true); // enable cell selection
	    // jtabEmail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // only one row can be selected
	    // jtabEmail.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // a single range can be selected
	    jtabEmail.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // multiple ranges can be selected
	 
	    jfrm.add(jscrlp); 
	    
	    jfrm.setVisible(true);    
	  }    

}
