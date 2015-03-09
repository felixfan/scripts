package sliderdemo;

import javax.swing.SwingUtilities;

public class RunSliderDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SliderDemo();
			}
		});

	}

}
