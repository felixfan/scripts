package jFileChooser;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFileChooserDemo {
	  JLabel jlab; 
	  JButton jbtnShow; 
	  JFileChooser jfc; 
	  JFrame jfrm;
	 
	  JFileChooserDemo() {       
		jfrm = new JFrame("JFileChooser Demo");     
	    jfrm.setLayout(new FlowLayout());    	     
	    jfrm.setSize(400, 200);     
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	 
	    // Create a label that will show the selected file. 
	    jlab = new JLabel(); 
	    
	    // Create button that will show the dialog. 
	    jbtnShow = new JButton("Show File Chooser"); 
	 
	    // Create the file chooser. 
	    jfc = new JFileChooser(); 
	    jfc.setFileFilter(new JavaFileFilter());
	    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    jfc.setMultiSelectionEnabled(true);
	     
	    // Show the file chooser when the Show button is pressed. 
	    jbtnShow.addActionListener(new ActionListener() {     
	      public void actionPerformed(ActionEvent le) { 
	        // Pass null for the parent. This centers the dialog on the screen. 
	        int result = jfc.showOpenDialog(null); 
	        File[] files = jfc.getSelectedFiles();
	 
	        if(result == JFileChooser.APPROVE_OPTION){
	        	// jlab.setText("Selected file is: " +  jfc.getSelectedFile().getName()); 
	        	String filenames=" ";
	        	for(File file:files){
	        		filenames += file.getName();
	        		filenames +="  ";
	        		// file.getAbsolutePath();
	        	}
	        	jlab.setText("Selected file is:" + filenames); 
	        }
	        else{
	        	jlab.setText("No file selected."); 
	        }
	      }     
	    });  
	 
	    jfrm.add(jbtnShow); 
	    jfrm.add(jlab); 
	   
	    jfrm.setVisible(true);    
	  }    

}
