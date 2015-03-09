import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.stat.inference.ChiSquareTest;

public class ChiSquareCalculator {
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10;
	JTextField jtf11,jtf12,jtf13,jtf14,jtf15,jtf16,jtf17;
	
	ChiSquareCalculator(){
		final JFrame jfrm = new JFrame("Chi Square Calculator");
		jfrm.setSize(400, 550);	
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setResizable(false);
		
		// panel 1
		JPanel pn1 = new JPanel();	
		pn1.setOpaque(true); 
		pn1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "2 x 2"));
		
		JLabel jlab1 = new JLabel("class 1");
		JLabel jlab2 = new JLabel("class 2");
		JLabel jlab3 = new JLabel("case");
		JLabel jlab4 = new JLabel("control");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		
		// pn1 layout all
		GridBagLayout CalLayout1 = new GridBagLayout();
		GridBagConstraints gbc1 = new GridBagConstraints();
		pn1.setLayout(CalLayout1);		
		gbc1.weightx = 1.0; //default 0.0
		gbc1.weighty = 1.0; //default 0.0		
		gbc1.insets = new Insets(4, 4, 4, 4); // Add some space
		gbc1.fill = GridBagConstraints.BOTH;
		
		gbc1.gridwidth = 1;
		
		gbc1.gridx=1;
		gbc1.gridy=0;
		CalLayout1.setConstraints(jlab1, gbc1);
		
		gbc1.gridx=2;
		gbc1.gridy=0;
		CalLayout1.setConstraints(jlab2, gbc1);
		
		gbc1.gridx=0;
		gbc1.gridy=1;
		CalLayout1.setConstraints(jlab3, gbc1);
		
		gbc1.gridx=1;
		gbc1.gridy=1;
		CalLayout1.setConstraints(jtf1, gbc1);
		
		gbc1.gridx=2;
		gbc1.gridy=1;
		CalLayout1.setConstraints(jtf2, gbc1);
		
		gbc1.gridx=0;
		gbc1.gridy=2;
		CalLayout1.setConstraints(jlab4, gbc1);
		
		gbc1.gridx=1;
		gbc1.gridy=2;
		CalLayout1.setConstraints(jtf3, gbc1);
		
		gbc1.gridx=2;
		gbc1.gridy=2;
		CalLayout1.setConstraints(jtf4, gbc1);
			
		pn1.add(jlab1);
		pn1.add(jlab2);
		pn1.add(jlab3);
		pn1.add(jlab4);
		pn1.add(jtf1);
		pn1.add(jtf2);
		pn1.add(jtf3);
		pn1.add(jtf4);
			
		// panel 2
		JPanel pn2 = new JPanel();		
		pn2.setOpaque(true); 
		pn2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "2 x 3"));
		
		JLabel jlab5 = new JLabel("class 1");
		JLabel jlab6 = new JLabel("class 2");
		JLabel jlab7 = new JLabel("class 3");
		JLabel jlab8 = new JLabel("case");
		JLabel jlab9 = new JLabel("control");
				
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		jtf8 = new JTextField();
		jtf9 = new JTextField();
		jtf10 = new JTextField();
		
		// pn2 layout all
		GridBagLayout CalLayout2 = new GridBagLayout();
		GridBagConstraints gbc2 = new GridBagConstraints();
		pn2.setLayout(CalLayout2);		
		gbc2.weightx = 1.0; //default 0.0
		gbc2.weighty = 1.0; //default 0.0		
		gbc2.insets = new Insets(4, 4, 4, 4); // Add some space
		gbc2.fill = GridBagConstraints.BOTH;
		
		gbc2.gridwidth = 1;
		
		gbc2.gridx=1;
		gbc2.gridy=0;
		CalLayout2.setConstraints(jlab5, gbc2);
		
		gbc2.gridx=2;
		gbc2.gridy=0;
		CalLayout2.setConstraints(jlab6, gbc2);
		
		gbc2.gridx=3;
		gbc2.gridy=0;
		CalLayout2.setConstraints(jlab7, gbc2);
		
		gbc2.gridx=0;
		gbc2.gridy=1;
		CalLayout2.setConstraints(jlab8, gbc2);
		
		gbc2.gridx=1;
		gbc2.gridy=1;
		CalLayout2.setConstraints(jtf5, gbc2);
		
		gbc2.gridx=2;
		gbc2.gridy=1;
		CalLayout2.setConstraints(jtf6, gbc2);
		
		gbc2.gridx=3;
		gbc2.gridy=1;
		CalLayout2.setConstraints(jtf7, gbc2);
		
		gbc2.gridx=0;
		gbc2.gridy=2;
		CalLayout2.setConstraints(jlab9, gbc2);
		
		gbc2.gridx=1;
		gbc2.gridy=2;
		CalLayout2.setConstraints(jtf8, gbc2);
		
		gbc2.gridx=2;
		gbc2.gridy=2;
		CalLayout2.setConstraints(jtf9, gbc2);
		
		gbc2.gridx=3;
		gbc2.gridy=2;
		CalLayout2.setConstraints(jtf10, gbc2);
			
		pn2.add(jlab5);
		pn2.add(jlab6);
		pn2.add(jlab7);
		pn2.add(jlab8);
		pn2.add(jlab9);
		pn2.add(jtf5);
		pn2.add(jtf6);
		pn2.add(jtf7);
		pn2.add(jtf8);
		pn2.add(jtf9);
		pn2.add(jtf10);				
		
		// panel 3		
		JPanel pn3 = new JPanel();	
		pn3.setOpaque(true); 
		pn3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "statistic"));
		
		JLabel jlab10 = new JLabel("chi-square");
		JLabel jlab11 = new JLabel("degree of freedom");
				
		jtf11 = new JTextField();
		jtf12 = new JTextField();
		
		GridBagLayout CalLayout3 = new GridBagLayout();
		GridBagConstraints gbc3 = new GridBagConstraints();
		pn3.setLayout(CalLayout3);		
		gbc3.weightx = 1.0; //default 0.0
		gbc3.weighty = 1.0; //default 0.0		
		gbc3.insets = new Insets(4, 4, 4, 4); // Add some space
		gbc3.fill = GridBagConstraints.BOTH;
		
		gbc3.gridwidth = 1;
		
		gbc3.gridx=0;
		gbc3.gridy=0;
		CalLayout3.setConstraints(jlab10, gbc3);
		
		gbc3.gridwidth = 3;
		
		gbc3.gridx=1;
		gbc3.gridy=0;
		CalLayout3.setConstraints(jtf11, gbc3);
		
		gbc3.gridwidth = 2;
		
		gbc3.gridx=0;
		gbc3.gridy=1;
		CalLayout3.setConstraints(jlab11, gbc3);
		
		gbc3.gridx=2;
		gbc3.gridy=1;
		CalLayout3.setConstraints(jtf12, gbc3);
		
		pn3.add(jlab10);
		pn3.add(jlab11);
		pn3.add(jtf11);
		pn3.add(jtf12);
		
		
		JPanel pn4 = new JPanel();		
		pn4.setOpaque(true); 
		pn4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "result"));
		
		JLabel jlab12 = new JLabel("p-value");
		final JLabel jlab13 = new JLabel("odds ratio");
		final JLabel jlab14 = new JLabel("standard error");
		final JLabel jlab15 = new JLabel("confidence interval 95%");
	
		jtf13 = new JTextField();
		jtf14 = new JTextField();				
		jtf15 = new JTextField();
		jtf16 = new JTextField();
		jtf17 = new JTextField();
		
		jlab13.setEnabled(false);
		jlab14.setEnabled(false);
		jlab15.setEnabled(false);
		jtf14.setEnabled(false);
		jtf15.setEnabled(false);
		jtf16.setEnabled(false);
		jtf17.setEnabled(false);
			
		JButton jbtn1 = new JButton("Run 2x2");
		jbtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long number1, number2, number3, number4;
				try {
		        number1 = Long.parseLong(jtf1.getText());
		        number2 = Long.parseLong(jtf2.getText());
		        number3 = Long.parseLong(jtf3.getText());
		        number4 = Long.parseLong(jtf4.getText());
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(jfrm, "Error: Bad input, only integer is acceptable!");
		            return;
		        }
				
				long[][] obs = new long[2][2];

		        obs[0][0] = number1;
		        obs[0][1] = number2;
		        obs[1][0] = number3;
		        obs[1][1] = number4;

		        ChiSquareTest mychiSquare = new ChiSquareTest();

		        double stats =  mychiSquare.chiSquare(obs);
		        jtf11.setText(String.valueOf(stats));
		        jtf12.setText(String.valueOf(1));

		        double pvalue = mychiSquare.chiSquareTest(obs);
		        jtf13.setText(String.valueOf(pvalue));
		        
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				jtf10.setText("");				
				
				jlab13.setEnabled(true);
				jlab14.setEnabled(true);
				jlab15.setEnabled(true);
				jtf14.setEnabled(true);
				jtf15.setEnabled(true);
				jtf16.setEnabled(true);
				jtf17.setEnabled(true);
			
		        double or = (double)(number2 * number3) / (number1 * number4);
		        double se = Math.sqrt((double)1/number1 + (double)1/number2 + (double)1/ number3 + (double)1/number4);
		        double logOR = Math.log(or);
		        double logU95 = logOR + 1.96 * se;
		        double logL95 = logOR - 1.96 * se;
		        double U95 = Math.exp(logU95);
		        double L95 = Math.exp(logL95);
		        
		        final java.text.DecimalFormat mydf =new java.text.DecimalFormat("0.000000");
		        
		        jtf14.setText(String.valueOf(or));
		        jtf15.setText(String.valueOf(se));
		        jtf16.setText(String.valueOf(mydf.format(L95)));
		        jtf17.setText(String.valueOf(mydf.format(U95)));
		        								
			}
		});
		
		JButton jbtn2 = new JButton("Run 2x3");
		jbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long number1, number2, number3, number4,number5,number6;
				try {
		        number1 = Long.parseLong(jtf5.getText());
		        number2 = Long.parseLong(jtf6.getText());
		        number3 = Long.parseLong(jtf7.getText());
		        number4 = Long.parseLong(jtf8.getText());
		        number5 = Long.parseLong(jtf9.getText());
		        number6 = Long.parseLong(jtf10.getText());
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(jfrm, "Error: Bad input, only integer is acceptable!");
		            return;
		        }
				
				long[][] obs = new long[2][3];

		        obs[0][0] = number1;
		        obs[0][1] = number2;
		        obs[0][2] = number3;
		        obs[1][0] = number4;
		        obs[1][1] = number5;
		        obs[1][2] = number6;

		        ChiSquareTest mychiSquare = new ChiSquareTest();

		        double stats =  mychiSquare.chiSquare(obs);
		        jtf11.setText(String.valueOf(stats));
		        jtf12.setText(String.valueOf(2));

		        double pvalue = mychiSquare.chiSquareTest(obs);
		        jtf13.setText(String.valueOf(pvalue));
		        		       
		        jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");							
				jtf14.setText("");
				jtf15.setText("");
				jtf16.setText("");
				jtf17.setText("");				
				
				jlab13.setEnabled(false);
				jlab14.setEnabled(false);
				jlab15.setEnabled(false);
				jtf14.setEnabled(false);
				jtf15.setEnabled(false);
				jtf16.setEnabled(false);
				jtf17.setEnabled(false);
				
			}
		});
		
		JButton jbtn3 = new JButton("Run Statistic");
		jbtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double stat, df;
				try {
		        stat = Double.parseDouble(jtf11.getText());
		        df = Double.parseDouble(jtf12.getText());		       
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(jfrm, "Error: Bad input, only number is acceptable!");
		            return;
		        }				
				ChiSquaredDistribution distribution = new ChiSquaredDistribution(df);
				double pvalue = 1 - distribution.cumulativeProbability(stat);
				jtf13.setText(String.valueOf(pvalue));	
							
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				jtf10.setText("");
				jtf14.setText("");
				jtf15.setText("");
				jtf16.setText("");
				jtf17.setText("");		
				
				jlab13.setEnabled(false);
				jlab14.setEnabled(false);
				jlab15.setEnabled(false);
				jtf14.setEnabled(false);
				jtf15.setEnabled(false);
				jtf16.setEnabled(false);
				jtf17.setEnabled(false);
			}
		});

		JButton jbtn4 = new JButton("clear");
		jbtn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				jtf10.setText("");
				jtf11.setText("");
				jtf12.setText("");
				jtf13.setText("");
				jtf14.setText("");
				jtf15.setText("");
				jtf16.setText("");
				jtf17.setText("");	
				
				jlab13.setEnabled(false);
				jlab14.setEnabled(false);
				jlab15.setEnabled(false);
				jtf14.setEnabled(false);
				jtf15.setEnabled(false);
				jtf16.setEnabled(false);
				jtf17.setEnabled(false);
			}
		});
		
		GridBagLayout CalLayout4 = new GridBagLayout();
		GridBagConstraints gbc4 = new GridBagConstraints();
		pn4.setLayout(CalLayout4);		
		gbc4.weightx = 1.0; //default 0.0
		gbc4.weighty = 1.0; //default 0.0		
		gbc4.insets = new Insets(4, 4, 4, 4); // Add some space
		gbc4.fill = GridBagConstraints.BOTH;
		
		gbc4.gridwidth = 1;
		
		gbc4.gridx=0;
		gbc4.gridy=0;
		CalLayout4.setConstraints(jbtn1, gbc4);
		
		gbc4.gridx=1;
		gbc4.gridy=0;
		CalLayout4.setConstraints(jbtn2, gbc4);
		
		gbc4.gridx=2;
		gbc4.gridy=0;
		CalLayout4.setConstraints(jbtn3, gbc4);
		
		gbc4.gridx=3;
		gbc4.gridy=0;
		CalLayout4.setConstraints(jbtn4, gbc4);
		
		gbc4.gridx=0;
		gbc4.gridy=1;
		CalLayout4.setConstraints(jlab12, gbc4);
		
		gbc4.gridwidth = 3;
		
		gbc4.gridx=1;
		gbc4.gridy=1;
		CalLayout4.setConstraints(jtf13, gbc4);
		
		gbc4.gridwidth = 2;
		
		gbc4.gridx=0;
		gbc4.gridy=2;
		CalLayout4.setConstraints(jlab13, gbc4);
		
		gbc4.gridx=2;
		gbc4.gridy=2;
		CalLayout4.setConstraints(jtf14, gbc4);
		
		gbc4.gridx=0;
		gbc4.gridy=3;
		CalLayout4.setConstraints(jlab14, gbc4);
		
		gbc4.gridx=2;
		gbc4.gridy=3;
		CalLayout4.setConstraints(jtf15, gbc4);
		
		gbc4.gridx=0;
		gbc4.gridy=4;
		CalLayout4.setConstraints(jlab15, gbc4);
		
		gbc4.gridwidth = 1;
		
		gbc4.gridx=2;
		gbc4.gridy=4;
		CalLayout4.setConstraints(jtf16, gbc4);
		
		gbc4.gridx=3;
		gbc4.gridy=4;
		CalLayout4.setConstraints(jtf17, gbc4);
		
		pn4.add(jlab12);
		pn4.add(jlab13);
		pn4.add(jlab14);
		pn4.add(jlab15);		
		pn4.add(jtf13);
		pn4.add(jtf14);
		pn4.add(jtf15);
		pn4.add(jtf16);
		pn4.add(jtf17);		
		pn4.add(jbtn1);
		pn4.add(jbtn2);		
		pn4.add(jbtn3);
		pn4.add(jbtn4);
		
		// jfrm layout all
		GridBagLayout CalLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jfrm.setLayout(CalLayout);
		
		gbc.weightx = 1.0; //default 0.0
		gbc.weighty = 1.0; //default 0.0
		
		gbc.insets = new Insets(4, 4, 4, 4); // Add some space
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridwidth = 4;
		
		gbc.gridx=0;
		gbc.gridy=0;
		CalLayout.setConstraints(pn1, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		CalLayout.setConstraints(pn2, gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		CalLayout.setConstraints(pn3, gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		CalLayout.setConstraints(pn4, gbc);
		
		jfrm.add(pn1);
		jfrm.add(pn2);
		jfrm.add(pn3);
		jfrm.add(pn4);
		
		// Help Menu Bar
		JMenuBar jmb = new JMenuBar();
		JMenu jmh = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem("About");
		jmiAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(jfrm, 
						"Name:          Chi Square Calculator\n"
						+ "Version:       1.0\n"
						+ "Author:         Felix Yanhui Fan\n"
						+ "EMail:           nolanfyh@gmail.com\n"
						+ "Website:     http://felixfan.github.io/ChiSquareCalculator\n");
				
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
		
		jfrm.setVisible(true);
	}

}
