package toggleButtonDemo;

import javax.swing.SwingUtilities;

public class RunToggleButtonDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ToggleButtonDemo();
			}
		});

	}

}
