package customTable;

import javax.swing.SwingUtilities;

public class RunCustomTable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new NumInfoTable();
				
			}
		});

	}

}
