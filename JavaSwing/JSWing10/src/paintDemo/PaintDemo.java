package paintDemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintDemo extends JPanel {
	  // This class extends JPanel. It overrides the paintComponent() method so that random data is plotted in the panel. 
	  
	private static final long serialVersionUID = 1L;
	
	Insets ins; // holds the panel's insets 	  
	  Random rand; // used to generate random numbers 
	 
	  PaintDemo(int w, int h) {   
	     
	    // Ensure that the panel is opaque. 
	    setOpaque(true); 
	 
	    // Use a red line border. 
	    setBorder(BorderFactory.createLineBorder(Color.RED, 1)); 
	 
	    // Set the preferred dimension as specified. 
	    setPreferredSize(new Dimension(w, h)); 
	 
	    rand = new Random(); 
	  } 
	 
	  // Override the paintComponent() method. 
	  protected void paintComponent(Graphics g) { 
	    // Always call the superclass method first. 
	    super.paintComponent(g); 
	 
	    // Get the height and width of the component. 
	    int height = getHeight(); 
	    int width = getWidth(); 
	 
	    // Get the insets. 
	    ins = getInsets(); 
	 
	    // Fill the panel by plotting random data in the form of a bar graph. 
	    for(int i=ins.left+5; i <= width-ins.right-5; i += 4) { 
	      // Obtain a random number between 0 and maximum height of the drawing area. 
	      int h = rand.nextInt(height-ins.bottom); 
	 
	      // If generated value is within or too close to the border, change it to just outside the border. 
	      if(h <= ins.top) {
	    	  h = ins.top+1; 
	      }
	 
	      // Draw a line that represents the data. 
	      g.drawLine(i, height-ins.bottom, i, h); 
	    } 
	  } 
	 
	  // Change the border size. 
	  public void changeBorderSize(int size) { 
	    setBorder(BorderFactory.createLineBorder(Color.RED, size)); 
	  } 
	} 
	 
	// Demonstrate painting directly onto a panel. 
	class JPaintDemo { 
	 
	  JButton jbtnMore, jbtnSize; 
	  JLabel jlab; 
	  PaintDemo pp; 
	 
	  boolean big; // use to toggle size of panel 
	 
	  JPaintDemo() { 
	    JFrame jfrm = new JFrame("Painting Demo"); 	        
	    jfrm.setLayout(new FlowLayout());     	   
	    jfrm.setSize(240, 260);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	   
	    // Create the panel that will be painted. 
	    pp = new PaintDemo(100, 100); 
	 
	    jbtnMore = new JButton("Show More Data"); 
	    jbtnSize = new JButton("Change Border Size"); 	 
	    jlab = new JLabel("Bar Graph of Random Data"); 
	  
	    // Repaint the panel when the Show More Data button is clicked. 
	    jbtnMore.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        pp.repaint(); 
	      }  
	    });  
	 
	    // Set the border size of the panel when the Change Border Size button is clicked. 
	    // Changing the border size automatically results in a repaint. 
	    jbtnSize.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        if(!big) {
	        	pp.changeBorderSize(5); 
	        }else {
	        	pp.changeBorderSize(1); 
		        big = !big; 
	        }
	      }  
	    });  
	    
	    // Add the buttons, label, and panel to the content pane. 
	    jfrm.add(jlab); 
	    jfrm.add(pp);    
	    jfrm.add(jbtnMore); 
	    jfrm.add(jbtnSize); 
	 
	    big = false;   
	    jfrm.setVisible(true);   
	  }   

}
