package tabbedPanelWithPanels;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class TabbedPanelWithPanels {
	  JCheckBox jcbDVD,jcbScanner,jcbNtwrkRdy; 	 
	  JCheckBox jcbWordProc,jcbCompiler,jcbDatabase; 	 
	  JRadioButton jrbTower,jrbNotebook,jrbHandheld; 
	 
	  TabbedPanelWithPanels() {  
	    JFrame jfrm = new JFrame("Use JPanels with JTabbedPane");  
	    jfrm.setSize(280, 140);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    // Make Style radio buttons. 
	    jrbTower = new JRadioButton("Tower");  
	    jrbNotebook = new JRadioButton("Notebook");  
	    jrbHandheld = new JRadioButton("Handheld");  
	    ButtonGroup bg = new ButtonGroup(); 
	    bg.add(jrbTower); 
	    bg.add(jrbNotebook); 
	    bg.add(jrbHandheld); 
	    JPanel  jpnl = new JPanel(); 
	    jpnl.setLayout(new GridLayout(3, 1)); 
	    jpnl.setOpaque(true); 
	    jpnl.add(jrbTower); 
	    jpnl.add(jrbNotebook); 
	    jpnl.add(jrbHandheld); 
	 
	    // Make Options check boxes. 
	    jcbDVD = new JCheckBox("DVD Burner"); 
	    jcbScanner = new JCheckBox("Scanner");  
	    jcbNtwrkRdy = new JCheckBox("Network Ready");  
	    JPanel jpnl2 = new JPanel(); 
	    jpnl2.setLayout(new GridLayout(3, 1)); 
	    jpnl2.setOpaque(true); 
	    jpnl2.add(jcbDVD); 
	    jpnl2.add(jcbScanner); 
	    jpnl2.add(jcbNtwrkRdy); 
	 
	    // Make Software check boxes. 
	    jcbWordProc = new JCheckBox("Word Processing"); 
	    jcbCompiler = new JCheckBox("Program Development");  
	    jcbDatabase = new JCheckBox("Database");  
	    JPanel  jpnl3 = new JPanel(); 
	    jpnl3.setLayout(new GridLayout(3, 1)); 
	    jpnl3.setOpaque(true); 
	    jpnl3.add(jcbWordProc); 
	    jpnl3.add(jcbCompiler); 
	    jpnl3.add(jcbDatabase); 
 
	    // Create a tabbed pane that uses a scroll policy. 
	    JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT); 
	    
	    // Add the panels to the tabbed pane. 
	    jtp.addTab("Style", jpnl); 
	    jtp.addTab("Options", jpnl2); 
	    jtp.addTab("Software", jpnl3); 
	 
	    jfrm.add(jtp);  
	    jfrm.setVisible(true);  
	  }  
}
