package dynamicmenudemo;

import javax.swing.SwingUtilities;

public class RunDynamicMenuDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new DynamicMenuDemo();
				
			}
			
		});

	}

}
