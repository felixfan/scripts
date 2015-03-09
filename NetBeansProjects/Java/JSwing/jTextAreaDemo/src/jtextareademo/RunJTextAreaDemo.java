package jtextareademo;

import javax.swing.SwingUtilities;

public class RunJTextAreaDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JTextAreaDemo();
			}
		});

	}
}
