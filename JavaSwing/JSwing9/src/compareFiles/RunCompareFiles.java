package compareFiles;

import javax.swing.SwingUtilities;

public class RunCompareFiles {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new CompareFiles();
				
			}
		});

	}

}
