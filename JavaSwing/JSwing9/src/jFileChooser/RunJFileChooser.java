package jFileChooser;

import javax.swing.SwingUtilities;

public class RunJFileChooser {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JFileChooserDemo();
				
			}
		});

	}

}
