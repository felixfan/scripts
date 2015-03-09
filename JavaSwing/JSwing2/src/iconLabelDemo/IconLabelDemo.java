package iconLabelDemo;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class IconLabelDemo {
	IconLabelDemo(){
		JFrame jfrm = new JFrame("Use Images in Labels");  
		  
	    // Specify 4 by 1 GridLayout manager.  
	    jfrm.setLayout(new GridLayout(5, 1)); 
	    jfrm.setSize(250, 300);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	 
	    // Load an icon from a file.  
	    ImageIcon myIcon = new ImageIcon("myIcon.gif"); 
	    
	    JLabel jlabTxt = new JLabel("Text Label");
	    
	    // Create an icon-based label. 
	    JLabel jlabIcon = new JLabel(myIcon); 
	  
	    // Create an icon- and text-based label. 
	    JLabel jlabIconTxt = new JLabel("Default Icon and Text Position", myIcon, SwingConstants.CENTER);
	                                     
	    // Create a label with text to left of icon. 
	    JLabel jlabIconTxt2 = new JLabel("Text Left of Icon", myIcon, SwingConstants.CENTER);                                
	    jlabIconTxt2.setHorizontalTextPosition(SwingConstants.LEFT); 
	 
	    // Create an icon- and text-based label in which the text is above the icon. 
	    JLabel jlabIconTxt3 = new JLabel("Text Over Icon", myIcon, SwingConstants.CENTER);                                
	    jlabIconTxt3.setVerticalTextPosition(SwingConstants.TOP); 
	    jlabIconTxt3.setHorizontalTextPosition(SwingConstants.CENTER); 
	  
	    // Add the labels to the content pane.
	    jfrm.add(jlabTxt);
	    jfrm.add(jlabIcon);  
	    jfrm.add(jlabIconTxt);  
	    jfrm.add(jlabIconTxt2);  
	    jfrm.add(jlabIconTxt3);  
	  
	    // Display the frame.  
	    jfrm.setVisible(true);
	}

}
