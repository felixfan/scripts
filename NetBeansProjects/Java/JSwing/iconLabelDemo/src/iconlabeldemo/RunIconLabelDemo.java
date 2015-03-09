package iconlabeldemo;

import javax.swing.SwingUtilities;

public class RunIconLabelDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new IconLabelDemo();
			}
		});

	}

}
