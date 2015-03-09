package customcellrenderer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable jtab, Object v, boolean selected, boolean focus, int r, int c) { 
	 
	    // Get the default component so it can be customized. 
	    JLabel rendComp =  (JLabel) super.getTableCellRendererComponent(jtab, v, selected, focus, r, c); 
	 
	    // Obtain a formatter. 
	    NumberFormat nf = NumberFormat.getNumberInstance(); 
	 
	    // Display 4 decimal places. 
	    nf.setMaximumFractionDigits(4); 
	    nf.setMinimumFractionDigits(4); 
	 
	    // Set the text in the label to the formatted value. 
	    rendComp.setText(nf.format(v)); 
	 
	    // Return the customized renderer. 
	    return rendComp; 
	  } 
	} 
	 
	// Create a model that provides the numeric data. 
	class NumInfoModel extends AbstractTableModel { 
		private static final long serialVersionUID = 1L;

	int numRows; 
	 
	  String colNames[] = { "Value", "Prime", "Square", "Square Root" }; 
	 
	  NumInfoModel(int len) { 
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
	      if(isPrime(r+2)) return "Yes"; 
	      else return "No"; 
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
	 
	  // This returns the Double class for square root column. Returns Object for the others. 
	public Class<?> getColumnClass(int c) { 
	    if(c==3) {
	    	return Double.class; 
	    } else {
	    	return Object.class; 
	    }
	  } 
	}  
	 
	class CellRendererDemo {  	 
	  JTable jtabNumInfo;     
	  CellRendererDemo() {       
	    JFrame jfrm = new JFrame("Use a Custom Cell Renderer");     
	    jfrm.setLayout(new FlowLayout());       
	    jfrm.setSize(500, 200);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    jtabNumInfo = new JTable(new NumInfoModel(99)); 
	 
	    // Add a custom cell renderer for double values. 
	    jtabNumInfo.setDefaultRenderer(Double.class, new CustomCellRenderer()); 
	 
	    // Wrap the data in a scroll pane. 
	    JScrollPane jscrlp = new JScrollPane(jtabNumInfo); 
	 
	    // Set the viewport size. 
	    jtabNumInfo.setPreferredScrollableViewportSize(new Dimension(450, 110)); 
	 
	    jfrm.add(jscrlp); 
   
	    jfrm.setVisible(true);    
	  }    
	     

}
