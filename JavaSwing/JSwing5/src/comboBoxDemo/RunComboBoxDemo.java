package comboBoxDemo;

import javax.swing.SwingUtilities;

public class RunComboBoxDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ComboBoxDemo();
			}
		});

	}

}
