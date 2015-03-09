package jdialogdemo;

import javax.swing.SwingUtilities;

public class RunJDialogDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JDialogDemo();
				
			}
		});

	}

}
