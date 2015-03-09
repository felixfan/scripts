package twotogglebuttonsdemo;

import javax.swing.SwingUtilities;

public class RunTwoToggleButtonsDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TwoToggleButtonsDemo();
			}
		});

	}

}
