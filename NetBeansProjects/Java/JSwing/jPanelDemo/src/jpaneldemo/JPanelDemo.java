package jpaneldemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelDemo {
	  JLabel jlab;    
	  JButton jbtnAlpha,jbtnBeta;  
	   
	  JPanelDemo() {   
	    JFrame jfrm = new JFrame("Use Two JPanels"); 
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(210, 210);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	   
	    // Create the first JPanel.  
	    JPanel jpnl = new JPanel(); 
	 
	    // Set the preferred size of the first panel. 
	    jpnl.setPreferredSize(new Dimension(100, 100)); 
	 
	    // Make the panel opaque. 
	    jpnl.setOpaque(true); 
	 
	    // Add a blue border to the panel. 
	    jpnl.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
	 
	    // Create the second JPanel. 
	    JPanel jpnl2 = new JPanel(); 
	 
	    // Set the preferred size of the second panel. 
	    jpnl2.setPreferredSize(new Dimension(100, 60)); 
	 
	    // Make the panel opaque. 
	    jpnl2.setOpaque(true); 
	 
	    // Add a red border to the panel. 
	    jpnl2.setBorder(BorderFactory.createLineBorder(Color.RED)); 
	 
	    jlab = new JLabel("Press a button.");    
	    jbtnAlpha = new JButton("Alpha"); 
	    jbtnBeta = new JButton("Beta");   
	  
	    jbtnAlpha.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        jlab.setText("Alpha pressed.");   
	      }  
	    });  
	  
	    jbtnBeta.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        jlab.setText("Beta pressed.");   
	      }  
	    });  
	   
	    // Add the buttons and label to the panel. 
	    jpnl.add(jbtnAlpha);    
	    jpnl.add(jbtnBeta);    
	    jpnl.add(jlab); 
	 
	    // Add some labels to the second JPanel. 
	    jpnl2.add(new JLabel("One"));    
	    jpnl2.add(new JLabel("Two")); 
	    jpnl2.add(new JLabel("Three")); 
	 
	    // Add the panels to the frame.   
	    jfrm.add(jpnl); 
	    jfrm.add(jpnl2); 
	 
	    // Display the frame.   
	    jfrm.setVisible(true);   
	  }   
}
