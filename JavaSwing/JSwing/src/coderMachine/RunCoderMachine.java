package coderMachine;

import javax.swing.SwingUtilities;

public class RunCoderMachine {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new CoderMachine();
			}
		});

	}

}
