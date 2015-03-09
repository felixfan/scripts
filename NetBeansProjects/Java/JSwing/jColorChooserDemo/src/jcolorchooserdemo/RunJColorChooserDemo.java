package jcolorchooserdemo;

import javax.swing.SwingUtilities;

public class RunJColorChooserDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JColorChooserDemo();
				
			}
		});

	}

}
