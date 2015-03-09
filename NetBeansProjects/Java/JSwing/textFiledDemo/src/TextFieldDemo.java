

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextFieldDemo implements ActionListener{
	JLabel jlab;
	JTextField jtf;
	
	TextFieldDemo(){
		JFrame jfrm = new JFrame("Text Field Demo");
		jfrm.getContentPane().setLayout(new FlowLayout());
		jfrm.setSize(240,100);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf = new JTextField(10);
		jtf.addActionListener(this);
		jfrm.getContentPane().add(jtf);
		
		jlab = new JLabel("");
		jfrm.getContentPane().add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		jlab.setText("Curret text is: " + jtf.getText());
	}

}


