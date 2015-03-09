

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StopWatch implements ActionListener{
	JLabel jlab;
	long start;
	
	StopWatch(){
		
		JFrame jfrm = new JFrame("StopWatch");
		jfrm.getContentPane().setLayout(new FlowLayout());
		jfrm.setSize(200, 90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jbtn1 = new JButton("Start");
		JButton jbtn2 = new JButton("Stop");
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		jfrm.getContentPane().add(jbtn1);
		jfrm.getContentPane().add(jbtn2);
		
		jlab = new JLabel("Press start to begin timing");
		jfrm.getContentPane().add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		Calendar cal = Calendar.getInstance();
		
		if(ae.getActionCommand().equals("Start")){
			start = cal.getTimeInMillis();
			jlab.setText("stopwatch is running...");
		}else{
			jlab.setText("Elapsed time is: " + (double) (cal.getTimeInMillis() - start)/1000 + "seconds.");
		}
	}

}
