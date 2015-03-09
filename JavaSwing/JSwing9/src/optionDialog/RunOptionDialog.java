package optionDialog;

import javax.swing.SwingUtilities;

public class RunOptionDialog {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new OptionDialog();
				
			}
		});

	}

}
