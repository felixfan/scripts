/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datecal;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;
/**
 *
 * @author Felix Yanhui Fan  felixfanyh@gmail.com
 */
public class dateAdd {
    public dateAdd(){
        Calendar calendar = Calendar.getInstance(); 
        int year = calendar.get(Calendar.YEAR); 
        int month = calendar.get(Calendar.MONTH);
        month += 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        
        JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9, jtf10;
        final JFrame jfrm = new JFrame("KiMA Date Calculator");
        jfrm.setSize(550, 400);	
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setResizable(false);
        
        // panel 1
        JPanel pn1 = new JPanel();	
        pn1.setOpaque(true); 
        pn1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Start Time"));
        
        JLabel jlab1 = new JLabel("yyyy-MM-dd");
        JLabel jlab2 = new JLabel("hh:mm:ss");
        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();
        jtf4 = new JTextField();
        jtf5 = new JTextField();
        jtf6 = new JTextField();
        
        jtf1.setText(String.valueOf(year));
        jtf2.setText(String.valueOf(month));
        jtf3.setText(String.valueOf(day));
        jtf4.setText(String.valueOf(hour));
        jtf5.setText(String.valueOf(minute));
        jtf6.setText(String.valueOf(second));
        
        // pn1 layout all
        GridBagLayout CalLayout1 = new GridBagLayout();
        GridBagConstraints gbc1 = new GridBagConstraints();
        pn1.setLayout(CalLayout1);		
        gbc1.weightx = 1.0; //default 0.0
        gbc1.weighty = 1.0; //default 0.0		
        gbc1.insets = new Insets(4, 4, 4, 4); // Add some space
        gbc1.fill = GridBagConstraints.BOTH;

        gbc1.gridwidth = 1;

        gbc1.gridx=0;
        gbc1.gridy=0;
        CalLayout1.setConstraints(jlab1, gbc1);

        gbc1.gridx=0;
        gbc1.gridy=1;
        CalLayout1.setConstraints(jlab2, gbc1);
		
        gbc1.gridx=1;
        gbc1.gridy=0;
        CalLayout1.setConstraints(jtf1, gbc1);

        gbc1.gridx=2;
        gbc1.gridy=0;
        CalLayout1.setConstraints(jtf2, gbc1);

        gbc1.gridx=3;
        gbc1.gridy=0;
        CalLayout1.setConstraints(jtf3, gbc1);

        gbc1.gridx=1;
        gbc1.gridy=1;
        CalLayout1.setConstraints(jtf4, gbc1);
        
        gbc1.gridx=2;
        gbc1.gridy=1;
        CalLayout1.setConstraints(jtf5, gbc1);
        
        gbc1.gridx=3;
        gbc1.gridy=1;
        CalLayout1.setConstraints(jtf6, gbc1);
			
        pn1.add(jlab1);
        pn1.add(jlab2);
        pn1.add(jtf1);
        pn1.add(jtf2);
        pn1.add(jtf3);
        pn1.add(jtf4);
        pn1.add(jtf5);
        pn1.add(jtf6);
        
        // panel 4
        JPanel pn4 = new JPanel();		
        pn4.setOpaque(true); 
        pn4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Time to be added"));
        
        JLabel jlab4 = new JLabel("year-month-day");
        jtf8 = new JTextField();
        jtf9 = new JTextField();
        jtf10 = new JTextField();
        jtf8.setText("0");
        jtf9.setText("0");
        jtf10.setText("0");
        
        // pn4 layout
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
        CalLayout4.setConstraints(jlab4, gbc4);
        
        gbc4.gridx=1;
        gbc4.gridy=0;
        CalLayout4.setConstraints(jtf8, gbc4);
        
        gbc4.gridx=2;
        gbc4.gridy=0;
        CalLayout4.setConstraints(jtf9, gbc4);
        
        gbc4.gridx=3;
        gbc4.gridy=0;
        CalLayout4.setConstraints(jtf10, gbc4);
        
        pn4.add(jlab4);
        pn4.add(jtf8);
        pn4.add(jtf9);
        pn4.add(jtf10);
        
        // panel 2
        JPanel pn2 = new JPanel();	
        pn2.setOpaque(true); 
        pn2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "End Time"));
        
        jtf7 = new JTextField();
        
        // pn2 layout all
        GridBagLayout CalLayout2 = new GridBagLayout();
        GridBagConstraints gbc2 = new GridBagConstraints();
        pn2.setLayout(CalLayout2);		
        gbc2.weightx = 1.0; //default 0.0
        gbc2.weighty = 1.0; //default 0.0		
        gbc2.insets = new Insets(4, 4, 4, 4); // Add some space
        gbc2.fill = GridBagConstraints.BOTH;

        gbc2.gridwidth = 4;

        gbc2.gridx=0;
        gbc2.gridy=0;
        CalLayout2.setConstraints(jtf7, gbc2);
        
        pn2.add(jtf7);
        
        // panel 3
        JPanel pn3 = new JPanel();	
        pn3.setOpaque(true); 
        pn3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));

        JButton jbtn1 = new JButton("Run");
        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number1, number2, number3, number4,number5, number6, years, months, days;
                try {
                    number1 = Integer.parseInt(jtf1.getText());
                    number2 = Integer.parseInt(jtf2.getText());
                    number3 = Integer.parseInt(jtf3.getText());
                    number4 = Integer.parseInt(jtf4.getText());
                    number5 = Integer.parseInt(jtf5.getText());
                    number6 = Integer.parseInt(jtf6.getText());
                    days = Integer.parseInt(jtf10.getText());
                    months = Integer.parseInt(jtf9.getText());
                    years = Integer.parseInt(jtf8.getText());
                } catch (Exception ne) {
                    JOptionPane.showMessageDialog(jfrm, "Error: Bad input, only integer is acceptable!");
                    return;
                }
                
                number2 -= 1;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd EE HH:mm:ss");
                Calendar c = new GregorianCalendar(number1, number2, number3, number4,number5, number6);
                c.add(Calendar.YEAR, years);
                c.add(Calendar.MONTH, months);
                c.add(Calendar.DAY_OF_MONTH, days);
                
                jtf7.setText(String.valueOf(df.format(c.getTime())));
            }
        });
        
        JButton jbtn2 = new JButton("clear");
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = Calendar.getInstance(); 
                int year = calendar.get(Calendar.YEAR); 
                int month = calendar.get(Calendar.MONTH);
                month += 1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);
                /*
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf4.setText("");
                jtf5.setText("");
                jtf6.setText("");
                */
                jtf1.setText(String.valueOf(year));
                jtf2.setText(String.valueOf(month));
                jtf3.setText(String.valueOf(day));
                jtf4.setText(String.valueOf(hour));
                jtf5.setText(String.valueOf(minute));
                jtf6.setText(String.valueOf(second));
                
                jtf7.setText("");
                /*
                jtf8.setText("");
                jtf9.setText("");                
                jtf10.setText("");
                */
                jtf8.setText("0");
                jtf9.setText("0");                
                jtf10.setText("0");
            }
        });
        
        // pn3 layout
        GridBagLayout CalLayout3 = new GridBagLayout();
        GridBagConstraints gbc3 = new GridBagConstraints();
        pn3.setLayout(CalLayout3);		
        gbc3.weightx = 1.0; //default 0.0
        gbc3.weighty = 1.0; //default 0.0		
        gbc3.insets = new Insets(4, 4, 4, 4); // Add some space
        gbc3.fill = GridBagConstraints.BOTH;
		
        gbc3.gridwidth = 2;

        gbc3.gridx=0;
        gbc3.gridy=0;
        CalLayout3.setConstraints(jbtn1, gbc3);
        
        gbc3.gridx=2;
        gbc3.gridy=0;
        CalLayout3.setConstraints(jbtn2, gbc3);
        
        pn3.add(jbtn1);
        pn3.add(jbtn2);
        
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
        CalLayout.setConstraints(pn4, gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        CalLayout.setConstraints(pn2, gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        CalLayout.setConstraints(pn3, gbc);

        jfrm.add(pn1);
        jfrm.add(pn4);
        jfrm.add(pn2);
        jfrm.add(pn3);
        
        // Help Menu Bar
        JMenuBar jmb = new JMenuBar();
        JMenu jmh = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmiAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(jfrm, 
                    "Name:          KiMA Date Calculator\n"
                    + "Version:       1.0\n"
                    + "Author:         Felix Yanhui Fan\n"
                    + "EMail:          felixfanyh@gmail.com\n"
                    + "Website:     http://felixfan.github.io/DateCalculator\n");
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
    
    public Calendar currentDateAddYear(int n){
        Calendar c = Calendar.getInstance(); 
        c.add(Calendar.YEAR, n);
        return c;
    }
    public Calendar currentDateAddMonth(int n){
        Calendar c = Calendar.getInstance(); 
        c.add(Calendar.MONTH, n);
        return c;
    }
    public Calendar currentDateAddDay(int n){
        Calendar c = Calendar.getInstance(); 
        c.add(Calendar.DAY_OF_MONTH, n);
        return c;
    }
    
    public Calendar dateAddDay(int n, int year, int month, int day, int hour, int minute, int second){
        month -= 1;
        Calendar c = new GregorianCalendar(year, month, day, hour, minute, second);
        c.add(Calendar.DAY_OF_MONTH, n);
        return c;
    }
    
}
