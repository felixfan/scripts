package listmodeldemo;

import javax.swing.SwingUtilities;

public class RunListModelDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ListModelDemo();
			}
		});
	}

}
