package menudemo;

import javax.swing.SwingUtilities;

public class RunMenuDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new MenuDemo();			
			}
			
		});

	}

}
