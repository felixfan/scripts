package twoTextFieldDemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TwoTextFieldDemo implements ActionListener {
	
	JLabel jlab;
	JTextField jtf1;
	JTextField jtf2;
	
	TwoTextFieldDemo(){
		JFrame jfrm = new JFrame("Two Text Field Demo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400,200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf1.setActionCommand("one");
		jtf2.setActionCommand("two");
		jtf1.addActionListener(this);
		jtf2.addActionListener(this);
		jfrm.add(jtf1);
		jfrm.add(jtf2);
		
		jlab=new JLabel("");
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("one")){
			jlab.setText("ENTER pressed in jtf1: " + jtf1.getText());
		}else{
			jlab.setText("ENTER pressed in jtf2: " + jtf2.getText());
		}
	}
	
}
