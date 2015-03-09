package scrollBarDemo;

import javax.swing.SwingUtilities;

public class RunScrollBarDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ScrollBarDemo();
			}
		});

	}

}
