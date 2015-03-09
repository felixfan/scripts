package tableDataChange;

import javax.swing.SwingUtilities;

public class RunTableDataChange {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TableDataChange();
				
			}
		});

	}

}
