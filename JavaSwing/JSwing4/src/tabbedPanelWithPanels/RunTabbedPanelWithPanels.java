package tabbedPanelWithPanels;

import javax.swing.SwingUtilities;

public class RunTabbedPanelWithPanels {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TabbedPanelWithPanels();
			}
		});
	}
}
