package comparefiles;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CompareFiles {
	  JLabel jlabFirst, jlabSecond; 	 
	  JButton jbtnGetFirst, jbtnGetSecond, jbtnCompare; 	 
	  JTextField jtfFirst, jtfSecond; 	 
	  JFileChooser jfc; 
	 
	  CompareFiles() {        
	    JFrame jfrm = new JFrame("Compare Files");     
	    jfrm.setLayout(new FlowLayout());       
	    jfrm.setSize(450, 160);  
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	 
	    // Create labels for the text fields. 
	    jlabFirst = new JLabel("First file:"); 
	    jlabFirst.setPreferredSize(new Dimension(70, 20)); 
	    jlabFirst.setHorizontalAlignment(SwingConstants.RIGHT); 
	 
	    jlabSecond = new JLabel("Second file:"); 
	    jlabSecond.setPreferredSize(new Dimension(70, 20)); 
	    jlabSecond.setHorizontalAlignment(SwingConstants.RIGHT); 
	 
	    // Create the text fields that will hold the file names. 
	    jtfFirst = new JTextField(20); 
	    jtfSecond = new JTextField(20); 
	    
	    // Create the browse buttons. 
	    jbtnGetFirst = new JButton("Browse"); 
	    jbtnGetSecond = new JButton("Browse"); 
	 
	    // Create the button that begins the file comparison. 
	    jbtnCompare = new JButton("Compare Files"); 
	 
	    // Create the file chooser that will be used to select files when the user clicks a Browse button. 
	    jfc = new JFileChooser(); 
	 
	    // Browse for the first file. 
	    jbtnGetFirst.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	 
	        int result = jfc.showDialog(null, "Select"); 
	 
	        if(result == JFileChooser.APPROVE_OPTION) { 
	          File f = jfc.getSelectedFile(); 
	          jtfFirst.setText(f.getPath()); 
	        } 
	      }     
	    });  
	 
	    // Browse for the second file. 
	    jbtnGetSecond.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	 
	        int result = jfc.showDialog(null, "Select"); 
	 
	        if(result == JFileChooser.APPROVE_OPTION) { 
	          File f = jfc.getSelectedFile(); 
	          jtfSecond.setText(f.getPath()); 
	        } 
	      }     
	    });  
	 
	    // Compare the files. 
	    jbtnCompare.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	 
	        // First, confirm that the user entered both file names. 
	        if(jtfFirst.getText().length() == 0 || jtfSecond.getText().length() == 0) { 
	          JOptionPane.showMessageDialog(null, "Please specify the files to compare.", "File Name Not Specified", JOptionPane.WARNING_MESSAGE); 
	          return; 
	        } 
	 
	        // Next, create File objects from the file names. 
	        File f1 = new File(jtfFirst.getText()); 
	        File f2 = new File(jtfSecond.getText()); 
	 
	        // Confirm that both files exist. 
	        if(!f1.exists()) {
	        	JOptionPane.showMessageDialog(null, "The first file does not exist.", "File Not Found", JOptionPane.WARNING_MESSAGE); 
	          return; 
	        }   
	        if(!f2.exists()) { 
	          JOptionPane.showMessageDialog(null, "The second file does not exist.", "File Not Found", JOptionPane.WARNING_MESSAGE); 
	          return; 
	        }   
	 
	        // Compare the files. 
	        if(compare(f1, f2)) {
	        	JOptionPane.showMessageDialog(null,	"Files compare equal.", "Comparison Result", JOptionPane.INFORMATION_MESSAGE); 
	        } else {
		        JOptionPane.showMessageDialog(null, "Files differ.", "Comparison Result", JOptionPane.INFORMATION_MESSAGE); 
	        }
	      }
	    });  
	 
	    jfrm.add(jlabFirst); 
	    jfrm.add(jtfFirst); 
	    jfrm.add(jbtnGetFirst); 
	    jfrm.add(jlabSecond); 
	    jfrm.add(jtfSecond); 
	    jfrm.add(jbtnGetSecond); 
	    jfrm.add(jbtnCompare); 
	    
	    jfrm.setVisible(true);    
	  }    
	 
	  // Compare two files. 
	  boolean compare(File fileA, File fileB) { 
	 
	    // If the file lengths differ, the files differ. 
	    if(fileA.length() != fileB.length()) {
	    	return false; 
	    }
	 
	    FileInputStream f1, f2; 
	    int i, j; 
	    byte buf1[] = new byte[1024]; 
	    byte buf2[] = new byte[1024]; 
	 
	    try { 
	      f1 = new FileInputStream(fileA); 
	      f2 = new FileInputStream(fileB); 
	 
	      do { 
	        // This version of read() returns the number of bytes read, or -1 when the end of the file is reached. 
	        i = f1.read(buf1, 0, 1024); 
	        j = f2.read(buf2, 0, 1024); 
	 
	        // If the buffers are not equal, then the files differ. In that case, close the files and return false. 
	        if(!Arrays.equals(buf1, buf2)) { 
	          f1.close(); 
	          f2.close(); 
	          return false; 
	        } 
	      } while(i != -1 && j != -1); 
	 
	      f1.close(); 
	      f2.close(); 
	    } catch(IOException exc) { 
	      JOptionPane.showMessageDialog(null, exc, "File Error!", JOptionPane.WARNING_MESSAGE); 
	      return false; // return false on error 
	    } 
	 
	    // The files are equal, so return true. 
	    return true; 
	  } 

}
