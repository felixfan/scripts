package texteditor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class TextEditor {
	  JLabel jlabMsg; 	  
	  JTextArea jta; 	 
	  JTextField jtfFName,jtfFind; 	 
	  JButton jbtnSave,jbtnLoad,jbtnFind,jbtnFindNext; 	 
	  int findIdx; 
	 
	  public TextEditor() { 
	    JFrame jfrm = new JFrame("A Simple Text Editor"); 
	    jfrm.setLayout(new FlowLayout()); 
	    jfrm.setSize(270, 450); 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 
	    // Create the message label. 
	    jlabMsg = new JLabel(); 
	    jlabMsg.setPreferredSize(new Dimension(200, 30)); 
	    jlabMsg.setHorizontalAlignment(SwingConstants.CENTER); 
	 
	    // Create an empty label to add space. 
	    JLabel jlabSeparator = new JLabel(); 
	    jlabSeparator.setPreferredSize(new Dimension(200, 30)); 
	 
	    // Create the Search For and Filename labels. 
	    JLabel jlabFind = new JLabel("Search For:"); 
	    jlabFind.setPreferredSize(new Dimension(70, 20)); 
	    jlabFind.setHorizontalAlignment(SwingConstants.RIGHT); 
	 
	    JLabel jlabFilename = new JLabel("Filename:"); 
	    jlabFilename.setPreferredSize(new Dimension(70, 20)); 
	    jlabFilename.setHorizontalAlignment(SwingConstants.RIGHT); 
	 
	    // Create the text field. 
	    jta = new JTextArea(); 
	     
	    // Put the text area into a scroll pane. 
	    JScrollPane jscrlp = new JScrollPane(jta); 
	    jscrlp.setPreferredSize(new Dimension(250, 200)); 
	 
	    // Create text field for filename. 
	    jtfFName = new JTextField(15); 
	 
	    // Add a caret listener for the text area. This handler displays number of characters in the file. 
	    // It is updated with each caret change. 
	    // The findIdx variable is also set to the current caret location. 
	    jta.addCaretListener(new CaretListener() {    
	      public void caretUpdate(CaretEvent ce) { 
	        String str = jta.getText(); 
	        jlabMsg.setText("Current size: " + str.length()); 
	        findIdx = jta.getCaretPosition(); 
	      }    
	    }); 
	 
	    // Create the Save and Load buttons. 
	    jbtnSave = new JButton("Save File"); 
	    jbtnLoad = new JButton("Load File"); 
	 
	    // Add action listener for the Save button. 
	    jbtnSave.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {  
	        save(); 
	      }    
	    });  
	 
	    // Add action listener for the Load button. 
	    jbtnLoad.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {  
	        load(); 
	      }    
	    });  
	 
	    // Create the Search For text field. 
	    jtfFind = new JTextField(15); 
	 
	    // Create the Find From Top and Find Next buttons. 
	    jbtnFind = new JButton("Find From Top"); 
	    jbtnFindNext = new JButton("Find Next"); 
	 
	    // Add action listener for the Find button. 
	    jbtnFind.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {  
	        findIdx = 0; 
	        find(findIdx); 
	      }    
	    });  
	 
	    // Add action listener for the Find Next button. 
	    jbtnFindNext.addActionListener(new ActionListener() {    
	      public void actionPerformed(ActionEvent le) {  
	        find(findIdx+1); 
	      }    
	    });  

	    jfrm.add(jscrlp);  
	    jfrm.add(jlabFind); 
	    jfrm.add(jtfFind); 
	    jfrm.add(jbtnFind); 
	    jfrm.add(jbtnFindNext); 
	    jfrm.add(jlabSeparator); 
	    jfrm.add(jlabFilename);  
	    jfrm.add(jtfFName); 
	    jfrm.add(jbtnSave); 
	    jfrm.add(jbtnLoad);    
	    jfrm.add(jlabMsg); 

	    jfrm.setVisible(true); 
	  } 
	  
	  // Save the file. 
	  void save() { 
	    FileWriter fw; 	 
	    // Get the filename from the text field. 
	    String fname = jtfFName.getText(); 
	         
	    // Make sure that there is actually a filename present. 
	    if(fname.length() == 0) { 
	      jlabMsg.setText("No filename present."); 
	      return; 
	    } 
	 
	    // Save the file. 
	    try { 
	      fw = new FileWriter(fname); 
	      jta.write(fw); 
	      fw.close(); 
	    } catch(IOException exc) { 
	      jlabMsg.setText("Error opening or writing file."); 
	      return; 
	    } 
	 
	    jlabMsg.setText("File written sucessfully."); 
	  } 
	 
	  // Load the file. 
	  void load() { 
	    FileReader fr; 
	 
	    // Get the filename from the text field. 
	    String fname = jtfFName.getText(); 
	         
	    // Make sure that there is actually a filename present. 
	    if(fname.length() == 0) { 
	      jlabMsg.setText("No filename present."); 
	      return; 
	    } 
	 
	    // Load the file. 
	    try { 
	      fr = new FileReader(fname); 
	      jta.read(fr, null); 
	      fr.close(); 
	    } catch(IOException exc) { 
	      jlabMsg.setText("Error opening or reading file."); 
	      return; 
	    } 
	 
	    // Reset find index when a new file is loaded. 
	    findIdx = 0; 
	 
	    jlabMsg.setText("File loaded successfully."); 
	  } 
	 
	  // Search the file. 
	  void find(int start) { 
	    // Get the current text as a string. 
	    String str = jta.getText(); 
	 
	    // Get the string to find. 
	    String findStr = jtfFind.getText(); 
	 
	    // Beginning at start, find the first occurrence of the specified string. 
	    int idx = str.toLowerCase().indexOf(findStr.toLowerCase(), start); // case insensitive
	    // int idx = str.indexOf(findStr, start); // case sensitive
	    	 
	    // See if there is a match. 
	    if(idx > -1) {           
	      // If found, set focus to text area and move caret to the location. 
	      jta.setCaretPosition(idx); 
	      findIdx = idx; // update the find index 
	      jlabMsg.setText("String found."); 
	    } 
	    else {
	    	jlabMsg.setText("String not found."); 
	    }
	 
	    // Set the focus to the editor window. 
	    jta.requestFocusInWindow(); 
	  } 
	 
}
