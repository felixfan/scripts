package jScrollPanel;

import javax.swing.SwingUtilities;

public class RunJScrollPanel {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JScrollPanel();
			}
		});

	}

}
