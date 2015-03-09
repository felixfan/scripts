package jTextAreaDemo;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class JTextAreaDemo {
	  JLabel jlabWC; 	  
	  JTextArea jta; 
	 
	  public JTextAreaDemo() { 
	    JFrame jfrm = new JFrame("A Simple JTextArea"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(240, 150); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	    jlabWC = new JLabel("Current word count is 0"); 
	    jta = new JTextArea(); 
	     
	    // Set line wrap on word boundaries. 
	    jta.setLineWrap(true); 
	    jta.setWrapStyleWord(true); 
	 
	    // Put the text area into a scroll pane. 
	    JScrollPane jscrlp = new JScrollPane(jta); 
	    jscrlp.setPreferredSize(new Dimension(100, 75)); 
	 
	    // Add a caret listener. This handler displays the word count in real time. 
	    jta.addCaretListener(new CaretListener() {    
	      public void caretUpdate(CaretEvent ce) {    
	        int wc; // this will hold the word count 
	 
	        // Get the current text. 
	        String str = jta.getText(); 
	 
	        if(str.length() == 0){
	        	wc = 0; // if no text present, word count is 0. 
	        } else { 
	          // Split the string into words based on non-word characters, such as whitespace and punctuation. 
	          String strsplit[] = str.split("\\W+"); 
	 
	          // The word count will equal the number of strings returned by split(). 
	          wc = strsplit.length; 
	 
	          // Handle the case of a leading non-word character. 
	          if(strsplit.length > 0 && strsplit[0].length() == 0) {
	        	  wc--; 
	          }
	        } 
	 
	        // Display the word count 
	        jlabWC.setText("Current word count is " + wc); 
	      }    
	    }); 
	 
	    jfrm.add(jscrlp);  
	    jfrm.add(jlabWC); 
	    jfrm.setVisible(true); 
	  } 
}
