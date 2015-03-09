package paintDemo;

import javax.swing.SwingUtilities;

public class RunPaintDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JPaintDemo();
				
			}
		});
	}

}
