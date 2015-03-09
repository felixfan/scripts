package simplejscrollpanedemo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class SimpleJScrollPaneDemo {
	SimpleJScrollPaneDemo() {   
		   	JFrame jfrm = new JFrame("Use JScrollPane");  
		    jfrm.setSize(220, 150);   
		    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		 
		    // Create a long, HTML-based label. 
		    JLabel jlab = 
		      new JLabel("<html>JScrollPane simplifies what would<br>" + 
		                 "otherwise be complicated tasks.<br>" + 
		                 "It can be used to scroll any component<br>" + 
		                 "or lightweight container. It is especially<br>" + 
		                 "useful when scrolling tables, lists,<br>" + 
		                 "or images."); 
		 
		    // Create a scroll pane and have it scroll the label. 
		    JScrollPane jscrlp = new JScrollPane(jlab); 

		    jfrm.add(jscrlp);  
		    jfrm.setVisible(true);   
		  }   
}
