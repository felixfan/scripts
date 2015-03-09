package stopWatchOneButton;

import javax.swing.SwingUtilities;

public class RunStopWatchOneButton {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new StopWatchOneButton();
			}
		});

	}

}
