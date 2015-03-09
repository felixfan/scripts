package jsplitpanedemo;

import javax.swing.SwingUtilities;

public class RunJSplitPaneDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JSplitPaneDemo();
			}
		});

	}
}
