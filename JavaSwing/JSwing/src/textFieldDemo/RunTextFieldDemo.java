package textFieldDemo;

import javax.swing.SwingUtilities;

public class RunTextFieldDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TextFieldDemo();
			}
		});


	}

}
