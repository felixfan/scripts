package stopWatchOneButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StopWatchOneButton implements ActionListener{
	JLabel jlab;
	JButton jbtn1;
	long start;
	
	StopWatchOneButton(){
		
		JFrame jfrm = new JFrame("Stop Watch with One Button");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(200, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbtn1 = new JButton("Start");
		jbtn1.addActionListener(this);
		jfrm.add(jbtn1);
	
		jlab = new JLabel("Press start to begin timing");
		jfrm.getContentPane().add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		Calendar cal = Calendar.getInstance();
		
		if(ae.getActionCommand().equals("Start")){
			start = cal.getTimeInMillis();
			jlab.setText("stopwatch is running...");
			jbtn1.setText("Stop");
		}else{
			jbtn1.setText("Start");
			jlab.setText("Elapsed time is: " + (double) (cal.getTimeInMillis() - start)/1000 + "seconds.");
		}
	}

}
