package listmodeldemo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListModelDemo {
	  JList<String> jlst;  
	  JLabel jlab;  
	  JScrollPane jscrlp;  
	  JButton jbtnBuy,jbtnAddDel;  
	  
	  ListModelDemo() {   
	    JFrame jfrm = new JFrame("JList ModelDemo");      
	    jfrm.setLayout(new FlowLayout());   
	    jfrm.setSize(180, 240);     
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	 
	    // Create and populate a list model.   

	    // First, create an instance of DefaultListModel. 
	    DefaultListModel<String> lm = new DefaultListModel<String>(); 
	 
	    // Now, add items to the model. 
	    lm.addElement("Winesap"); 
	    lm.addElement("Cortland"); 
	    lm.addElement("Red Delicious"); 
	    lm.addElement("Golden Delicious"); 
	    lm.addElement("Gala"); 
	 
	    // Create a JList by specifying the model. 
	    jlst = new JList<String>(lm);  
	  
	    jscrlp = new JScrollPane(jlst);  
	    jscrlp.setPreferredSize(new Dimension(120, 90));  
	  
	    // Make a label that displays the selection.  
	    jlab = new JLabel("Please Choose an Apple");  
	  
	    // Add selection listener for the list.  
	    jlst.addListSelectionListener(new ListSelectionListener() {   
	      public void valueChanged(ListSelectionEvent le) {   
	        String what = "";  

	        List<String> values = jlst.getSelectedValuesList();
	  
	        // Confirm that one or more items have been selected.  
	        if(values.isEmpty()) {  
	          jlab.setText("Please Choose an Apple.");  
	          return;  
	        }  
	  
	        // Display the selected items.  
	        for(String value:values){
	        	 what += value+ "<br>";  	       	  
	        }	         
	        jlab.setText("<html>Current selection:<br>" + what);  
	      }   
	    });   
	  
	    // Make a button that "buys" the selected apple.  
	    jbtnBuy = new JButton("Buy Apple");  
	  
	    // Add action listener for Buy Apple button.  
	    jbtnBuy.addActionListener(new ActionListener() {   
	      public void actionPerformed(ActionEvent ae) {   
	        String what = "";  
	  
	        // Get the index of the changed item.   
	        List<String> values = jlst.getSelectedValuesList();
	        // Confirm that one or more items have been selected.  
	        if(values.isEmpty()) {  
	          jlab.setText("No apple has been selected.");  
	          return;  
	        }  
	  
	        // Display the selected items.  
	        for(String value:values) { 
	        	   what += value + "<br>";  
	        }
	       
	        jlab.setText("<html>Apples Purchased:<br>" + what);  
	      }   
	    });   
	 
	    // Make a button that adds more apple selections.  
	    jbtnAddDel = new JButton("Add More Varieties");  
	  
	    // Add action listener for Add More Apples button.  
	    jbtnAddDel.addActionListener(new ActionListener() {   
	      public void actionPerformed(ActionEvent ae) {   
	 
	        // Get a reference to the model. 
	        DefaultListModel<String> lm = (DefaultListModel<String>) jlst.getModel();  
	 
	        // See if extra varieties already added. 
	        if(lm.getSize() > 5) { 
	          // If so, remove extra varieties. 
	          for(int i=7; i > 4; i--) lm.remove(i); 	  
	          jbtnAddDel.setText("Add More Varieties"); 
	        } else { 
	          // Add extra varieties. 
	          lm.addElement("Fuji"); 
	          lm.addElement("Granny Smith"); 
	          lm.addElement("Jonathan"); 
	          jbtnAddDel.setText("Remove Extra Varieties"); 
	        }  
	      }   
	    });   
	  
	    // Add the list and label to the content pane.  
	    jfrm.add(jscrlp);  
	    jfrm.add(jbtnBuy);  
	    jfrm.add(jbtnAddDel);  
	    jfrm.add(jlab);  
   
	    jfrm.setVisible(true);   
	  }   
}
