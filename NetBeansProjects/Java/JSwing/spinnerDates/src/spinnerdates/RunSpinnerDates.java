package spinnerdates;

import javax.swing.SwingUtilities;

public class RunSpinnerDates {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SpinnerDates();
			}
		});

	}

}
