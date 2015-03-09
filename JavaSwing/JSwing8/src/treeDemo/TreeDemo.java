package treeDemo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class TreeDemo {
	JLabel jlab;
	TreeDemo() {      
	    JFrame jfrm = new JFrame("Tree Demo");     
	    jfrm.setSize(250, 250);       
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	    
	    // Create a label that will display the tree selection.  
	    jlab = new JLabel(); 
	    
	    // Begin creating the tree by defining the structure and relationship of its nodes. 	 
	    // First, create root node of tree. 
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Food"); 
	 
	    // Next, create two subtrees.  One contains fruit, the other vegetables. 	 
	    // Create the root of the Fruit subtree. 
	    DefaultMutableTreeNode fruit = new DefaultMutableTreeNode("Fruit"); 
	    root.add(fruit); // add the Fruit node to the tree. 
	 
	    // The Fruit subtree has two subtrees of its own. The first is Apples. The second is Pears. 	 
	    // Create an Apples subtree. 
	    DefaultMutableTreeNode apples = new DefaultMutableTreeNode("Apples"); 
	    fruit.add(apples); // add the Apples node to Fruit 
	 
	    // Populate the Apples subtree by adding apple varieties to the Apples subtree. 
	    apples.add(new DefaultMutableTreeNode("Jonathan")); 
	    apples.add(new DefaultMutableTreeNode("Winesap")); 
	 
	    // Create a Pears subtree. 
	    DefaultMutableTreeNode pears = new DefaultMutableTreeNode("Pears"); 
	    fruit.add(pears); // add the Pears node to fruit 
	 
	    // Populate the Pears subtree by adding pear varieties to the Pears subtree. 
	    pears.add(new DefaultMutableTreeNode("Bartlett")); 
	 
	    // Create the root of the Vegetable subtree. 
	    DefaultMutableTreeNode veg =  new DefaultMutableTreeNode("Vegetables"); 
	    root.add(veg); // add the Vegetable node to the tree 
	 
	    // Populate Vegetables. 
	    veg.add(new DefaultMutableTreeNode("Beans")); 
	    veg.add(new DefaultMutableTreeNode("Corn")); 
	    veg.add(new DefaultMutableTreeNode("Potatoes")); 
	    veg.add(new DefaultMutableTreeNode("Rice")); 
	 
	    // Now, create a JTree that uses the structure defined by the preceding statements. 
	    JTree jtree = new JTree(root); 
	    
	    // Allow the tree to be edited so that model events can be generated. 
	    jtree.setEditable(true); 
	 
	    // Set the tree selection mode to single-selection. 
	    TreeSelectionModel tsm = jtree.getSelectionModel(); 
	    tsm.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); 
	 
	    // Finally, wrap the tree in a scroll pane. 
	    JScrollPane jscrlp = new JScrollPane(jtree); 
	    
	    // Listen for tree expansion events. 
	    jtree.addTreeExpansionListener(new TreeExpansionListener() {    
	      public void treeExpanded(TreeExpansionEvent tse) {  
	        // Get the path to the expansion point. 
	        TreePath tp = tse.getPath(); 
	 
	        // Display the node 
	        jlab.setText("Expansion: " + tp.getLastPathComponent()); 
	      }    
	 
	      public void treeCollapsed (TreeExpansionEvent tse) {  	      
	        TreePath tp = tse.getPath(); 
	        jlab.setText("Collapse: " + tp.getLastPathComponent()); 
	      }    
	    });   
	 
	    // Listen for tree selection events. 
	    jtree.addTreeSelectionListener(new TreeSelectionListener() {    
	      public void valueChanged(TreeSelectionEvent tse) {  
	        TreePath tp = tse.getPath(); 
	        jlab.setText("Selection event: " + tp.getLastPathComponent()); 
	      }    
	    });   
	 
	    // Listen for tree model events. Notice that the listener is registered with the tree model. 
	    jtree.getModel().addTreeModelListener(new TreeModelListener() {    
	      public void treeNodesChanged(TreeModelEvent tse) {  
	        TreePath tp = tse.getTreePath(); 
	        jlab.setText("Model change path: " + tp); 
	      } 
	 
	      // Empty implementations of the remaing TreeModelEvent methods. 
	      // Implement these if your application needs to handle these actions. 
	      public void treeNodesInserted(TreeModelEvent tse) {} 
	      public void treeNodesRemoved(TreeModelEvent tse) {} 
	      public void treeStructureChanged(TreeModelEvent tse) {} 
	    });   
	 
	    jfrm.add(jscrlp, BorderLayout.CENTER); 
	    jfrm.add(jlab, BorderLayout.SOUTH); 
	    
	    jfrm.setVisible(true);    
	  }    

}
