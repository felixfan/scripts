package slideraudioplayer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// A class that holds the audio settings. 
class Presets { 
  int bass; 
  int midrange; 
  int treble; 
  int balance; 
  int volume; 
 
  Presets(int b, int m, int t, int bl, int v) { 
    bass = b; 
    midrange = m; 
    treble = t; 
    balance = bl; 
    volume = v; 
  } 
}

//The main audio interface class. 
public class SliderAudioPlayer implements ChangeListener {
	  JLabel jlabBass,jlabMidrange,jlabTreble,jlabBalance,jlabVolume,jlabInfo; 	 
	  JSlider jsldrBass,jsldrMidrange,jsldrTreble,jsldrBalance,jsldrVolume; 	 
	  JRadioButton jrbPreset1,jrbPreset2,jrbDefaults; 	 
	  JButton jbtnStore; 	 
	  DecimalFormat df; 	  
	  Presets[] presets; 
	 
	  SliderAudioPlayer() {   
	    JFrame jfrm = new JFrame("A Simple Audio Player Interface");  
	    jfrm.setLayout(new FlowLayout());  
	    jfrm.setSize(340, 520);   
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	 
	    // Create a decimal format that shows both + and - signs. 
	    df = new DecimalFormat("+#;-#"); 
	 
	    // Set presets. 
	    setupPresets(); 
	 
	    // Create the sliders. 
	    setupSliders(); 
	 
	    // Create the labels that describe the sliders. 
	    setupLabels(); 
	 
	    // Create the presets radio buttons. 
	    setupRButtons(); 
	 
	    // Create the Store Settings button. 
	    jbtnStore = new JButton("Store Settings"); 
	 
	    // Add change listeners for the sliders. 
	    jsldrBass.addChangeListener(this); 
	    jsldrMidrange.addChangeListener(this); 
	    jsldrTreble.addChangeListener(this); 
	    jsldrBalance.addChangeListener(this); 
	    jsldrVolume.addChangeListener(this); 
	 
	    // Handle Store Settings button. 
	    jbtnStore.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        if(jrbPreset1.isSelected()) 
	          storePreset(presets[1]); 
	        else if(jrbPreset2.isSelected()) 
	          storePreset(presets[2]); 
	      } 
	    });  
	 
	    // Handle Defaults radio button. 
	    jrbDefaults.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        loadPreset(presets[0]); 
	      } 
	    });  
	 
	    // Handle Preset 1 radio button. 
	    jrbPreset1.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        loadPreset(presets[1]); 
	      } 
	    });  
	 
	    // Handle Preset 2 radio button. 
	    jrbPreset2.addActionListener(new ActionListener() {  
	      public void actionPerformed(ActionEvent ae) {  
	        loadPreset(presets[2]); 
	      } 
	    });  
	 
	    // Add components to the content pane.  
	    Container cp = jfrm.getContentPane(); 
	    cp.add(jlabBass); 
	    cp.add(jsldrBass); 
	    cp.add(jlabMidrange); 
	    cp.add(jsldrMidrange); 
	    cp.add(jlabTreble); 
	    cp.add(jsldrTreble); 
	    cp.add(jlabBalance); 
	    cp.add(jsldrBalance); 
	    cp.add(jlabVolume); 
	    cp.add(jsldrVolume); 
	    cp.add(jrbDefaults); 
	    cp.add(jrbPreset1); 
	    cp.add(jrbPreset2); 
	    cp.add(jbtnStore); 
	    cp.add(new JLabel("")); 
	    cp.add(jlabInfo); 
 
	    jfrm.setVisible(true);  
	  }  
	 
	  // Handle slider events. 
	  public void stateChanged(ChangeEvent ce) {  
	    showSettings(); // update the info display 
	  } 
	 
	  // Create and initialize sliders. 
	  void setupSliders() { 
	    // Create the sliders. 
	    jsldrBass = new JSlider(-10, 10); 
	    jsldrMidrange = new JSlider(-10, 10); 
	    jsldrTreble = new JSlider(-10, 10);  
	    jsldrVolume = new JSlider(0, 10, 0);  
	    jsldrBalance = new JSlider(-5, 5);  
	  
	    // Add major tick marks. 
	    jsldrBass.setMajorTickSpacing(2); 
	    jsldrMidrange.setMajorTickSpacing(2); 
	    jsldrTreble.setMajorTickSpacing(2); 
	    jsldrVolume.setMajorTickSpacing(1); 
	    jsldrBalance.setMajorTickSpacing(1); 
	 
	    // Add minor tick marks. 
	    jsldrBass.setMinorTickSpacing(1); 
	    jsldrMidrange.setMinorTickSpacing(1); 
	    jsldrTreble.setMinorTickSpacing(1); 
	 
	    // Create labels for Bass, Midrange, and Treble sliders. 
	    Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>(); 
	    for(int i = -10; i <= 0; i += 2) 
	      table.put(new Integer(i), new JLabel("" + i)); 
	    for(int i = 2; i <= 10; i += 2) 
	      table.put(new Integer(i), new JLabel("+" + i)); 
	    jsldrTreble.setLabelTable(table); 
	    jsldrMidrange.setLabelTable(table); 
	    jsldrBass.setLabelTable(table); 
	 
	    // Create labels for the Balance slider. 
	    table = new Hashtable<Integer, JLabel>(); 
	    table.put(new Integer(0), new JLabel("Center")); 
	    table.put(new Integer(-5), new JLabel("L")); 
	    table.put(new Integer(5), new JLabel("R")); 
	    jsldrBalance.setLabelTable(table); 
	 
	    // Create standard numeric labels for volume slider. 
	    jsldrVolume.setLabelTable(jsldrVolume.createStandardLabels(1)); 
	 
	    // Cause the tick marks to be displayed. 
	    jsldrBass.setPaintTicks(true); 
	    jsldrMidrange.setPaintTicks(true); 
	    jsldrTreble.setPaintTicks(true); 
	    jsldrVolume.setPaintTicks(true); 
	    jsldrBalance.setPaintTicks(true); 
	 
	    // Cause the slider labels to be displayed. 
	    jsldrBass.setPaintLabels(true); 
	    jsldrMidrange.setPaintLabels(true); 
	    jsldrTreble.setPaintLabels(true); 
	    jsldrVolume.setPaintLabels(true); 
	    jsldrBalance.setPaintLabels(true); 
	 
	    // Move to closest tick mark. 
	    jsldrBass.setSnapToTicks(true); 
	    jsldrMidrange.setSnapToTicks(true); 
	    jsldrTreble.setSnapToTicks(true); 
	    jsldrVolume.setSnapToTicks(true); 
	    jsldrBalance.setSnapToTicks(true); 
	 
	    // Set the preferred slider size. 
	    Dimension sldrSize = new Dimension(240, 60); 
	    jsldrBass.setPreferredSize(sldrSize); 
	    jsldrMidrange.setPreferredSize(sldrSize); 
	    jsldrTreble.setPreferredSize(sldrSize); 
	    jsldrVolume.setPreferredSize(sldrSize); 
	    jsldrBalance.setPreferredSize(sldrSize); 
	  } 
	 
	  // Create the labels that describe the sliders. 
	  void setupLabels() { 
	    // Create the labels. 
	    jlabTreble = new JLabel("Treble"); 
	    jlabMidrange = new JLabel("Midrange"); 
	    jlabBass = new JLabel("Bass"); 
	    jlabVolume = new JLabel("Volume"); 
	    jlabBalance = new JLabel("Balance"); 
	 
	    // Set preferred size for slider labels. 
	    Dimension labSize = new Dimension(60, 25); 
	    jlabTreble.setPreferredSize(labSize); 
	    jlabMidrange.setPreferredSize(labSize); 
	    jlabBass.setPreferredSize(labSize); 
	    jlabVolume.setPreferredSize(labSize); 
	    jlabBalance.setPreferredSize(labSize); 
	 
	    // Create and size the audio info label. 
	    jlabInfo = new JLabel(""); 
	    jlabInfo.setPreferredSize(new Dimension(110, 100)); 
	 
	    // Load jlabInfo with the default settings. 
	    showSettings(); 
	  } 
	 
	  // Create and initialize the presets radio buttons. 
	  void setupRButtons() { 
	    // Create the presets radio buttons. 
	    jrbDefaults = new JRadioButton("Defaults"); 
	    jrbPreset1 = new JRadioButton("Preset 1"); 
	    jrbPreset2 = new JRadioButton("Preset 2"); 
	 
	    // Add the radio buttons to a button group. 
	    ButtonGroup bg = new ButtonGroup(); 
	    bg.add(jrbDefaults); 
	    bg.add(jrbPreset1); 
	    bg.add(jrbPreset2); 
	 
	    // Select the Default button. 
	    jrbDefaults.setSelected(true); 
	  } 
	 
	  // Display the current settings. 
	  void showSettings() { 
	    String bal; 
	 
	    // Get balance setting. 
	    int b = jsldrBalance.getValue(); 
	    if(b > 0) 
	      bal = "Right " + df.format(jsldrBalance.getValue()); 
	    else if(b==0) 
	      bal = "Center"; 
	    else 
	      bal = "Left " + df.format(-jsldrBalance.getValue()); 
	 
	    jlabInfo.setText("<html>Treble: " + 
	               df.format(jsldrTreble.getValue()) + 
	               "<br>Midrange: " + 
	               df.format(jsldrMidrange.getValue()) +  
	               "<br>Base: " + 
	               df.format(jsldrBass.getValue()) + 
	               "<br>Balance: " + bal + 
	               "<br>Volume: " + 
	               jsldrVolume.getValue()); 
	  } 
	 
	  // Initialize presets. 
	  void setupPresets() { 
	    presets = new Presets[3]; 
	    presets[0] = new Presets(0, 0, 0, 0, 0); 
	    presets[1] = new Presets(2, -4, 7, 0, 4); 
	    presets[2] = new Presets(3, 3, -2, 1, 7); 
	  } 
	 
	  // Store a preset. 
	  void storePreset(Presets info) { 
	    info.bass = jsldrBass.getValue();     
	    info.midrange = jsldrMidrange.getValue();     
	    info.treble = jsldrTreble.getValue();     
	    info.balance = jsldrBalance.getValue();     
	    info.volume = jsldrVolume.getValue();     
	  } 
	 
	  // Load a preset. 
	  void loadPreset(Presets info) { 
	    jsldrBass.setValue(info.bass);     
	    jsldrMidrange.setValue(info.midrange);     
	    jsldrTreble.setValue(info.treble);     
	    jsldrBalance.setValue(info.balance);     
	    jsldrVolume.setValue(info.volume);     
	  } 

}
