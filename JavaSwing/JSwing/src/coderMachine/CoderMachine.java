package coderMachine;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CoderMachine implements ActionListener{
	JTextField jtf1;
	JTextField jtf2;
	
	CoderMachine(){
		JFrame jfrm = new JFrame("A Simple Coder Machine");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(350, 150);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlab1 = new JLabel("  plain text:");
		JLabel jlab2 = new JLabel("cipher text:");
		
		jtf1 = new JTextField(20);
		jtf2 = new JTextField(20);
		jtf1.setActionCommand("Encode"); // same as press "Encode" button
		jtf2.setActionCommand("Decode"); // same as press "Decode" button
		jtf1.addActionListener(this);
		jtf2.addActionListener(this);
		
		jfrm.add(jlab1);
		jfrm.add(jtf1);
		jfrm.add(jlab2);
		jfrm.add(jtf2);
		
		JButton jbtn1 = new JButton("Encode");
		JButton jbtn2 = new JButton("Decode");
		JButton jbtn3 = new JButton("Reset");
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		jbtn3.addActionListener(this);
		
		jfrm.add(jbtn1);
		jfrm.add(jbtn2);
		jfrm.add(jbtn3);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Encode")){
			StringBuilder str = new StringBuilder(jtf1.getText());
			for (int i = 0; i < str.length(); i++) {
				str.setCharAt(i, (char)(str.charAt(i)+1));
			}
			jtf2.setText(str.toString());
		}else if(ae.getActionCommand().equals("Decode")){
			StringBuilder str = new StringBuilder(jtf2.getText());
			for (int i = 0; i < str.length(); i++) {
				str.setCharAt(i, (char)(str.charAt(i)-1));
			}
			jtf1.setText(str.toString());
		}else{
			jtf1.setText("");
			jtf2.setText("");
		}
	}

}
