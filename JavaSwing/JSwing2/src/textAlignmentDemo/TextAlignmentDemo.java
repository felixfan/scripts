package textAlignmentDemo;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TextAlignmentDemo {
	TextAlignmentDemo(){
		JLabel[] jlabs = new JLabel[9]; 
		
	    JFrame jfrm = new JFrame("Horizontal and Vertical Alignment");  
	  
	    // Specify GridLayout for the layout manager.  
	    // This specifies a 3 row, 3 column grid with 4 pixels between components. 
	    jfrm.setLayout(new GridLayout(3, 3, 4, 4)); 
	   
	    jfrm.setSize(500, 200);  
	  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	 
	    // Left-align text at top. 
	    // Horizontal alignment: LEFT
	    jlabs[0] = new JLabel("Left, Top", SwingConstants.LEFT); 
	    jlabs[0].setVerticalAlignment(SwingConstants.TOP); 
	 
	    // Center text at top.
	    // Horizontal alignment: CENTER
	    jlabs[1] = new JLabel("Center, Top", SwingConstants.CENTER); 
	    jlabs[1].setVerticalAlignment(SwingConstants.TOP); 
	 
	    // Right-align text at Top. 
	    jlabs[2] = new JLabel("Right, Top", SwingConstants.RIGHT); 
	    jlabs[2].setVerticalAlignment(SwingConstants.TOP);; 
	 
	    // Left-align text at center. This is default 
	    jlabs[3] = new JLabel("Left, Center", SwingConstants.LEFT); 
	  
	    // Center the text. 
	    jlabs[4] = new JLabel("Center, Center", SwingConstants.CENTER); 
	 
	    // Right-algin text at center. 
	    jlabs[5] = new JLabel("Right, Center", SwingConstants.RIGHT); 
	 
	    // Left-align text at bottom.. 
	    jlabs[6] = new JLabel("Left, Bottom", SwingConstants.LEFT); 
	    jlabs[6].setVerticalAlignment(SwingConstants.BOTTOM); 
	 
	    // Center text at bottom. 
	    jlabs[7] = new JLabel("Center, Bottom", SwingConstants.CENTER); 
	    jlabs[7].setVerticalAlignment(SwingConstants.BOTTOM); 
	 
	    // Right-align text at bottom. 
	    jlabs[8] = new JLabel("Right, Bottom", SwingConstants.RIGHT); 
	    jlabs[8].setVerticalAlignment(SwingConstants.BOTTOM); 
	 
	    // Add borders so we can see the outline of the labels. 
	    // First, create an etched border. 
	    Border border = BorderFactory.createEtchedBorder(); 
	 
	    // Now, add that border to the labels.
	    // Add the labels to the content pane.
	    for(int i=0; i<9; i++){
	    	jlabs[i].setBorder(border);
	    	jfrm.add(jlabs[i]); 
	    }
	    
	    // Add an empty border around the content pane. 
	    JPanel cp = ((JPanel) jfrm.getContentPane()); 
	    cp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4)); 
	 
	    // Display the frame.  
	    jfrm.setVisible(true);  
	}

}
