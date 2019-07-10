
package busbooking;

import java.awt.*;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.*;


public class mainpanel extends JPanel implements FocusListener{
        
             String day[]=new String[32];
             String month[]={"MONTH","january","february","march","april","may","june","july","august","september","october","november","december"};
             String year[]=new String[51];
             JComboBox d;             //ComboBox
             JComboBox m;
             JComboBox y;
             JRadioButton male =new JRadioButton("Male") ;       //RadioButton
             JRadioButton female =new JRadioButton("Female") ;   
             ButtonGroup b1=new ButtonGroup();
             JPanel bar=new JPanel();
             JPanel below =new JPanel();
             JTextField fn=new JTextField();
             JTextField ln=new JTextField();
             JTextField email=new JTextField();
             JTextField reenter=new JTextField();
             JPasswordField pass=new JPasswordField();
             JLabel msg=new JLabel();
             String usersql="root";
             String passwordsql="aditya123";
             String link="jdbc:mysql://localhost:3306/";
             JTextField user1 =new JTextField();
             JPasswordField pass1=new JPasswordField();
             JButton login=new JButton("LOG IN");
             JButton Siup =new JButton("Signup");
             JLabel msg2=new JLabel("USER REGISTERED PLEASE SIGNIN WITH YOUR ACCOUNT");
             public mainpanel() 
             {
            
             {           //BAR PANEL
                //FOR SIGN IN
                         Border border = BorderFactory.createLineBorder(Color.BLUE);
                
                bar.setLayout(null);
                bar.setBounds(0, 0, 1400, 150);
                bar.setBackground(Color.BLACK); 
                this.add(bar);
                Font f=new Font("Bradley Hand ITC",Font.ITALIC,50);
                Font f1=new Font("Bradley Hand ITC",Font.BOLD,25);
                Font f2=new Font("Bradley Hand ITC",Font.BOLD,15);
                Font f3=new Font("Ariel",Font.BOLD,15);
                
                JLabel mybus=new JLabel("PRIME BUS");
                JLabel username=new JLabel("Email or Phone");
                JLabel password=new JLabel("Password");
                
                
              
        
                mybus.setBounds(50, 50, 500, 60);
                username.setBounds(700, 30, 200, 50);
                msg.setBounds(700, 110, 200, 30);
                password.setBounds(950, 30, 200, 50);
                
                login.setBounds(1160, 50, 150, 50);
        
                mybus.setForeground(Color.WHITE);
                username.setForeground(Color.WHITE);
                password.setForeground(Color.WHITE);
                login.setForeground(Color.WHITE);
                
                login.setBackground(Color.BLACK);
                
                login.setBorder(border);
                msg.setForeground(Color.WHITE);
                msg.setFont(f3);
                mybus.setFont(f);
                username.setFont(f3);
                password.setFont(f3);
                
                login .setFont(f3);
                   
                user1.setBounds(700, 70, 200, 30);
                pass1.setBounds(950, 70, 200, 30);
                
                Cursor cur=new Cursor(Cursor.HAND_CURSOR);
                login.setCursor(cur);
        
                bar.add(mybus);
                bar.add(username);
                bar.add(password);
                
                bar.add(user1);
                bar.add(pass1);
                bar.add(login);
                bar.add(msg);
                
        
        
            }
        
                    //BELOW JPANEL
                    //FOR SIGN UP
                 
                 
                for(int i=1;i<51;i++)
                year[i]=Integer.toString(i+1970);
                for(int i=1;i<32;i++)
                day[i]=Integer.toString(i);
            
                year[0]="YEAR";
                day[0]="DAY";
            
                d=new JComboBox(day);        //ComboBox
                m=new JComboBox(month);
                y=new JComboBox(year);
                
                ImageIcon icon =new ImageIcon("C:\\Users\\adity\\Desktop\\images\\thamks.png");
            
                Font f=new Font("Britannic",Font.ITALIC,70);
                Font f1=new Font("Britannic",Font.BOLD,45);
                Font f2=new Font("Britannic",Font.BOLD,18);
                below.setLayout(null);
                below.setBounds(0, 150, 1400, 700);
                below.setBackground(Color.ORANGE);
                this.add(below);
                JLabel Signup =new JLabel("Signup");
                JLabel free =new JLabel("Its Free And Always Will Be");
                JLabel Birthday =new JLabel("Birthday");
                
                JLabel pic=new JLabel(icon);
                
                
                
                fn.addFocusListener(this);
                ln.addFocusListener(this);
                email.addFocusListener(this);        
                reenter.addFocusListener(this);
                pass.addFocusListener(this);
                
                
                Signup.setBounds(700, 10, 200, 100);
                free.setBounds(705, 70, 300, 100);
                fn.setBounds(705, 170, 200, 30);
                ln.setBounds(925, 170, 200, 30);
                email.setBounds(705, 220, 420, 30);
                reenter.setBounds(705, 270, 420, 30);
                pass.setBounds(705, 320, 420, 30);
                Birthday.setBounds(705, 370, 420, 30);
                d.setBounds(705,420,90,30);
                m.setBounds(805,420,90,30);
                y.setBounds(905,420,90,30);
                pic.setBounds(100, 100, 400, 400);
                male.setBounds(705,470,100,25);         //RadioButton for gender
                female.setBounds(905,470,100,25);
            
                male.setBackground(Color.orange);
                female.setBackground(Color.orange);
                b1.add(male);
                b1.add(female);
                
                Siup.setBounds(790,500,100,30);
                msg2.setBounds(900,500,500,30);
               
                Signup.setFont(f1);
                free.setFont(f2);
                Birthday.setFont(f2);
                male.setFont(f2);
                female.setFont(f2);
                
                
                fn.setText("First Name");
                ln.setText("Last Name");
                email.setText("Email");
                pass.setEchoChar((char)0);
                pass.setText("Password");
                reenter.setText("Reenter Email");
                
                
                
                below.add(Signup);
                below.add(free);
                below.add(Birthday);
                below.add(Siup);
                below.add(fn);
                below.add(ln);
                below.add(email);
                below.add(reenter);
                below.add(pass);
                below.add(d);
                below.add(y);
                below.add(m);
                below.add(male);
                below.add(female);
                below.add(pic);
                below.repaint();
                below.revalidate();
            
       
        
        
        
        
        
        
        
        
    }
        
