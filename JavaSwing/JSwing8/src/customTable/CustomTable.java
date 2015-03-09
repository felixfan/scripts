package customTable;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CustomTable extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	int numRows; 
	  
	  String colNames[] = { "Value", "Prime", "Square", "Square Root" }; 
	 
	  CustomTable(int len) { 
	    super(); 
	    numRows = len; 
	  } 
	     
	  public int getRowCount() { return numRows; } 
	  public int getColumnCount() { return 4; } 
	 
	  // Return the name of the column as specified by the colNames array. 
	  public String getColumnName(int c) { 
	    return colNames[c]; 
	  } 
	 
	  // For column 0, return the row number + 2. 
	  // For column 1, return "Yes" if column 1 is prime. 
	  // For column 2, return the square of column 1. 
	  // For column 3, return the square root of column 1. 
	  public Object getValueAt(int r, int c) { 
	 
	    if(c==0) {
	    	return new Integer(r+2); 
	    }else if(c==1) { 
	      if(isPrime(r+2)){
	    	  return "Yes"; 
	      }else {
	    	  return "No"; 
	      }
	    }else if(c==2) {
	    	return new Integer((r+2) * (r+2)); 
	    }else {
	    	return new Double(Math.sqrt(r+2)); 
	    }
	  } 
	 
	  // Return true if v is prime. 
	  boolean isPrime(int v) { 
	    int i; 
	 
	    for(i=2; i <= v/i; i++){
		      if((v%i) == 0) {
		    	  return false; 
		      } 
	    }	 
	    return true;
	  } 
	}  
	 
	class NumInfoTable {  
	 
	  JTable jtabNumInfo; 
	    
	  NumInfoTable() {      
	    JFrame jfrm = new JFrame("Use a Custom Table Model");    
	    jfrm.setLayout(new FlowLayout());     
	    jfrm.setSize(500, 200);      
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
	    // Create a table that uses NumInfoModel to display information on the values 2 through 100 
	    jtabNumInfo = new JTable(new CustomTable(99)); 

	    JScrollPane jscrlp = new JScrollPane(jtabNumInfo); 
	 
	    // Set the viewport size. 
	    jtabNumInfo.setPreferredScrollableViewportSize(new Dimension(450, 110)); 
	 
	    // Add the table to the content pane.  
	    jfrm.add(jscrlp); 
	 
	    // Display the frame.    
	    jfrm.setVisible(true);    
	  } 

}
