package progressBarDemo;

import javax.swing.SwingUtilities;

public class RunProgressBarDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ProgressBarDemo();
			}
		});

	}

}
