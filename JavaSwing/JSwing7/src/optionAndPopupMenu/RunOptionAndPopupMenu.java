package optionAndPopupMenu;

import javax.swing.SwingUtilities;

public class RunOptionAndPopupMenu {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new OptionAndPopupMenu();
				
			}
		});

	}

}
