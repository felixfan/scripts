package labelBorderDemo;

import javax.swing.SwingUtilities;

public class RunLabelBorderDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new LabelBorderDemo();
			}
		});

	}

}
