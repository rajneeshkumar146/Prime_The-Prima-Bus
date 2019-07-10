
package busbooking;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class enterlocation extends JPanel implements FocusListener
{
    JComboBox d;             //ComboBox
        JComboBox m;
        JComboBox y;
        String day[]=new String[32];
        JButton view=new JButton("VIEW YOUR OTHER BOOKINGS");
        String month[]={"MONTH","january","february","march","april","may","june","july","august","september","october","november","december"};
        String year[]={"YEAR","2016","2017","2018","2019","2020"};
        Font f;
        JTextField from_tf =new JTextField();
        JTextField to_tf =new JTextField();
        JButton go=new JButton();
     public enterlocation()
     {
       ImageIcon icon=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\icon.png");
       ImageIcon icon2=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\cover.jpg");
       ImageIcon icon3=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\go.png");
         for(int i=1;i<=31;i++)
                day[i]=Integer.toString(i);
        day[0]="DAY";
         
        d=new JComboBox(day);        //ComboBox
        m=new JComboBox(month);
        y=new JComboBox(year);
        f=new Font("Arial",Font.BOLD,20);
        JLabel from=new JLabel("From :-");
        JLabel to=new JLabel("To :-");
        from.setBounds(100, 350, 100, 50);
        from.setFont(f);
        to.setBounds(700, 350, 100, 50);
        to.setFont(f);
        
        JLabel frompic=new JLabel(icon);
        JLabel topic=new JLabel(icon);
        frompic.setBounds(260, 372, icon.getIconWidth(), icon.getIconHeight());
        topic.setBounds(850, 372, icon.getIconWidth(), icon.getIconHeight());
     
        from_tf.setBounds(280, 360, 200, 30);
       // from_tf.setFont(f);
       
        to_tf.setBounds(870, 360, 200, 30);
       // to_tf.setFont(f);
     
        JLabel pic=new JLabel("WELCOME");
        pic.setIcon(icon2);
        pic.setBounds(0, 0,1400,300);
        
        JLabel Journey=new JLabel("Journey Date :-");
        Journey.setFont(f);
        Journey.setBounds(380, 450, 200, 50);
        from_tf.setText("Enter City");
        to_tf.setText("Enter City");
        
        d.setBounds(580,460,90,30);
        m.setBounds(680,460,90,30);
        y.setBounds(780,460,90,30);
       // go.setIcon(icon3);
        go.setBounds(580, 600, 100, 50);
        go.setText("NEXT");
        this.add(topic);
        this.add(Journey);
        this.add(frompic);
        this.add(to);
        this.add(pic);
        this.add(from);
        this.add(to_tf);
        this.add(from_tf);
        this.add(d);
        this.add(m);
        this.add(y);
        this.add(go);
        
        from_tf.addFocusListener(this);
        to_tf.addFocusListener(this);
        view.setBounds(380, 670, 500, 30);
        this.add(view);
     }
      public void focusLost(FocusEvent e)
            {
                if(e.getSource()==from_tf)
                {
                   if(from_tf.getText().isEmpty())
                   {
                       from_tf.setText("Enter City");
                   }
                }
                if(e.getSource()==to_tf)
                {
                    if(to_tf.getText().isEmpty())
                   {
                       to_tf.setText("Enter City");
                   }
                }
            }
    
      public void focusGained(FocusEvent e)
            {
               if(e.getSource()==from_tf)
                {
                if(from_tf.getText().equals("Enter City"))
                   {
                       from_tf.setText("");
                   }    
                }
                if(e.getSource()==to_tf)
                {
                     if(to_tf.getText().equals("Enter City"))
                   {
                       to_tf.setText("");
                   }
                } 
            }

}
