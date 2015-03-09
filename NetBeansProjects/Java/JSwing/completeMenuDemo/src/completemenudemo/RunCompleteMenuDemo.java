package completemenudemo;

import javax.swing.SwingUtilities;

public class RunCompleteMenuDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new CompleteMenuDemo();
				
			}
		});

	}

}
