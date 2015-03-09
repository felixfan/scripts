package anonymousinnerclasseseventhandlers;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnonymousInnerClassesEventHandlers {
	JLabel jlab;   
	JButton jbtnFirst; 
	JButton jbtnSecond;
        
	AnonymousInnerClassesEventHandlers(){
            ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/images/myIcon.gif"));
            ImageIcon myDisIcon = new ImageIcon(this.getClass().getResource("/images/myDisIcon.gif")); 
            ImageIcon myROIcon = new ImageIcon(this.getClass().getResource("/images/myROIcon.gif")); 
            ImageIcon myPIcon = new ImageIcon(this.getClass().getResource("/images/myPIcon.gif"));
                      
	    JFrame jfrm = new JFrame("Use Anonymous Inner Classes as Event Handlers");    
	    jfrm.setLayout(new FlowLayout());   
	    jfrm.setSize(300, 100);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    jlab = new JLabel("Press a button.");  
	   
	    jbtnFirst = new JButton("First", myIcon);  
	    jbtnSecond = new JButton("Second", myIcon);  

            
	    // Set rollover icons. 
	    jbtnFirst.setRolloverIcon(myROIcon); 
	    jbtnSecond.setRolloverIcon(myROIcon); 
	  
	    // Set pressed icons. 
	    jbtnFirst.setPressedIcon(myPIcon); 
	    jbtnSecond.setPressedIcon(myPIcon); 
	 
	    // Set disabled icons. 
	    jbtnFirst.setDisabledIcon(myDisIcon); 
	    jbtnSecond.setDisabledIcon(myDisIcon); 
	 
	    // Add action listeners: these listeners are implemented by using anonymous inner classes.
	    jbtnFirst.addActionListener(new ActionListener() { 
              @Override
	      public void actionPerformed(ActionEvent ae) { 
	        if(jbtnSecond.isEnabled()) { 
	          jlab.setText("Second button is disabled.");  
	          jbtnSecond.setEnabled(false); 
	        } else { 
	          jlab.setText("Second button is enabled.");  
	          jbtnSecond.setEnabled(true); 
	        } 
	      } 
	    }); 
	 
	    jbtnSecond.addActionListener(new ActionListener() { 
	      public void actionPerformed(ActionEvent ae) { 
	        jlab.setText("Second button was pressed.");  
	      } 
	    }); 
	  
	    jfrm.add(jbtnFirst);   
	    jfrm.add(jbtnSecond);   
	    jfrm.getContentPane().add(jlab);  
  
	    jfrm.setVisible(true); 
	}

}
