package disabledLabelDemo;

import javax.swing.SwingUtilities;

public class RunDisabledLabelDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new DisabledLabelDemo();
			}
		});

	}

}
