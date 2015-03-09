package simplejtabbedpane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class SimpleJTabbedPane {
	SimpleJTabbedPane() {  
		   	JFrame jfrm = new JFrame("Tabbed Pane Demo");  
		    jfrm.setSize(380, 150);   
		    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    JTabbedPane jtp = new JTabbedPane(); 
		 
		    // Add tabs to the tab pane 
		    jtp.addTab("File Manager", new JLabel(" This is the File Manager tab."));		              
		    jtp.addTab("Performance", new JLabel(" This is the Performance tab.")); 		               
		    jtp.addTab("Reports", new JLabel(" This is the Reports tab.")); 		               
		    jtp.addTab("Customize", new JLabel(" This is the Customize tab.")); 

		    jfrm.add(jtp);  
		    jfrm.setVisible(true);  
		  }  
}
