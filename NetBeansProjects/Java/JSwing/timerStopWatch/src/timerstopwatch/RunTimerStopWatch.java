package timerstopwatch;

import javax.swing.SwingUtilities;

public class RunTimerStopWatch {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TimerStopWatch();
				
			}
		});

	}

}
