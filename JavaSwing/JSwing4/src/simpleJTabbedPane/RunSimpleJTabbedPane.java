package simpleJTabbedPane;

import javax.swing.SwingUtilities;

public class RunSimpleJTabbedPane {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SimpleJTabbedPane();
			}
		});
	}

}
