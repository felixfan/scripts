package treedemo;

import javax.swing.SwingUtilities;

public class RunTreeDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TreeDemo();
				
			}
		});
	}

}
