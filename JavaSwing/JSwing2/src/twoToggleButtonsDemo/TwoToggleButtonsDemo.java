package twoToggleButtonsDemo;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class TwoToggleButtonsDemo implements ItemListener {
	  JLabel jlabAlpha; 
	  JLabel jlabBeta; 
	  JToggleButton jtbnAlpha; 
	  JToggleButton jtbnBeta; 
	  
	  TwoToggleButtonsDemo() {  
	    JFrame jfrm = new JFrame("Two Toggle Buttons");  
	    jfrm.setLayout(new GridLayout(2,2,4,4));  
	    jfrm.setSize(200, 100);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	    jlabAlpha = new JLabel("Alpha is off.  ");  
	    jlabBeta = new JLabel("Beta is off.");  

	    jtbnAlpha =  new JToggleButton("Alpha"); 
	    jtbnBeta =  new JToggleButton("Beta"); 
	 
	    jtbnAlpha.addItemListener(this); 
	    jtbnBeta.addItemListener(this); 
 
	    jfrm.add(jtbnAlpha); 
	    jfrm.add(jlabAlpha); 
	    jfrm.add(jtbnBeta); 
	    jfrm.add(jlabBeta); 
	    
	    JPanel cp = (JPanel)jfrm.getContentPane();
	    cp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	  
	    jfrm.setVisible(true);  
	  }

	public void itemStateChanged(ItemEvent ie) {
		// Get a reference to the button. 
	    JToggleButton tb = (JToggleButton) ie.getItem(); 
	 
	    // Determine which button was toggled. 
	    if(tb == jtbnAlpha) {
	    	if(tb.isSelected()) {
	    		jlabAlpha.setText("Alpha is on.  "); 
	    	} else {
	    		jlabAlpha.setText("Alpha is off.  ");
	    	}  
	    }else if(tb == jtbnBeta){
	    	 if(tb.isSelected()) {
	    		 jlabBeta.setText("Beta is on."); 
	    	 }else{
	    		 jlabBeta.setText("Beta is off."); 
	    	 }
	    }
	}  	

}
