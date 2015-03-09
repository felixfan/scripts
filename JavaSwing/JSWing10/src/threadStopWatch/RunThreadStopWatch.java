package threadStopWatch;

import javax.swing.SwingUtilities;

public class RunThreadStopWatch {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ThreadStopWatch();
				
			}
		});

	}

}
