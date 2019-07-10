
package busbooking;

import javax.swing.JFrame;

public class busbooking {
    
    public static void main(String[] args) {
        GUI f=new GUI();
        f.setTitle("BUS BOOKING SYSTEM");
        f.setVisible(true);
        f.setBounds(100,100,500,500);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
