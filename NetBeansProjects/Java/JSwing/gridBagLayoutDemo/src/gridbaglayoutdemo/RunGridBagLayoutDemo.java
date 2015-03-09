package gridbaglayoutdemo;

import javax.swing.SwingUtilities;

public class RunGridBagLayoutDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new GridBagLayoutDemo();
				
			}
		});

	}

}
