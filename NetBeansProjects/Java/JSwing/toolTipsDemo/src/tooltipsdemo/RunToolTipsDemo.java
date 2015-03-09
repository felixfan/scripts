package tooltipsdemo;

import javax.swing.SwingUtilities;

public class RunToolTipsDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ToolTipsDemo();
			}
		});

	}

}
