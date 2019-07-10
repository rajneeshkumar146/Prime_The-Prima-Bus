
package busbooking;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import javax.swing.*;
import java.sql.*;

class delay extends Thread
{
    public void run()
    {
        
      
    }
}

public class wait extends JPanel
{
    
        JLabel pleasewait=new JLabel("PLEASE WAIT LOGGING IN");
        JLabel dot=new JLabel(". . . . ");
        String d=".";
    public wait()
    {
        this.setBackground(Color.LIGHT_GRAY);
        
        pleasewait.setBounds(100, 100, 500, 300);
        Font f=new Font("Ariel",Font.BOLD,30);
        pleasewait.setFont(f);
        dot.setBounds(600, 100, 500, 300);
        dot.setFont(f);
        this.add(pleasewait);
        this.add(dot);
        
        
                                             }
       // return;
       
        
    
    
}
