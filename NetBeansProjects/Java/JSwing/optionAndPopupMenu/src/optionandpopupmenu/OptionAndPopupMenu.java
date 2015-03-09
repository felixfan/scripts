package optionandpopupmenu;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class OptionAndPopupMenu {	
	OptionAndPopupMenu(){
		JFrame jfrm = new JFrame("Options Menu");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(200, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar jmb = new JMenuBar();
		
		// Create the Options menu. 
		JMenu jmOptions = new JMenu("Options"); 
		 
		// Create the Colors submenu. 
		JMenu jmColors = new JMenu("Colors"); 
		 
		// Use check boxes for colors. This allows the user to select more than one color. 
		JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red"); 
		JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green"); 
		JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue"); 
		 
		jmColors.add(jmiRed); 
		jmColors.add(jmiGreen); 
		jmColors.add(jmiBlue); 
		
		jmOptions.add(jmColors); 
		 
		// Create the Priority submenu. 
		JMenu jmPriority = new JMenu("Priority"); 
		 
		// Use radio buttons for the priority setting. 
		// This lets the menu show which priority is used but also ensures that one and only one priority can be selected at any one time.  
		// Notice that the High radio button is initially selected. 
		JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High", true); 
		JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low"); 
		 
		jmPriority.add(jmiHigh); 
		jmPriority.add(jmiLow); 
		
		jmOptions.add(jmPriority); 
		 
		// Create button group for the radio button menu items. 
		ButtonGroup bg = new ButtonGroup(); 
		bg.add(jmiHigh); 
		bg.add(jmiLow); 
		 
		// Create the Reset menu item. 
		JMenuItem jmiReset = new JMenuItem("Reset"); 
		
		jmOptions.addSeparator(); 
		jmOptions.add(jmiReset); 
		
		// Finally, add the entire options menu to the menu bar 
		jmb.add(jmOptions);
		
		//////////////////////////////////////
		// pop-up menu
		final JPopupMenu jpu;
		jpu = new JPopupMenu(); 
		 
		// Create the pop-up menu items 
		JMenuItem jmiCut = new JMenuItem("Cut"); 
		JMenuItem jmiCopy = new JMenuItem("Copy"); 
		JMenuItem jmiPaste = new JMenuItem("Paste"); 
		 
		// Add the menu items to the pop-up menu. 
		jpu.add(jmiCut); 
		jpu.add(jmiCopy); 
		jpu.add(jmiPaste); 
		 
		// Add a listener for for the pop-up trigger. 
		jfrm.addMouseListener(new MouseAdapter() {  
		  public void mousePressed(MouseEvent me) { 
		    if(me.isPopupTrigger()){
		    	jpu.show(me.getComponent(), me.getX(), me.getY()); 
		    }		      
		  }
		  
		  public void mouseReleased(MouseEvent me) { 
		    if(me.isPopupTrigger()){
		    	jpu.show(me.getComponent(), me.getX(), me.getY()); 
		    }
		  }  
		}); 
		
		 
		jmb.add(jpu);
		
		jfrm.setJMenuBar(jmb);		
		
		jfrm.setVisible(true);
	}

}
