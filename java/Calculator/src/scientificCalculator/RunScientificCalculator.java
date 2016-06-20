package scientificCalculator;

import javax.swing.SwingUtilities;

public class RunScientificCalculator {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new ScientificCalculator();
			}
		});

	}

}
