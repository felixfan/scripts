package gridBagLayoutDemo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GridBagLayoutDemo {
		GridBagLayoutDemo() { 		  
		    JFrame jfrm = new JFrame("GridBagLayout Demo"); 
		   
		    // Create the grid bag. 
		    GridBagLayout gbag = new GridBagLayout(); 
		    GridBagConstraints gbc = new GridBagConstraints(); 
		 
		    // Set the grid bag as the layout manager for the the content pane. 
		    jfrm.setLayout(gbag);     
		    
		    jfrm.setSize(240, 240); 		   
		    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		   
		    // Make the labels. 
		    JLabel jlabOne = new JLabel("Button Group One"); 
		    JLabel jlabTwo = new JLabel("Button Group Two"); 
		    JLabel jlabThree = new JLabel("Check Box Group"); 
		 
		    // Make the buttons. 
		    JButton jbtnOne = new JButton("One"); 
		    JButton jbtnTwo = new JButton("Two"); 
		    JButton jbtnThree = new JButton("Three"); 
		    JButton jbtnFour = new JButton("Four"); 
		 
		    Dimension btnDim = new Dimension(100, 25); 
		    jbtnOne.setPreferredSize(btnDim); 
		    jbtnTwo.setPreferredSize(btnDim); 
		    jbtnThree.setPreferredSize(btnDim); 
		    jbtnFour.setPreferredSize(btnDim); 
		 
		    // Make the checkboxes. 
		    JCheckBox jcbOne = new JCheckBox("Option One"); 
		    JCheckBox jcbTwo = new JCheckBox("Option Two"); 
		 
		    // Define the grid bag. 
		 
		    // By using a weightx of 1.0, the components divide the horizontal space. 
		    // However, because weighty uses its default value of 0.0, the components remain centered in the vertical space.  
		    gbc.weightx = 1.0; 
		 
		    // Define the grid location for each component. 
		 
		    // Put the button labels in locations 0,0 and 1, 0. 
		    gbc.gridx = 0; 
		    gbc.gridy = 0; 
		    gbag.setConstraints(jlabOne, gbc); 
		 
		    gbc.gridx = 1; 
		    gbc.gridy = 0; 
		    gbag.setConstraints(jlabTwo, gbc); 
		 
		    // Add some space around the buttons. 
		    gbc.insets = new Insets(4, 4, 4, 4); 
		 
		    // Put the buttons at locations 0,1 and 1,1, and so on. 
		    gbc.gridx = 0; 
		    gbc.gridy = 1; 
		    gbag.setConstraints(jbtnOne, gbc); 
		 
		    gbc.gridx = 1; 
		    gbc.gridy = 1; 
		    gbag.setConstraints(jbtnTwo, gbc); 
		 
		    gbc.gridx = 0; 
		    gbc.gridy = 2; 
		    gbag.setConstraints(jbtnThree, gbc); 
		 
		    gbc.gridx = 1; 
		    gbc.gridy = 2; 
		    gbag.setConstraints(jbtnFour, gbc); 
		 
		    // Have the last label and the two check boxes use the remaining space. 
		    gbc.gridwidth = GridBagConstraints.REMAINDER; 
		 
		    // Use an inset of 10 from the top for the label. 
		    gbc.insets = new Insets(10, 0, 0, 0);
		    
		    gbc.gridx = 0; 
		    gbc.gridy = 3; 
		    gbag.setConstraints(jlabThree, gbc); 
		 
		    // No insets for the check boxes. 
		    gbc.insets = new Insets(0, 0, 0, 0); 
		    
		    gbc.gridx = 0; 
		    gbc.gridy = 4; 
		    gbag.setConstraints(jcbOne, gbc); 
		 
		    gbc.gridx = 0; 
		    gbc.gridy = 5; 
		    gbag.setConstraints(jcbTwo, gbc); 
		 
		    jfrm.add(jlabOne); 
		    jfrm.add(jlabTwo); 
		    jfrm.add(jbtnOne); 
		    jfrm.add(jbtnTwo); 
		    jfrm.add(jbtnThree); 
		    jfrm.add(jbtnFour); 
		    jfrm.add(jlabThree); 
		    jfrm.add(jcbOne); 
		    jfrm.add(jcbTwo); 
		   
		    jfrm.setVisible(true);   
		  }   
		    

}
