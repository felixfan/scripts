package jPanelDemo;

import javax.swing.SwingUtilities;

public class RunJPanelDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new JPanelDemo();
			}
		});

	}

}
