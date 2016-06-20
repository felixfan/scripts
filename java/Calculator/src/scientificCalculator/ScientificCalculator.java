package scientificCalculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ScientificCalculator {
	JTextField jtf;
	JButton jbtn0,jbtn1,jbtn2,jbtn3,jbtn4,jbtn5,jbtn6,jbtn7,jbtn8,jbtn9;
	JButton jbtnPlus,jbtnMinus,jbtnMult,jbtnDvid,jbtnClear,jbtnDot,jbtnLn,jbtnLog;
	JButton jbtnExp,jbtnPower,jbtnRecip,jbtnSqrt,jbtnSign,jbtnResult;
	JButton jbtnPi, jbtnE, jbtnDel;
	JButton jbtnACos,jbtnASin,jbtnATan,jbtnCos,jbtnSin,jbtnTan;
	
	int plusClick=0, minusClick=0, multipleClick=0, devideClick=0;
	int dotClick = 0, powerClick = 0;
	Double firstNum, secondNum;
	
	JFrame jfrm;
	
	ScientificCalculator(){
		jfrm = new JFrame("Scientific Calculator");
		GridBagLayout CalLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jfrm.setLayout(CalLayout);
		jfrm.setSize(380, 500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf = new JTextField();
		jtf.setText("0");
		jtf.setEditable(false);
		
		jbtn0 = new JButton("0");
		jbtn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn0ActionPerformed(e);
			}
		});
		
		jbtn1 = new JButton("1");
		jbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn1ActionPerformed(e);
			}
		});
		
		jbtn2 = new JButton("2");
		jbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn2ActionPerformed(e);
			}
		});
		
		jbtn3 = new JButton("3");
		jbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn3ActionPerformed(e);
			}
		});
		
		jbtn4 = new JButton("4");
		jbtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn4ActionPerformed(e);
			}
		});
		
		jbtn5 = new JButton("5");
		jbtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn5ActionPerformed(e);
			}
		});
		
		jbtn6 = new JButton("6");
		jbtn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn6ActionPerformed(e);
			}
		});
		
		jbtn7 = new JButton("7");
		jbtn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn7ActionPerformed(e);
			}
		});
		
		jbtn8 = new JButton("8");
		jbtn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn8ActionPerformed(e);
			}
		});
		
		jbtn9 = new JButton("9");
		jbtn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtn9ActionPerformed(e);
			}
		});
		
		jbtnPlus = new JButton("+");
		jbtnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnPlusActionPerformed(e);
			}
		});
		
		jbtnMinus = new JButton("-");
		jbtnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnMinusActionPerformed(e);
			}
		});
		
		JButton jbtnMult = new JButton("x");
		jbtnMult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnMultActionPerformed(e);
			}
		});
		
		JButton jbtnDvid = new JButton("/");
		jbtnDvid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnDvidActionPerformed(e);
			}
		});
		
		jbtnClear = new JButton("Clear");
		jbtnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnClearActionPerformed(e);
			}
		});
		
		jbtnDot = new JButton(".");
		jbtnDot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnDotActionPerformed(e);
			}
		});
		
		jbtnSign = new JButton("+/-");
		jbtnSign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnSignActionPerformed(e);
			}
		});
		
		jbtnResult = new JButton("=");
		jbtnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnResultActionPerformed(e);
			}
		});
		
		jbtnLn = new JButton("Ln");
		jbtnLn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnLnActionPerformed(e);
			}
		});
		
		jbtnLog = new JButton("Log10 ");
		jbtnLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnLogActionPerformed(e);
			}
		});
		
		jbtnExp = new JButton(" EXP ");
		jbtnExp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnExpActionPerformed(e);
			}
		});
		
		jbtnRecip = new JButton("1/x");
		jbtnRecip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnRecipActionPerformed(e);
			}
		});
		
		jbtnSqrt = new JButton("Sqrt");
		jbtnSqrt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnSqrtActionPerformed(e);
			}
		});
		
		jbtnPower = new JButton("Power");
		jbtnPower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnPowerActionPerformed(e);
			}
		});
		
		jbtnPi = new JButton("PI");
		jbtnPi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnPiActionPerformed(e);
			}
		});
		
		jbtnE = new JButton("E");
		jbtnE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnEActionPerformed(e);
			}
		});
		
		jbtnDel = new JButton("Delet");
		jbtnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnDelActionPerformed(e);
			}
		});
		
		jbtnACos = new JButton("acos ");
		jbtnACos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnACosActionPerformed(e);
			}
		});
		
		jbtnASin = new JButton("asin");
		jbtnASin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnASinActionPerformed(e);
			}
		});
		
		jbtnATan = new JButton("atan");
		jbtnATan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnATanActionPerformed(e);
			}
		});
		
		jbtnCos = new JButton("cos");
		jbtnCos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnCosActionPerformed(e);
			}
		});
		
		jbtnSin = new JButton("sin");
		jbtnSin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnSinActionPerformed(e);
			}
		});
		
		jbtnTan = new JButton("tan");
		jbtnTan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtnTanActionPerformed(e);
			}
		});
		
		// layout all
		gbc.weightx = 1.0; //default 0.0
		gbc.weighty = 1.0; //default 0.0
		
		gbc.insets = new Insets(4, 4, 4, 4); // Add some space
		gbc.fill = GridBagConstraints.BOTH;
		
		// layout Text Field
		gbc.gridwidth = 5; // jtf used 5 col
		
		gbc.gridx=0;
		gbc.gridy=0;
		CalLayout.setConstraints(jtf, gbc);
		
		// layout Buttons
		gbc.gridwidth = 1; // each button use 1 col
		
		// 1st row buttons
		gbc.gridx=0;
		gbc.gridy=1;
		CalLayout.setConstraints(jbtn1, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		CalLayout.setConstraints(jbtn2, gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		CalLayout.setConstraints(jbtn3, gbc);
		
		gbc.gridx=3;
		gbc.gridy=1;
		CalLayout.setConstraints(jbtn4, gbc);
		
		gbc.gridx=4;
		gbc.gridy=1;
		CalLayout.setConstraints(jbtnPlus, gbc);
		
		// 2nd row buttons
		gbc.gridx=0;
		gbc.gridy=2;
		CalLayout.setConstraints(jbtn5, gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		CalLayout.setConstraints(jbtn6, gbc);
		
		gbc.gridx=2;
		gbc.gridy=2;
		CalLayout.setConstraints(jbtn7, gbc);
		
		gbc.gridx=3;
		gbc.gridy=2;
		CalLayout.setConstraints(jbtn8, gbc);
		
		gbc.gridx=4;
		gbc.gridy=2;
		CalLayout.setConstraints(jbtnMinus, gbc);
		
		// 3rd row buttons
		gbc.gridx=0;
		gbc.gridy=3;
		CalLayout.setConstraints(jbtn9, gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		CalLayout.setConstraints(jbtn0, gbc);
		
		gbc.gridx=2;
		gbc.gridy=3;
		CalLayout.setConstraints(jbtnPi, gbc);
		
		gbc.gridx=3;
		gbc.gridy=3;
		CalLayout.setConstraints(jbtnE, gbc);
		
		gbc.gridx=4;
		gbc.gridy=3;
		CalLayout.setConstraints(jbtnMult, gbc);
		
		// 4th row buttons
		gbc.gridx=0;
		gbc.gridy=4;
		CalLayout.setConstraints(jbtnRecip, gbc);
		
		gbc.gridx=1;
		gbc.gridy=4;
		CalLayout.setConstraints(jbtnSqrt, gbc);
		
		gbc.gridx=2;
		gbc.gridy=4;
		CalLayout.setConstraints(jbtnSign, gbc);
		
		gbc.gridx=3;
		gbc.gridy=4;
		CalLayout.setConstraints(jbtnDot, gbc);
		
		gbc.gridx=4;
		gbc.gridy=4;
		CalLayout.setConstraints(jbtnDvid, gbc);
		
		// 5th row buttons
		gbc.gridx=0;
		gbc.gridy=5;
		CalLayout.setConstraints(jbtnLn, gbc);
		
		gbc.gridx=1;
		gbc.gridy=5;
		CalLayout.setConstraints(jbtnLog, gbc);
		
		gbc.gridx=2;
		gbc.gridy=5;
		CalLayout.setConstraints(jbtnExp, gbc);
		
		gbc.gridx=3;
		gbc.gridy=5;
		CalLayout.setConstraints(jbtnPower, gbc);
		
		gbc.gridx=4;
		gbc.gridy=5;
		CalLayout.setConstraints(jbtnDel, gbc);
		
		// 6th row buttons
		gbc.gridx=0;
		gbc.gridy=6;
		CalLayout.setConstraints(jbtnACos, gbc);
		
		gbc.gridx=1;
		gbc.gridy=6;
		CalLayout.setConstraints(jbtnASin, gbc);
		
		gbc.gridx=2;
		gbc.gridy=6;
		CalLayout.setConstraints(jbtnATan, gbc);
		
		// layout clear button (2 cols)
		gbc.gridwidth = 2; 
		
		gbc.gridx=3;
		gbc.gridy=6;
		CalLayout.setConstraints(jbtnClear, gbc);
		
		// layout button (1 col)
		gbc.gridwidth = 1; 
		
		// 7th row buttons
		gbc.gridx=0;
		gbc.gridy=7;
		CalLayout.setConstraints(jbtnCos, gbc);
		
		gbc.gridx=1;
		gbc.gridy=7;
		CalLayout.setConstraints(jbtnSin, gbc);
		
		gbc.gridx=2;
		gbc.gridy=7;
		CalLayout.setConstraints(jbtnTan, gbc);
		
		// layout clear button (2 cols)
		gbc.gridwidth = 2; 
		
		gbc.gridx=3;
		gbc.gridy=7;
		CalLayout.setConstraints(jbtnResult, gbc);
		
		// add to jfrm
		jfrm.add(jtf);
		jfrm.add(jbtn1);
		jfrm.add(jbtn2);
		jfrm.add(jbtn3);
		jfrm.add(jbtn4);
		jfrm.add(jbtn5);
		jfrm.add(jbtn6);
		jfrm.add(jbtn7);
		jfrm.add(jbtn8);
		jfrm.add(jbtn9);
		jfrm.add(jbtn0);
		jfrm.add(jbtnPlus);
		jfrm.add(jbtnMinus);
		jfrm.add(jbtnClear);
		jfrm.add(jbtnDot);
		jfrm.add(jbtnDvid);
		jfrm.add(jbtnExp);
		jfrm.add(jbtnLn);
		jfrm.add(jbtnLog);
		jfrm.add(jbtnMult);
		jfrm.add(jbtnPower);
		jfrm.add(jbtnRecip);
		jfrm.add(jbtnResult);
		jfrm.add(jbtnSign);
		jfrm.add(jbtnSqrt);
		jfrm.add(jbtnPi);
		jfrm.add(jbtnE);
		jfrm.add(jbtnDel);
		jfrm.add(jbtnACos);
		jfrm.add(jbtnASin);
		jfrm.add(jbtnATan);
		jfrm.add(jbtnCos);
		jfrm.add(jbtnSin);
		jfrm.add(jbtnTan);
		
		// Help Menu Bar
		JMenuBar jmb = new JMenuBar();
		JMenu jmh = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem("About");
		jmiAbout.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(jfrm, 
					   "Name:          Scientific Calculator\n"
						+ "Version:       1.0\n"
						+ "Author:         Felix Yanhui Fan\n"
						+ "EMail:           nolanfyh@gmail.com\n"
						+ "Website:     https://github.com/felixfan/Calculator\n");
						
				}
			});
		JMenuItem jmiLisence = new JMenuItem("Lisence");
		jmiLisence.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(jfrm,
								"This program is licensed under the terms of \n"
								+ "the GNU General Public License version 3 \n"
								+ "Available online under: \n"
								+ "http://www.gnu.org/licenses/gpl-3.0.html\n");
						
			}
		});
				
		jmh.add(jmiAbout);
		jmh.add(jmiLisence);
				
		jmb.add(Box.createHorizontalGlue()); // Aligning JMenu on the right corner of JMenuBar
		jmb.add(jmh);
				
		jfrm.setJMenuBar(jmb);	
		
		jfrm.setResizable(false);
		jfrm.setVisible(true);
	}
	
	//////////// ActionListener
	private void jbtn0ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn0.getText());
		}
	}
	
	private void jbtn1ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn1.getText());
		}else{
			jtf.setText(jbtn1.getText());
		}
	}
	
	private void jbtn2ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn2.getText());
		}else{
			jtf.setText(jbtn2.getText());
		}
	}
	
	private void jbtn3ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn3.getText());
		}else{
			jtf.setText(jbtn3.getText());
		}
	}
	
	private void jbtn4ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn4.getText());
		}else{
			jtf.setText(jbtn4.getText());
		}
	}
	
	private void jbtn5ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn5.getText());
		}else{
			jtf.setText(jbtn5.getText());
		}
	}
	
	private void jbtn6ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn6.getText());
		}else{
			jtf.setText(jbtn6.getText());
		}
	}
	
	private void jbtn7ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn7.getText());
		}else{
			jtf.setText(jbtn7.getText());
		}
	}
	
	private void jbtn8ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn8.getText());
		}else{
			jtf.setText(jbtn8.getText());
		}
	}
	
	private void jbtn9ActionPerformed(ActionEvent e){
		if(!String.valueOf(jtf.getText()).matches("0")){
			jtf.setText(jtf.getText()+jbtn9.getText());
		}else{
			jtf.setText(jbtn9.getText());
		}
	}
	
	private void jbtnClearActionPerformed(ActionEvent e){
		jtf.setText(null);
		dotClick = 0;
		plusClick=0;
		minusClick=0;
		multipleClick=0;
		devideClick=0;
		powerClick = 0;
		firstNum = 0.0;
		secondNum = 0.0;
	}
	
	private void jbtnDotActionPerformed(ActionEvent e){
		if(dotClick ==  0){
			if(!jtf.getText().equals("")){
				jtf.setText(jtf.getText()+jbtnDot.getText());
			}else{
				jtf.setText("0"+jbtnDot.getText());
			}
			dotClick =1;
		}
	}
	
	private void jbtnPlusActionPerformed(ActionEvent e){
	    firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
	    jtf.setText(null);
	    plusClick=1;
	    dotClick=0;
	}
	
	private void jbtnMinusActionPerformed(ActionEvent e){
		firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
	    jtf.setText(null);
	    minusClick=1;
	    dotClick=0;
	}
	
	private void jbtnMultActionPerformed(ActionEvent e){
		firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
	    jtf.setText(null);
	    multipleClick=1;
	    dotClick=0;
	}
	
	private void jbtnDvidActionPerformed(ActionEvent e){
		firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
	    jtf.setText(null);
	    devideClick=1;
	    dotClick=0;
	}
	
	private void jbtnLnActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.log(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnLogActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.log10(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnExpActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.exp(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnPowerActionPerformed(ActionEvent e){
		firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
	    jtf.setText(null);
	    powerClick=1;
	    dotClick=0;
	}
	
	private void jbtnRecipActionPerformed(ActionEvent e){
		firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        jtf.setText(String.valueOf(1/firstNum));
	}
	
	private void jbtnSqrtActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.sqrt(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnSignActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = -1 * firstNum;
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnPiActionPerformed(ActionEvent e){
        jtf.setText(String.valueOf(Math.PI));
	}
	
	private void jbtnEActionPerformed(ActionEvent e){
        jtf.setText(String.valueOf(Math.E));
	}
	
	private void jbtnDelActionPerformed(ActionEvent e){
        jtf.setText(String.valueOf(jtf.getText()).substring(0, String.valueOf(jtf.getText()).length()-1));
	}
	
	private void jbtnTanActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.tan(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnACosActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.acos(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnASinActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.asin(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnATanActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.atan(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnCosActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.cos(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnSinActionPerformed(ActionEvent e){
        firstNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        double answer = Math.sin(firstNum);
        jtf.setText(String.valueOf(answer));
	}
	
	private void jbtnResultActionPerformed(ActionEvent e){
        secondNum=(Double.parseDouble(String.valueOf(jtf.getText())));
        if(plusClick>0){
            jtf.setText(String.valueOf(firstNum + secondNum));
            firstNum=0.0;
            secondNum=0.0;
            plusClick=0;
        }
        
        if(minusClick>0){
            jtf.setText(String.valueOf(firstNum - secondNum));
            firstNum=0.0;
            secondNum=0.0;
            minusClick=0;
        }
        
        if(multipleClick>0){
            jtf.setText(String.valueOf(firstNum * secondNum));
            firstNum=0.0;
            secondNum=0.0;
            multipleClick=0;
        }
        
        if(devideClick>0){
            //totals = firstNum / secondNum;
           // NumberFormat f = NumberFormat.getInstance();
            //f.setMaximumFractionDigits(8); // 4 digits
           // String s = f.format(totals);
            //jtf.setText(s);
        	jtf.setText(String.valueOf(firstNum / secondNum));
            firstNum=0.0;
            secondNum=0.0;
            devideClick=0;
        }
         if(powerClick>0){
        	 /*
            totals = Math.pow(firstNum, secondNum);
            NumberFormat f = NumberFormat.getInstance();
            jtf.setText(String.valueOf(totals));
            */
        	jtf.setText(String.valueOf(Math.pow(firstNum, secondNum)));
            firstNum=0.0;
            secondNum=0.0;
            powerClick=0;
        } 
	}
	
}
