package menuDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuDemo implements ActionListener{
	JLabel jlab; 

	MenuDemo() {     
		JFrame jfrm = new JFrame("Menu Demo");   
		jfrm.setLayout(new FlowLayout());   
		jfrm.setSize(220, 200);      
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		// Create a label that will display the menu selection. 
		jlab = new JLabel(); 

		// Create the menu bar. 
		JMenuBar jmb = new JMenuBar(); 

		// Create the File menu with mnemonics and accelerators 
		JMenu jmFile = new JMenu("File");
		jmFile.setMnemonic(KeyEvent.VK_F);
		
		// JMenuItem jmiOpen = new JMenuItem("Open"); 
		JMenuItem jmiOpen = new JMenuItem("Open",KeyEvent.VK_O); 
		jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); 
		
		JMenuItem jmiClose = new JMenuItem("Close",KeyEvent.VK_C); 
		jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK)); 
		
		JMenuItem jmiSave = new JMenuItem("Save",KeyEvent.VK_S);
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		JMenuItem jmiExit = new JMenuItem("Exit",KeyEvent.VK_E); 
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		
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

		// Create the Colors sub-menu. 
		JMenu jmColors = new JMenu("Colors"); 
		JMenuItem jmiRed = new JMenuItem("Red"); 
		JMenuItem jmiGreen = new JMenuItem("Green"); 
		JMenuItem jmiBlue = new JMenuItem("Blue"); 
		jmColors.add(jmiRed); 
		jmColors.addSeparator();
		jmColors.add(jmiGreen);
		jmColors.addSeparator();
		jmColors.add(jmiBlue);
		
		jmOptions.add(jmColors); 

		// Create the Priority sub-menu. 
		JMenu jmPriority = new JMenu("Priority"); 
		JMenuItem jmiHigh = new JMenuItem("High"); 
		JMenuItem jmiLow = new JMenuItem("Low"); 
		jmPriority.add(jmiHigh); 
		jmPriority.addSeparator();
		jmPriority.add(jmiLow); 
		
		jmOptions.addSeparator();
		jmOptions.add(jmPriority); 

		// Create the Reset menu item. 
		JMenuItem jmiReset = new JMenuItem("Reset"); 
		jmOptions.addSeparator(); 
		jmOptions.add(jmiReset); 

		// Finally, add the entire options menu to the menu bar 
		jmb.add(jmOptions);  

		// Create the Help menu. 
		JMenu jmHelp = new JMenu("Help"); 
		// JMenuItem jmiAbout = new JMenuItem("About"); 
		
		ImageIcon icon = new ImageIcon("AboutIcon.gif"); 
		JMenuItem jmiAbout = new JMenuItem("About", icon);
		jmiAbout.setToolTipText("Info about the MenuDemo program.");
		
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

		// Add the label to the content pane. 
		jfrm.add(jlab);    

		// Add the menu bar to the frame. 
		jfrm.setJMenuBar(jmb);    

		// Display the frame.   
		jfrm.setVisible(true);   
	}   

	// Handle menu item action events. 
	public void actionPerformed(ActionEvent ae) {  
		// Get the action command from the menu selection. 
		String comStr = ae.getActionCommand(); 

		// If user chooses Exit, then exit the program. 
		if(comStr.equals("Exit")) System.exit(0); 

		// Otherwise, display the selection. 
		jlab.setText(comStr + " Selected"); 
	}  

}
