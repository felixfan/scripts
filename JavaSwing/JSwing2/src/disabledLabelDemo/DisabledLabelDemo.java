package disabledLabelDemo;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DisabledLabelDemo {
	DisabledLabelDemo(){
	    JFrame jfrm = new JFrame("Disabled Label Demo");    
	    jfrm.setLayout(new GridLayout(3, 1));  
	    jfrm.setSize(240, 250);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    ImageIcon myIcon = new ImageIcon("myIcon.gif"); 
	    ImageIcon myDisIcon = new ImageIcon("myDisIcon.gif"); 
	  
	    JLabel jlabIconTxt = new JLabel("This label is enabled.",  myIcon, SwingConstants.CENTER); 
	
	    // Create and disable an icon- and text-based label. 
	    JLabel jlabIconTxt2 = new JLabel("This label is disabled.", myIcon, SwingConstants.CENTER);                              
	    jlabIconTxt2.setEnabled(false); 
	 
	 
	    // Create and disable an icon- and text-based label. 
	    // This time, specify a disabled icon. 
	    JLabel jlabIconTxt3 = new JLabel("Use the disabled icon.", myIcon, SwingConstants.CENTER);                                 
	    jlabIconTxt3.setDisabledIcon(myDisIcon); 
	    jlabIconTxt3.setEnabled(false); 
	    
	    jfrm.add(jlabIconTxt);  
	    jfrm.add(jlabIconTxt2);  
	    jfrm.add(jlabIconTxt3);  
	    
	    jfrm.setVisible(true);
	}

}
