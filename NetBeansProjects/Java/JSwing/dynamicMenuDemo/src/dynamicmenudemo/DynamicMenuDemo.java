package dynamicmenudemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DynamicMenuDemo implements ActionListener {
	  JLabel jlab; 
	  
	  JMenuItem jmiYellow; 
	  JMenuItem jmiPurple; 
	  JMenuItem jmiOrange; 
	 
	  JMenu jmColors; 
	   
	  DynamicMenuDemo() {   
	    JFrame jfrm = new JFrame("Dynamic Menu Demo"); 
	    jfrm.setLayout(new FlowLayout());    
	    jfrm.setSize(220, 200);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	   
	    jlab = new JLabel(); 
	 
	    JMenuBar jmb = new JMenuBar(); 
	 
	    // Create the File menu. 
	    JMenu jmFile = new JMenu("File"); 
	    JMenuItem jmiOpen = new JMenuItem("Open"); 
	    JMenuItem jmiClose = new JMenuItem("Close"); 
	    JMenuItem jmiSave = new JMenuItem("Save"); 
	    JMenuItem jmiExit = new JMenuItem("Exit"); 
	    jmFile.add(jmiOpen); 
	    jmFile.addSeparator(); 
	    jmFile.add(jmiClose); 
	    jmFile.addSeparator(); 
	    jmFile.add(jmiSave); 
	    jmFile.addSeparator(); 
	    jmFile.add(jmiExit); 
	    
	    jmb.add(jmFile); 
	 
	    // Create the Options menu. 
	    JMenu jmOptions = new JMenu("Options"); 
	 
	    jmColors = new JMenu("Colors"); 
	    JMenuItem jmiRed = new JMenuItem("Red"); 
	    JMenuItem jmiGreen = new JMenuItem("Green"); 
	    JMenuItem jmiBlue = new JMenuItem("Blue"); 
	    jmColors.add(jmiRed); 
	    jmColors.addSeparator();
	    jmColors.add(jmiGreen); 
	    jmColors.addSeparator();
	    jmColors.add(jmiBlue); 
	 
	    // Create the More/Less Colors Menu item. 
	    JMenuItem jmiMoreLess = new JMenuItem("More Colors"); 
	    jmColors.add(jmiMoreLess); 
	 
	    // Add Colors menu to the Options menu. 
	    jmOptions.add(jmColors); 
	 
	    // Create the additional colors. These will added or removed on demand. 
	    jmiYellow = new JMenuItem("Yellow"); 
	    jmiPurple = new JMenuItem("Purple"); 
	    jmiOrange = new JMenuItem("Orange"); 
	 
	    // Create the Priority submenu. 
	    JMenu jmPriority = new JMenu("Priority"); 
	    JMenuItem jmiHigh = new JMenuItem("High"); 
	    JMenuItem jmiLow = new JMenuItem("Low"); 
	    jmPriority.add(jmiHigh); 
	    jmPriority.addSeparator();
	    jmPriority.add(jmiLow); 
	 
	    // Add the Priority menu to the Options menu. 
	    jmOptions.add(jmPriority); 
	 
	    // Create the Reset menu item. 
	    JMenuItem jmiReset = new JMenuItem("Reset"); 
	    jmOptions.addSeparator(); 
	    jmOptions.add(jmiReset); 
	 
	    // Finally, add the entire options menu to the menu bar 
	    jmb.add(jmOptions);  
	 
	    // Create the Help menu. 
	    JMenu jmHelp = new JMenu("Help"); 
	    JMenuItem jmiAbout = new JMenuItem("About"); 
	    jmHelp.add(jmiAbout); 
	    jmb.add(jmHelp);  
	 
	    // Add action listeners for the menu items. 
	    jmiOpen.addActionListener(this); 
	    jmiClose.addActionListener(this); 
	    jmiSave.addActionListener(this); 
	    jmiExit.addActionListener(this); 
	    jmiRed.addActionListener(this); 
	    jmiGreen.addActionListener(this); 
	    jmiBlue.addActionListener(this); 
	    jmiHigh.addActionListener(this); 
	    jmiLow.addActionListener(this); 
	    jmiReset.addActionListener(this); 
	    jmiAbout.addActionListener(this); 
	 
	    // Add listeners for the additional colors option. 
	    jmiMoreLess.addActionListener(this); 
	    jmiYellow.addActionListener(this); 
	    jmiPurple.addActionListener(this); 
	    jmiOrange.addActionListener(this); 
	 
	    // Add the label to the content pane. 
	    jfrm.add(jlab);    
	 
	    // Add the menu bar to the frame. 
	    jfrm.setJMenuBar(jmb);    
	   
	    // Display the frame.   
	    jfrm.setVisible(true);   
	  }   
	 
	  // Handle menu item action events. 
	  public void actionPerformed(ActionEvent ae) {  
	    String comStr = ae.getActionCommand(); 
	 
	    // If user chooses Exit, then exit the program. 
	    if(comStr.equals("Exit")){
	    	 System.exit(0); 	    	
	    } else if(comStr.equals("More Colors")) { 
	      jmColors.add(jmiYellow); 
	      jmColors.add(jmiPurple); 
	      jmColors.add(jmiOrange); 
	      JMenuItem mi = (JMenuItem) ae.getSource(); 
	      mi.setText("Less Colors"); 
	    } else if(comStr.equals("Less Colors")) { 
	      jmColors.remove(jmiYellow); 
	      jmColors.remove(jmiPurple); 
	      jmColors.remove(jmiOrange); 
	      JMenuItem mi = (JMenuItem) ae.getSource(); 
	      mi.setText("More Colors"); 
	    } 
	 
	    // Otherwise, display the selection. 
	    jlab.setText(comStr + " Selected"); 
	  }  

}
