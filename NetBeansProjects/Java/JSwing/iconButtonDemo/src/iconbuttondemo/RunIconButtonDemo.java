package iconbuttondemo;

import javax.swing.SwingUtilities;

public class RunIconButtonDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new IconButtonDemo();
			}
		});

	}

}
