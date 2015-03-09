package jfilechooser;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class JavaFileFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
	    // Return true if the file is a Java source file or if it is a directory. 
	    if(f.getName().endsWith(".java")) {
	    	return true; 
	    }
	    if(f.isDirectory()) {
	    	return true; 
	    }	 
	    // Otherwise, return false. 
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		// return null;
		return "Java Source Code Files"; 
	}
	

}
