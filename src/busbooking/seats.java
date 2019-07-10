
package busbooking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import busbooking.avaliablebus;

public class seats extends JPanel implements ActionListener{
      public static String seet="";
    JPanel bus=new JPanel();
    ImageIcon icon=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\seat.png");
    ImageIcon icon1=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\steering.png");
    ImageIcon icon2=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\seatgrey.png");
    ImageIcon icon3=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\busimage.png");
    Font font=new Font("Britannic", Font.ITALIC, 30);
    JLabel disciption=new JLabel(icon3);
    JButton back=new JButton("BACK");
    JLabel plz=new JLabel("PLEASE SELECT YOUR SEATS");
    JButton a1=new JButton("a1",icon);
    JButton a2=new JButton("a2",icon);
    
    JButton b1=new JButton("b1",icon);
    JButton b2=new JButton("b2",icon);
    
    JButton c1=new JButton("c1",icon);
    JButton c2=new JButton("c2",icon);
    
    JButton d1=new JButton("d1",icon);
    JButton d2=new JButton("d2",icon);
    
    JButton e1=new JButton("e1",icon);
    JButton e2=new JButton("e2",icon);
    
    JButton f1=new JButton("f1",icon);
    JButton f2=new JButton("f2",icon);
    
    JButton g1=new JButton("g1",icon);
    JButton g2=new JButton("g2",icon);
    
    JButton h1=new JButton("h1",icon);
    JButton h2=new JButton("h2",icon);
    
    JButton i1=new JButton("i1",icon);
    JButton i2=new JButton("i2",icon);
    
    JButton j1=new JButton("j1",icon);
    JButton j2=new JButton("j2",icon);
    
    JButton k1=new JButton("k1",icon);
    JButton k2=new JButton("k2",icon);
    
    JButton l1=new JButton("l1",icon);
    JButton l2=new JButton("l2",icon);
    
    JButton next =new JButton("NEXT");
    
    JLabel steer=new JLabel(icon1);
    
    ArrayList<JButton> buttonlist=new ArrayList<JButton>();
    
    JLabel msg=new JLabel();
    ArrayList<JButton> al=new ArrayList<JButton>();
   
    public seats() {
        Border border = BorderFactory.createLineBorder(Color.WHITE);
    
       
        {
        
        }
        
        
        
        plz.setFont(font);
        plz.setBounds(100, 50, 500, 100);
    bus.setBounds(100, 200, 500, 200);
    bus.setBackground(Color.white);
    bus.setLayout(null);
    steer.setBounds(10,10, 30, 30);
    a1.setBounds(150, 10, 30, 30);
    a1.setBorder(border);
    a2.setBounds(150, 50, 30, 30);
    a2.setBorder(border);
    
    b1.setBounds(210, 10, 30, 30);
    b1.setBorder(border);
    b2.setBounds(210, 50, 30, 30);
    b2.setBorder(border);
    
    
    c1.setBounds(270, 10, 30, 30);
    c1.setBorder(border);
    c2.setBounds(270, 50, 30, 30);
    c2.setBorder(border);
   
    
    d1.setBounds(330, 10, 30, 30);
    d1.setBorder(border);
    d2.setBounds(330, 50, 30, 30);
    d2.setBorder(border);
    
    e1.setBounds(390, 10, 30, 30);
    e1.setBorder(border);
    e2.setBounds(390, 50, 30, 30);
    e2.setBorder(border);
    
    
    f1.setBounds(450, 10, 30, 30);
    f1.setBorder(border);
    f2.setBounds(450, 50, 30, 30);
    f2.setBorder(border);
   
    g1.setBounds(150, 120, 30, 30);
    g1.setBorder(border);
    g2.setBounds(150, 160, 30, 30);
    g2.setBorder(border);
   
    h1.setBounds(210, 120, 30, 30);
    h1.setBorder(border);
    h2.setBounds(210, 160, 30, 30);
    h2.setBorder(border);
    
    i1.setBounds(270, 120, 30, 30);
    i1.setBorder(border);
    i2.setBounds(270, 160, 30, 30);
    i2.setBorder(border);
    
    j1.setBounds(330, 120, 30, 30);
    j1.setBorder(border);
    j2.setBounds(330, 160, 30, 30);
    j2.setBorder(border);
    
    k1.setBounds(390, 120, 30, 30);
    k1.setBorder(border);
    k2.setBounds(390, 160, 30, 30);
    k2.setBorder(border);
    
    l1.setBounds(450, 120, 30, 30);
    l1.setBorder(border);
    l2.setBounds(450, 160, 30, 30);
    l2.setBorder(border);
    
    
    disciption.setBounds(750, 200, 308, 97);
    next.setBounds(700, 500, 100, 50);
    back.setBounds(400,500, 100, 50);
    msg.setBounds(500,600,300,50);
    this.add(back);
    this.add(bus);
    this.add(disciption);
    this.add(next);
    this.add(plz);
    this.add(msg);
        //a1.setText("a1");
       // System.out.println(a1.getText());
    
    bus.add(steer);
    bus.add(a1);
    bus.add(a2);
    bus.add(b1);
    bus.add(b2);
    bus.add(c1);
    bus.add(c2);
    bus.add(d1);
    bus.add(d2);
    bus.add(e1);
    bus.add(e2);
    bus.add(f1);
    bus.add(f2);
    bus.add(g1);
    bus.add(g2);
    bus.add(h1);
    bus.add(h2);
    bus.add(i1);
    bus.add(i2);
    bus.add(j1);
    bus.add(j2);
    bus.add(k1);
    bus.add(k2);
    bus.add(l1);
    bus.add(l2);
    a1.addActionListener(this);
    a2.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    c1.addActionListener(this);
    c2.addActionListener(this);
    d1.addActionListener(this);
    d2.addActionListener(this);
    e1.addActionListener(this);
    e2.addActionListener(this);
    f1.addActionListener(this);
    f2.addActionListener(this);
    g1.addActionListener(this);
    g2.addActionListener(this);
    h1.addActionListener(this);
    h2.addActionListener(this);
    i1.addActionListener(this);
    i2.addActionListener(this);
    j1.addActionListener(this);
    j2.addActionListener(this);
    k1.addActionListener(this);
    k2.addActionListener(this);
    l1.addActionListener(this);
    l2.addActionListener(this);
    
    buttonlist.add(a1);
    buttonlist.add(a2);
    buttonlist.add(b1);
    buttonlist.add(b2);
    buttonlist.add(c1);
    buttonlist.add(c2);
    buttonlist.add(d1);
    buttonlist.add(d2);
    buttonlist.add(e1);
    buttonlist.add(e2);
    buttonlist.add(f1);
    buttonlist.add(f2);
    buttonlist.add(g1);
    buttonlist.add(g2);
    buttonlist.add(h1);
    buttonlist.add(h2);
    buttonlist.add(i1);
    buttonlist.add(i2);
    buttonlist.add(j1);
    buttonlist.add(j2);
    buttonlist.add(k1);
    buttonlist.add(k2);
    buttonlist.add(l1);
    buttonlist.add(l2);
    
    
    
    
    
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton b=(JButton)e.getSource();
        if(b.getIcon()==icon)
        {
        b.setIcon(icon2);
            
            al.add(b);
            
            
       }
        else
        {
        b.setIcon(icon); 
        for(int i=0;i<al.size();i++)
        {
            if(al.get(i).getText().equals(b.getText()))
            {
                al.remove(i);
            }
        }
        }
    }
}
