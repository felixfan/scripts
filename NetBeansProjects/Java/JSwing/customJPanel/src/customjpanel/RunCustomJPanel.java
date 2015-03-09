package customjpanel;

import javax.swing.SwingUtilities;

public class RunCustomJPanel {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new CustomJPanelDemo();
			}
		});

	}
}
