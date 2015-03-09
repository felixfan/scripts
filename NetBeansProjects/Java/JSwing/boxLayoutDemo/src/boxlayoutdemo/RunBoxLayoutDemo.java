package boxlayoutdemo;

import javax.swing.SwingUtilities;

public class RunBoxLayoutDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BoxLayoutDemo();
				
			}
		});

	}

}
