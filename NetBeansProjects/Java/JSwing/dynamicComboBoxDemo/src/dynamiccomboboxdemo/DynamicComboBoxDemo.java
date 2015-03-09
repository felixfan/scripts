package dynamiccomboboxdemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicComboBoxDemo {
	  JComboBox<String> jcbb; 
	  JLabel jlab; 
	  JButton jbtnRemove; 
	 
	  // Create an array of apple varieties. 
	  String apples[] = { "Winesap", "Cortland", "Red Delicious",  
	                      "Golden Delicious", "Gala", "Fuji", 
	                      "Granny Smith", "Jonathan" }; 
	 
	  DynamicComboBoxDemo() {  
	    JFrame jfrm = new JFrame("Dynamic JComboBox");    
	    jfrm.setLayout(new FlowLayout());   
	    jfrm.setSize(220, 240);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	    jcbb = new JComboBox<String>(apples); 
	 
	    // Make the combo box editable. 
	    jcbb.setEditable(true); 
	 
	    // Make a label that displays the selection. 
	    jlab = new JLabel(); 
	 
	    // Add action listener for the combo box. 
	    // If the user enters a new item, it is added to the list. 
	    jcbb.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent le) {  
	        // Get a reference to the item selected. 
	        String item = (String) jcbb.getSelectedItem(); 
	 
	        // Ignore if nothing is selected. 
	        if(item==null) {
	        	return; 
	        }
	 
	        // Display the selected item. 
	        jlab.setText("Current selection " + item); 
	 
	        // Add the item to the list if it's not already on it. 
	        int i; 
	 
	        // See if it is in the list. 
	        for(i=0; i < jcbb.getItemCount(); i++) {
	        	if(item.equals(jcbb.getItemAt(i))) {
	        		break; // in list 
	        	}
	        }
	          	 
	        // If not, then add it. 
	        if(i==jcbb.getItemCount()) {
	        	jcbb.addItem(item); 
	        }
	      }  
	    });  
	 
	    // Initially select the first item in the list. 
	    jcbb.setSelectedIndex(0); 
	 
	    // Create the Remove Selection button. 
	    jbtnRemove = new JButton("Remove Selection"); 
	 
	    // Add action listener for the button. 
	    jbtnRemove.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent le) {  
	        // Get a reference to the item selected. 
	        String item = (String) jcbb.getSelectedItem(); 
	 
	        // Ignore if nothing is selected. 
	        if(item==null) {
	        	return; 
	        }
	 
	        // Remove the item. 
	        jcbb.removeItem(item); 
	 
	        // Display the selected item. 
	        jlab.setText("Removed " + item); 
	      }  
	    });  
	 
	    // Add the combo box, label and button to the content pane. 
	    jfrm.add(jcbb); 
	    jfrm.add(jlab); 
	    jfrm.add(jbtnRemove);  
	    jfrm.setVisible(true); 
	  }
}
