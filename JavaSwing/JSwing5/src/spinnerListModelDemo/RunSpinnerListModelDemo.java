package spinnerListModelDemo;

import javax.swing.SwingUtilities;

public class RunSpinnerListModelDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SpinnerListModelDemo();
			}
		});

	}

}
