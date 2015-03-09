package mnemonicsDemo;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MnemonicsDemo {
	MnemonicsDemo(){
	    JFrame jfrm = new JFrame("Demonstrate Mnemomics");  
	    jfrm.setLayout(new GridLayout(2,2,4,4));  
	    jfrm.setSize(350, 140); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    JLabel jlab1 = new JLabel("E-mail Address"); 
	    JLabel jlab2 = new JLabel("Name"); 
	 
	    // Assign nmemonics to the labels. 
	    jlab1.setDisplayedMnemonic('e');  
	    jlab2.setDisplayedMnemonic('n');  
	  
	    JTextField jtf1 = new JTextField(20);  
	    JTextField jtf2 = new JTextField(20);  
	  
	    // Link the labels with the associated components. 
	    jlab1.setLabelFor(jtf1); 
	    jlab2.setLabelFor(jtf2); 
	 
	    // Set the action commands for the text fields.  
	    jtf1.setActionCommand("jtf1");  
	    jtf2.setActionCommand("jtf2");  
	    
	    jfrm.add(jlab1);  
	    jfrm.add(jtf1);   
	    jfrm.add(jlab2);  
	    jfrm.add(jtf2); 
	    
	    JPanel cp = ((JPanel) jfrm.getContentPane()); 
	    cp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4)); 
	    
	    jfrm.setVisible(true);
	}

}
