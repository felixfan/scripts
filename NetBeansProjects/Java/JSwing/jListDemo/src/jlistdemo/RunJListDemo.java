package jlistdemo;

import javax.swing.SwingUtilities;

public class RunJListDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JListDemo();
			}
		});

	}

}
