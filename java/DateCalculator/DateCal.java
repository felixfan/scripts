/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datecal;

import javax.swing.SwingUtilities;

/**
 *
 * @author alicefelix
 */
public class DateCal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new dateAdd();
            }
        });

        
        /*
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd EE hh:mm:ss");
        dateAdd da = new dateAdd();
        Calendar c = da.currentDateAddDay(30);
        System.out.println(df.format(c.getTime()));
        c = da.currentDateAddMonth(10);
        System.out.println(df.format(c.getTime()));
        c = da.currentDateAddYear(10);
        System.out.println(df.format(c.getTime()));
        c = da.dateAddDay(10, 2016, 1, 15, 1, 12, 30);
        System.out.println(df.format(c.getTime()));
                */
    }
    
}
