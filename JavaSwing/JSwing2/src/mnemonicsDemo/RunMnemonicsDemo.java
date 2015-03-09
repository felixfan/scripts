package mnemonicsDemo;

import javax.swing.SwingUtilities;

public class RunMnemonicsDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MnemonicsDemo();
			}
		});

	}

}
