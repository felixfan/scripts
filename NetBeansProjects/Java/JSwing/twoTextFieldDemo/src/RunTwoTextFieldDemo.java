

import javax.swing.SwingUtilities;

public class RunTwoTextFieldDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TwoTextFieldDemo();
			}
		});

	}

}
