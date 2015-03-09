package stopWatch;

import javax.swing.SwingUtilities;

public class RunStopWatch {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new StopWatch();
			}
		});

	}

}
