package jtextfielddemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class JTextFieldDemo {
	  JLabel jlabAll,jlabSelected; 	  
	  JTextField jtf; 	 
	  JButton jbtnCut,jbtnPaste; 
	 
	  public JTextFieldDemo() { 
	    JFrame jfrm = new JFrame("Use JTextField"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(200, 150); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 
	    jlabAll = new JLabel("All text: "); 
	    jlabSelected = new JLabel("Selected text: "); 
	 
	    jtf = new JTextField("This is a test.", 15); 
	 
	    // Add an action listener for the text field. 
	    // Each time the user presses enter, the contents of the field are displayed.  
	    // Any currently selected text is also displayed. 
	    jtf.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {    
	        jlabAll.setText("All text: " + jtf.getText()); 
	        jlabSelected.setText("Selected text: " + jtf.getSelectedText());  	                                  
	      }    
	    });    
	 
	    // Create the Cut and Paste buttons. 
	    jbtnCut = new JButton("Cut"); 
	    jbtnPaste = new JButton("Paste"); 
	 
	    // Add action listener for the Cut button. 
	    jbtnCut.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {    
	        // Cut any selected text and put it in the clipboard. 
	        jtf.cut(); 
	        jlabAll.setText("All text: " + jtf.getText()); 
	        jlabSelected.setText("Selected text: " + jtf.getSelectedText());	                                    
	      }    
	    });  
	   
	    // Add action listener for the Paste button. 
	    jbtnPaste.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {    
	        // Paste text from the clipboard into the text field. 
	        jtf.paste(); 
	      }    
	    });    
	 
	    // Add a caret listener. This lets the application respond in real time to changes in the text field. 
	    jtf.addCaretListener(new CaretListener() {    
	      public void caretUpdate(CaretEvent ce) {    
	        jlabAll.setText("All text: " + jtf.getText()); 
	        jlabSelected.setText("Selected text: " + jtf.getSelectedText());	                             
	      }    
	    }); 
	 
	    // Add the components to the content pane. 
	    jfrm.add(jtf);  
	    jfrm.add(jbtnCut); 
	    jfrm.add(jbtnPaste); 
	    jfrm.add(jlabAll); 
	    jfrm.add(jlabSelected); 
	 
	    // Set the caret to the just after the 5th character. 
	    jtf.setCaretPosition(5); 
	    // Now, move the caret just after the 7th character. 
	    // This sequence causes the word "is" to be selected. 
	    jtf.moveCaretPosition(7); 
	 
	    jfrm.setVisible(true); 
	  } 
}
