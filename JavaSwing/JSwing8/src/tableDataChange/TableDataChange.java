package tableDataChange;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableDataChange {
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
	  JLabel jlab1, jlab2;
	  TableModel tm;
	 
	  TableDataChange() {       
	    JFrame jfrm = new JFrame("Table Model Events Demo");     
	    jfrm.setLayout(new FlowLayout());      
	    jfrm.setSize(500, 200);      
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
	    jlab1 = new JLabel();
	    jlab1.setPreferredSize(new Dimension(400, 20));
	    jlab1.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    jlab2 = new JLabel();
	    
	    // Create a table that displays the e-mail data. 
	    jtabEmail = new JTable(data, headings); 
	 
	    // Wrap the data in a scroll pane. 
	    JScrollPane jscrlp = new JScrollPane(jtabEmail); 
	 
	    // Set the scrollable viewport size. 
	    jtabEmail.setPreferredScrollableViewportSize(new Dimension(460, 80)); 
	    
	    // change the table selection mode
	    
	    // jtabEmail.setColumnSelectionAllowed(true); // enable column selection
	    // jtabEmail.setRowSelectionAllowed(false); // disable row selection, default is on	    
	    // jtabEmail.setCellSelectionEnabled(true); // enable cell selection
	    // jtabEmail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // only one row can be selected
	    // jtabEmail.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // a single range can be selected
	    // jtabEmail.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // multiple ranges can be selected

	    // Get the list selection model for row selections. 
	    ListSelectionModel listSelMod = jtabEmail.getSelectionModel(); 
	    // Listen for row selection events. 
	    listSelMod.addListSelectionListener(new ListSelectionListener() {    
	      public void valueChanged(ListSelectionEvent le) {   
	        String str = "Selected Row(s): "; 
	 
	        // Get a list of all selected rows. 
	        int[] rows = jtabEmail.getSelectedRows(); 
	 
	        // Create a string that contains the indices. 
	        for(int i=0; i < rows.length; i++) {
	        	str += rows[i] + " "; 
	        }
	 
	        // Display the indices of the selected rows. 
	        jlab1.setText(str); 
	      }    
	    });  
	    
	    // Get the table model. 
	    tm = jtabEmail.getModel(); 
	 
	    // Add a table model listener. 
	    tm.addTableModelListener(new TableModelListener() { 
	      public void tableChanged(TableModelEvent tme) { 
	        if(tme.getType() == TableModelEvent.UPDATE) { 
	          jlab2.setText("Cell " + tme.getFirstRow() + ", " + tme.getColumn() + " changed." + " The new value: " + tm.getValueAt(tme.getFirstRow(), tme.getColumn())); 
	          }  
	        } 
	    }); 
	    
	    
	    jfrm.add(jscrlp); 
	    jfrm.add(jlab1);
	    jfrm.add(jlab2);
	    
	    jfrm.setVisible(true);    
	  }    

}
