package checkboxdemo;

import javax.swing.SwingUtilities;

public class RunCheckboxDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new CheckboxDemo();
			}
		});

	}

}
