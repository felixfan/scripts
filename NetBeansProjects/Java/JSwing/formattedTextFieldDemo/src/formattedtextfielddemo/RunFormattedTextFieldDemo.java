package formattedtextfielddemo;

import javax.swing.SwingUtilities;

public class RunFormattedTextFieldDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new FormattedTextFieldDemo();
			}
		});

	}

}
