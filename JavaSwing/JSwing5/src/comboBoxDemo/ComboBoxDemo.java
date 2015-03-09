package comboBoxDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxDemo {
	  JComboBox<String> jcbb; 
	  JLabel jlab; 
	 
	  // Create an array of apple varieties. 
	  String apples[] = { "Winesap", "Cortland", "Red Delicious",  
	                      "Golden Delicious", "Gala", "Fuji", 
	                      "Granny Smith", "Jonathan" }; 
	 
	  ComboBoxDemo() {  
	    JFrame jfrm = new JFrame("JComboBox Demo");   
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(220, 240);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    // Create a JComboBox 
	    jcbb = new JComboBox<String>(apples); 
	 
	    // Make a label that displays the selection. 
	    jlab = new JLabel(); 
	 
	    // Add action listener for the combo box. 
	    jcbb.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent le) {  
	        // Get a reference to the item selected. 
	        String item = (String) jcbb.getSelectedItem(); 
	 
	        // Display the selected item. 
	        jlab.setText("Current selection " + item); 
	      }  
	    });  
	 
	    // Initially select the first item in the list. 
	    jcbb.setSelectedIndex(0); 
	 
	    jfrm.add(jcbb); 
	    jfrm.add(jlab); 
	    jfrm.setVisible(true);  
	  }  
	 
}
