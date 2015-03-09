package customcellrenderer;

import javax.swing.SwingUtilities;

public class RunCustomCellRenderer {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new CellRendererDemo();
				
			}
		});

	}

}
