package togglebuttondemo;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class ToggleButtonDemo {
	  JLabel jlab; 
	  JToggleButton jtbn; 
	  
	  ToggleButtonDemo() {   
	    JFrame jfrm = new JFrame("Demonstrate a Toggle Button");  
	    jfrm.setLayout(new FlowLayout());   
	    jfrm.setSize(290, 80);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    jlab = new JLabel("Button is off.");  
	    jtbn =  new JToggleButton("On/Off"); 
	 
	    // Add item listener for jtbn by using an anonymous inner class. 
	    jtbn.addItemListener(new ItemListener() { 
	      public void itemStateChanged(ItemEvent ie) { 
	        if(jtbn.isSelected()) {
	        	jlab.setText("Button is on."); 
	        }else {
	        	jlab.setText("Button is off."); 
	        }
	      } 
	 
	    }); 
	   
	    jfrm.add(jtbn);   
	    jfrm.add(jlab);  
	 
	    jfrm.setVisible(true); 
	  }

}
