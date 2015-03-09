package spinnerInts;

import javax.swing.SwingUtilities;

public class RunSpinnerInts {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SpinnerInts();
			}
		});

	}

}
