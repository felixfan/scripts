package simplePhoneList;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SimplePhoneList{
	  JTextField jtfName,jtfNumber;  
	  JRadioButton jrbExact,jrbStartsWith,jrbEndsWith; 
	  JCheckBox jcbIgnoreCase; 
	  
	  // A short list of names and phone numbers. 
	  String[][] phonelist = { 
	    {"Jon", "555-8765"}, 
	    {"Jessica", "555-5643"}, 
	    {"Adam", "555-1212" }, 
	    {"Rachel", "555-3435"}, 
	    {"Tom & Jerry", "555-1001"} 
	  };  
	  
	  SimplePhoneList(){
		    JFrame jfrm = new JFrame("A Simple Phone List");   
		    jfrm.setLayout(new GridLayout(0, 1)); 
		    jfrm.setSize(300, 220);   
		    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 
		    JLabel jlabName = new JLabel("Name");  
		    JLabel jlabNumber = new JLabel("Number");  
		    JLabel jlabOptions = new JLabel("Search Options"); 

		    jtfName = new JTextField(10);  
		    jtfNumber = new JTextField(10);  

		    jcbIgnoreCase = new JCheckBox("Ignore Case"); 

		    jrbExact = new JRadioButton("Exact Match", true); 
		    jrbStartsWith = new JRadioButton("Starts With"); 
		    jrbEndsWith = new JRadioButton("Ends With"); 
		 
		    ButtonGroup bg = new ButtonGroup(); 
		    bg.add(jrbExact); 
		    bg.add(jrbStartsWith); 
		    bg.add(jrbEndsWith); 
		    
		    // Add action listener for the Name text field.  
		    jtfName.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) { 
		    		jtfNumber.setText(lookupName(jtfName.getText())); 
		      }  
		    }); 
		 
		    // Add action listener for the Number text field.  
		    jtfNumber.addActionListener(new ActionListener() { 
		    	public void actionPerformed(ActionEvent ae) {  
		    		jtfName.setText(lookupNumber(jtfNumber.getText())); 
		      }  
		    }); 
		    
		    jfrm.add(jlabName);  
		    jfrm.add(jtfName);   
		    jfrm.add(jlabNumber);  
		    jfrm.add(jtfNumber);   
		    jfrm.add(new JLabel()); 
		    jfrm.add(jlabOptions); 
		    jfrm.add(jcbIgnoreCase); 
		    jfrm.add(new JLabel()); 
		    jfrm.add(jrbExact); 
		    jfrm.add(jrbStartsWith); 
		    jfrm.add(jrbEndsWith); 

		    jfrm.setVisible(true);  
	  }
	  
	// Look up a name and return the number. 
	  String lookupName(String n){
		  for(int i=0; i < phonelist.length; i++){
			   if(jrbStartsWith.isSelected()) { 
				   		if(jcbIgnoreCase.isSelected()) { 
				   			if(phonelist[i][0].toLowerCase().startsWith(n.toLowerCase())){
				   				return phonelist[i][1]; 
				   			}	
				   		} else { 
				   			if(phonelist[i][0].startsWith(n)){
				   				return phonelist[i][1]; 
				   			} 
				   		} 
			   }else if(jrbEndsWith.isSelected()) { 
			        	if(jcbIgnoreCase.isSelected()) { 
			        		if(phonelist[i][0].toLowerCase().endsWith(n.toLowerCase())){
			        			return phonelist[i][1]; 
			        		}
			        	} else { 
			        		if(phonelist[i][0].endsWith(n)) {
			        			return phonelist[i][1];
			        		}
			        	} 
			   } else {
			        	if(jcbIgnoreCase.isSelected()) { 
			        		if(phonelist[i][0].toLowerCase().equals(n.toLowerCase()))  {
			        			 return phonelist[i][1]; 
			        		}
			        	} else { 
			        		if(phonelist[i][0].equals(n)) {
			        			return phonelist[i][1]; 
			        		}
			        	} 
			   }  
		  }
		  return "Not Found"; 
	  }
	  
	  // Look up a number and return the name. 
	  String lookupNumber(String n) { 
		  for(int i=0; i < phonelist.length; i++) { 
			  	if(phonelist[i][1].equals(n)) {
			  		return phonelist[i][0]; 
			  	} 
		  } 
		  return "Not Found"; 
	  } 
	  
}
