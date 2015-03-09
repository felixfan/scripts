package texteditor;

import javax.swing.SwingUtilities;

public class RunTextEditor {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TextEditor();
			}
		});

	}

}
