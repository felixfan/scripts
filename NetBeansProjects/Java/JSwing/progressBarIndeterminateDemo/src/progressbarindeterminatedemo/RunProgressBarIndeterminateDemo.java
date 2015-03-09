package progressbarindeterminatedemo;

import javax.swing.SwingUtilities;

public class RunProgressBarIndeterminateDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ProgressBarIndeterminateDemo();
			}
		});

	}

}
