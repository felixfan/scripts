package simpleTableDemo;

import javax.swing.SwingUtilities;

public class RunSimpleTableDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new SimpleTableDemo();
				
			}
			
		});

	}

}
