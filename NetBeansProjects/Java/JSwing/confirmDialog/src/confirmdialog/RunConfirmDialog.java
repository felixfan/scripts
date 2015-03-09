package confirmdialog;

import javax.swing.SwingUtilities;

public class RunConfirmDialog {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ConfirmDialog();
				
			}
		});

	}

}