       public void focusLost(FocusEvent e)
            {
                if(e.getSource()==fn)
                {
                    if(fn.getText().isEmpty())
                    {
                    fn.setText("First Name");
                    below.repaint();
                    below.revalidate();
                    }
                    
                }
                if(e.getSource()==ln)
                {
                    if(ln.getText().isEmpty())
                    {
                    ln.setText("Last Name");
                    below.repaint();
                    below.revalidate();
                    }
                }
                if(e.getSource()==email)
                {
                    if(email.getText().isEmpty())
                    {
                    email.setText("Email");
                    below.repaint();
                    below.revalidate();
                    }
                }
                if(e.getSource()==pass)
                {   
                    if(pass.getText().isEmpty())
                    {
                        pass.setEchoChar((char)0);
                    pass.setText("Password");
                    below.repaint();
                    below.revalidate();
                    }
                }
                if(e.getSource()==reenter)
                {
                    if(reenter.getText().isEmpty())
                    {
                    reenter.setText("Reenter Email");
                    below.repaint();
                    below.revalidate();
                    }
                }
            }
            
            public void focusGained(FocusEvent e)
            {
                if(e.getSource()==fn)
                {
                    if(fn.getText().equals("First Name"))
                    {
                        
                    fn.setText("");
                    below.repaint();
                    below.revalidate();
                    }
                }
                if(e.getSource()==ln)
                {
                    if(ln.getText().equals("Last Name"))
                    {
                    ln.setText("");
                    below.repaint();
                    below.revalidate();
                    }
                }
                if(e.getSource()==email)
                {
                    if(email.getText().equals("Email"))
                    {
                    email.setText("");
                    below.repaint();
                    below.revalidate();
                    }
                }
                if(e.getSource()==pass)
                {
                    pass.setEchoChar('*');
                    if(pass.getText().equals("Password"))
                    {
                    pass.setText("");
                    below.repaint(); 
                    below.revalidate();
                    }
                }
                if(e.getSource()==reenter)
                {
                    if(reenter.getText().equals("Reenter Email"))
                    {
                    reenter.setText("");
                    below.repaint();
                    below.revalidate();
                    }
                }
                
            }  
}


