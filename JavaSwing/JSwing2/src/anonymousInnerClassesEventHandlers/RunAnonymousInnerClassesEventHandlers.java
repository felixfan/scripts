package anonymousInnerClassesEventHandlers;

import javax.swing.SwingUtilities;

public class RunAnonymousInnerClassesEventHandlers {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new AnonymousInnerClassesEventHandlers();
			}
		});

	}

}
