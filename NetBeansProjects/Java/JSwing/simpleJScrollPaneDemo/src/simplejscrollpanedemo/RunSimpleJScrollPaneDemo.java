package simplejscrollpanedemo;

import javax.swing.SwingUtilities;

public class RunSimpleJScrollPaneDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SimpleJScrollPaneDemo();
			}
		});

	}

}
