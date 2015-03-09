package jScrollPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class JScrollPanel {
	  JCheckBox jcbOpt1,jcbOpt2,jcbOpt3,jcbOpt4,jcbOpt5; 
	 
	  JScrollPanel() {  
	    JFrame jfrm = new JFrame("Use Headers");   
	    jfrm.setSize(280, 140);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    JLabel jlabOptions = new JLabel("Select one or more options: ");  

	    jcbOpt1 = new JCheckBox("Option One"); 
	    jcbOpt2 = new JCheckBox("Option Two");  
	    jcbOpt3 = new JCheckBox("Option Three");  
	    jcbOpt4 = new JCheckBox("Option Four");  
	    jcbOpt5 = new JCheckBox("Option Five");  

	    JPanel  jpnl = new JPanel(); 
	    jpnl.setLayout(new GridLayout(6, 1)); 
	    jpnl.setOpaque(true); 

	    jpnl.add(jlabOptions);  
	    jpnl.add(jcbOpt1); 
	    jpnl.add(jcbOpt2); 
	    jpnl.add(jcbOpt3); 
	    jpnl.add(jcbOpt4); 
	    jpnl.add(jcbOpt5); 
	 
	    // Create a scroll pane that will scroll the panel. 
	    JScrollPane jscrlp = new JScrollPane(jpnl); 

	    jscrlp.setViewportBorder(BorderFactory.createLineBorder(Color.BLACK));  
	 
	    // Create labels for the row and column headers. 
	    JLabel jlabCH = new JLabel("Configuration Center", SwingConstants.CENTER); 	                               
	    JLabel jlabRH = new JLabel("<html>C<br>h<br>o<br>o<br>s<br>e", SwingConstants.CENTER);	                                
	    jlabRH.setPreferredSize(new Dimension(20, 200)); 
	 
	    // Add row and column headers. 
	    jscrlp.setColumnHeaderView(jlabCH); 
	    jscrlp.setRowHeaderView(jlabRH); 

	    jfrm.add(jscrlp); 
	    jfrm.setVisible(true);  
	  }  
}
