package simplePhoneList;

import javax.swing.SwingUtilities;

public class RunSimplePhoneList {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SimplePhoneList();
			}
		});

	}

}
