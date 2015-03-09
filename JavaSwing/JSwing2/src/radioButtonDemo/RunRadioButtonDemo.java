package radioButtonDemo;

import javax.swing.SwingUtilities;

public class RunRadioButtonDemo {

	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					new RadioButtonDemo();
				}
			});

		}
}
