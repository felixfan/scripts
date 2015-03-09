package iconbuttondemo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconButtonDemo implements ActionListener {
	JLabel jlab;
	JButton jbtn1, jbtn2;
	
	IconButtonDemo() {  
            ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/images/myIcon.gif"));
            ImageIcon myDisIcon = new ImageIcon(this.getClass().getResource("/images/myDisIcon.gif")); 
            ImageIcon myROIcon = new ImageIcon(this.getClass().getResource("/images/myROIcon.gif")); 
            ImageIcon myPIcon = new ImageIcon(this.getClass().getResource("/images/myPIcon.gif"));
	  
	    JFrame jfrm = new JFrame("Use Button Icons");    
	    jfrm.setLayout(new GridLayout(3,1,4,4));   
	    jfrm.setSize(200, 200);    
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	    jlab = new JLabel("Press a button.");  
	  
	    jbtn1 = new JButton("First", myIcon);  
	    jbtn2 = new JButton("Second", myIcon);  
	 
	    // Set rollover icons. 
	    jbtn1.setRolloverIcon(myROIcon); 
	    jbtn2.setRolloverIcon(myROIcon); 
	  
	    // Set pressed icons. 
	    jbtn1.setPressedIcon(myPIcon); 
	    jbtn2.setPressedIcon(myPIcon); 
	 
	    // Set disabled icons. 
	    jbtn1.setDisabledIcon(myDisIcon); 
	    jbtn2.setDisabledIcon(myDisIcon); 
	  
	    jbtn1.addActionListener(this); 
	    jbtn2.addActionListener(this);  
	    
	    jfrm.add(jbtn1);   
	    jfrm.add(jbtn2);    
	    jfrm.add(jlab);  
	    
	    JPanel cp = (JPanel) jfrm.getContentPane();
	    cp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    
	    jfrm.setVisible(true);  
	  }
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("First")){
			jlab.setText("First button was pressed."); 
			if(jbtn2.isEnabled()){
				jlab.setText("Second button is disabled.");  
		        jbtn2.setEnabled(false); 
			}else{
				jlab.setText("Second button is enabled.");  
		        jbtn2.setEnabled(true); 
			}
		}else{
			jlab.setText("Second button was pressed. ");
		}
	}
}
