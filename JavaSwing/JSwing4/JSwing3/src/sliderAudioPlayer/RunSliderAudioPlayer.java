package sliderAudioPlayer;

import javax.swing.SwingUtilities;

public class RunSliderAudioPlayer {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SliderAudioPlayer();
			}
		});

	}

}
