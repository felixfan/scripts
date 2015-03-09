package jListDemo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo {	 
	  JLabel jlab; 
	  JScrollPane jscrlp; 
	  JButton jbtnBuy; 
	 
	  // Create an array of apple varieties. 
	  String apples[] = { "Winesap", "Cortland", "Red Delicious",  
	                      "Golden Delicious", "Gala", "Fuji", 
	                      "Granny Smith", "Jonathan" }; 
	  
	  JList<String> jlst = new JList<String>(apples); // add type to JList
	  
	  JListDemo() {  
	    JFrame jfrm = new JFrame("JList Demo");    
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(204, 250);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	     /*
	    // Set the list selection mode to single-selection. 
	    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	    */
	 
	    // Add list to a scroll pane. 
	    jscrlp = new JScrollPane(jlst); 
	 
	    // Set the preferred size of the scroll pane. 
	    jscrlp.setPreferredSize(new Dimension(120, 90)); 
	 
	    // Make a label that displays the selection. 
	    jlab = new JLabel("Please Choose an Apple"); 
	 
	    // Add selection listener for the list. 
	    jlst.addListSelectionListener(new ListSelectionListener() {  
	      public void valueChanged(ListSelectionEvent le) { 
	    	/*  
	        // Get the index of the changed item. 
	        int idx = jlst.getSelectedIndex(); 
	 
	        // Display selection, if item was selected. 
	        if(idx != -1) {
	        	jlab.setText("Current selection: " + apples[idx]);
	        }else{
	        	jlab.setText("Please Choose an Apple"); 
	        }
	        */
	    	  String what = ""; 
	    	  
	          // Get the index of the changed item. 
	          int indices[] = jlst.getSelectedIndices(); 
	   
	          // Confirm that one or more items have been selected. 
	          if(indices.length == 0) { 
	            jlab.setText("Please Choose an Apple."); 
	            return; 
	          } 
	   
	          // Display the selected items. 
	          for(int i = 0; i < indices.length; i++) 
	            what += apples[indices[i]] + "<br>"; 
	   
	          jlab.setText("<html>Current selection:<br>" + what); 
	      } 	    	  
	    });  
	 
	    // Make a button that "buys" the selected apple. 
	    jbtnBuy = new JButton("Buy Apple"); 
	 
	    // Add action listener for Buy Apple button. 
	    jbtnBuy.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        /*
	    	  // Get the index of the changed item. 
	        int idx = jlst.getSelectedIndex(); 
	 
	        // Display purchase selection if item was selected. 
	        if(idx != -1) {
	        	jlab.setText("You purchased " +  apples[idx]); 
	        }else{
	        	 jlab.setText("No apple has been selected."); 
	        }
	        */
	    	  
	    	  String what = ""; 
	    	  
	          // Get the index of the changed item. 
	          int indices[] = jlst.getSelectedIndices(); 
	   
	          // Confirm that one or more items have been selected. 
	          if(indices.length == 0) { 
	            jlab.setText("No apple has been selected."); 
	            return; 
	          } 
	   
	          // Display the selected items. 
	          for(int i = 0; i < indices.length; i++) 
	            what += apples[indices[i]] + "<br>"; 
	   
	          jlab.setText("<html>Apples Purchased:<br>" + what); 
	      }  
	    });  
	 
	    jfrm.add(jscrlp); 
	    jfrm.add(jbtnBuy); 
	    jfrm.add(jlab); 

	    jfrm.setVisible(true);  
	  }  
}
