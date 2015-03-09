package tableColumnSelection;

import javax.swing.SwingUtilities;

public class RunTableColumnSelection {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new TableColumnSelection();
				
			}
			
		});

	}

}
