package jPasswordFieldDemo;

import javax.swing.SwingUtilities;

public class RunJPasswordFieldDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JPasswordFieldDemo();
			}
		});

	}

}
