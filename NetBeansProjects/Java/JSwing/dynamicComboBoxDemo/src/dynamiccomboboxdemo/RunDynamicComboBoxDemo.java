package dynamiccomboboxdemo;

import javax.swing.SwingUtilities;

public class RunDynamicComboBoxDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new DynamicComboBoxDemo();
			}
		});

	}

}
