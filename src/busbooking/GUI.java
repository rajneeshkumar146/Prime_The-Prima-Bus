
package busbooking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import jdk.nashorn.internal.objects.Global;
import busbooking.seats;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.text.View;

public class GUI extends JFrame{
    
        JComboBox d;             //ComboBox
        JComboBox m;
        JComboBox y;
        String day[]=new String[31];
        String month[]={"january","february","march","april","may","june","july","august","september","october","november","december"};
        String year[]={"2016","2017","2018","2019","2020"};
        JPanel content =new JPanel();
        JPanel signin =new JPanel();
        JPanel register =new JPanel();
        JPanel main =new JPanel();
        JButton sign=new JButton("signin");
        JButton reg=new JButton("register");
        JLabel l=new JLabel();
        thanks tk;
        public static String seat="";
        Container c;
        Font f;
        public  mainpanel mp=new mainpanel();
        public  enterlocation el=new enterlocation();
        public   avaliablebus ab;
        public  seats seats=new seats();
        
        static  String source="";
        static  String destination="";
        static  String date="";
        static  String IDno;
         JScrollPane sp=new JScrollPane();
         String set ="";
    public GUI()
    { 
      c=this.getContentPane();
      
      mp.setLayout(null);
      c.add(mp);
      
      
      
       mp.login.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                 if(mp.user1.getText().isEmpty())
                                 {
                                     mp.msg.setText("Plzz Enter Username");
                                     mp.bar.repaint();
                                     mp.bar.revalidate();
                                 }
                                 else if(mp.pass1.getText().isEmpty())
                                 {
                                     mp.msg.setText("Plzz Enter Password");
                                     mp.bar.repaint();
                                     mp.bar.revalidate();
                                 }
                                 
                                 else
                                 {
                                     
                                     try {
                                         Connection conn=DriverManager.getConnection(mp.link,mp.usersql,mp.passwordsql);
                                         Statement smt=(Statement)conn.createStatement();
                                         ResultSet rs=smt.executeQuery("select * from bus.user");
                                         
                                         
                                         
                                         while(rs.next()||rs.isAfterLast())
                                         {
                                             if(rs.isAfterLast())
                                             {
                                                 if(rs.getString("Email").equals(mp.user1.getText())||rs.getString("Password").equals(mp.pass1.getText()))
                                                 { 
                                                 c.remove(mp);
                                                 c.revalidate();
                                                 c.repaint();
                                                 
                                               /* wait w=new wait();
                                                 w.setLayout(null);
                                                 c.add(w);
                                                 c.revalidate();
                                                 c.repaint();
                                                 c.remove(w);*/
                                                 mp.bar.remove(mp.msg);
                                                 mp.bar.repaint();
                                                 mp.bar.revalidate();
                                                
                                                 el.setLayout(null);
                                                 
                                                 c.add(el);
                                                 c.revalidate();
                                                 c.repaint();
                                                 }
                                                 else 
                                                 {
                                                     mp.msg.setText("Email id Dosen't exist");
                                                     System.out.println("Hello");
                                                     mp.bar.repaint();
                                                     mp.bar.revalidate();
                                                 }
                                                 
                                             }
                                             else if(rs.getString("Email").equals(mp.user1.getText())||rs.getString("Password").equals(mp.pass1.getText()))
                                             {
                                                 c.remove(mp);
                                                 c.revalidate();
                                                 c.repaint();
                                                 
                                               /* wait w=new wait();
                                                 w.setLayout(null);
                                                 c.add(w);
                                                 c.revalidate();
                                                 c.repaint();
                                                 c.remove(w);*/
                                                mp.bar.remove(mp.msg);
                                                mp.bar.repaint();
                                                 mp.bar.revalidate();
                                                 el.setLayout(null);
                                                 
                                                 c.add(el);
                                                 c.revalidate();
                                                 c.repaint();
                                             }
                                             
                                         }
                                         
                                         conn.close();
                                     } 
                                     catch (Exception E) {
                                         System.out.println(E);
                                     }
                                     
                                 }
                                 
                                     
                            }
                         });
       
       
  
       
       
       mp.Siup.addActionListener(new ActionListener() 
       {
         public void actionPerformed(ActionEvent e) {
            if(!mp.fn.getText().isEmpty() && !mp.ln.getText().isEmpty() && 
                    !mp.email.getText().isEmpty() && !mp.reenter.getText().isEmpty()
                    && !mp.pass.getPassword().toString().isEmpty() 
                    && !mp.d.getSelectedItem().toString().equals("DAY") 
                    && !mp.m.getSelectedItem().toString().equals("MONTH") && !mp.y.getSelectedItem().toString().equals("YEAR"))
            {
                System.out.println("hello");
                if(mp.email.getText().equals(mp.reenter.getText()))
                {
                    
                    
                    
                    
                String fn="",ln="",email="",pass="",gender="";
                fn=mp.fn.getText();
                ln=mp.ln.getText();
                email=mp.email.getText();
                pass=mp.pass.getText();
                if(mp.male.isSelected())
                    gender="male";
                else
                    gender="Female";
                String d=mp.d.getSelectedItem().toString()+"/"+mp.m.getSelectedItem().toString()+"/"+mp.y.getSelectedItem().toString();
                       try {
                                         Connection conn=DriverManager.getConnection(mp.link,mp.usersql,mp.passwordsql);
                                         Statement smt=(Statement)conn.createStatement();
                                         smt.executeUpdate("insert into `bus`.`user` (`First Name`,`Last Name`,`Email`,`password`,`Date of Birth`,`Gender`)values(\""+fn+"\",\""+ln+"\",\""+email+"\",\""+pass+"\",\""+d+"\",\""+gender+"\")");
                                         
                                                 mp.below.add(mp.msg2);
                                                 mp.msg2.setText("USER REGISTERED");
                                                 c.revalidate();
                                                 c.repaint();
                                                 mp.below.revalidate();
                                                 mp.below.repaint();
                                                 conn.close();
                       }
                       catch(Exception E)
                       {
                           System.out.println(E);
                       }
                
                
                }
                else{
                                                 mp.msg2.setText("Email does not match ");
                                                 mp.below.add(mp.msg2);
                                                 c.revalidate();
                                                 c.repaint();
                                                 mp.below.revalidate();
                                                 mp.below.repaint();
                }
            }
            
            else if(mp.fn.getText().equals("First Name")||mp.ln.getText().equals("Last Name")||mp.email.getText().equals("Email")||mp.reenter.getText().equals("Reenter Email")||mp.pass.getText().equals("Password"))
            {
                // ADD FOR EMPTY FIELDS     
             
                                                 mp.msg2.setText("Please fill all details");
                                                 mp.below.add(mp.msg2);
                                                 
                                                 mp.below.revalidate();
                                                 mp.below.repaint();
                                                 c.revalidate();
                                                 c.repaint();
            }
            
                
                
                }
      });
       
       
       mp.email.addFocusListener(new FocusListener(){
            
                public void focusGained(FocusEvent f)
                {
                  mp.below.remove(mp.msg2);
                  
                    mp.msg2.setText("");
                    c.revalidate();
                    c.repaint();
                    mp.below.revalidate();
                    mp.below.repaint();
                    
                    
                }
                public void focusLost(FocusEvent f)
                {
                    try {
                   Connection connect=DriverManager.getConnection(mp.link,mp.usersql,mp.passwordsql);
                   Statement smt=connect.createStatement(); 
                ResultSet rs=smt.executeQuery("select * from `bus`.`user`");
                   while(rs.next())
                   {
                       if(mp.email.getText().equals(rs.getString("Email")))
                       {
                           
                           mp.below.add(mp.msg2);
                           mp.msg2.setText("Username not available");
                            
                            mp.below.revalidate();
                            mp.below.repaint();
                            c.revalidate();
                    c.repaint();
                       }
                   }
                          
                    }
                    catch(Exception e)
                    {
                        
                    }
                }
            });
       
       
       el.view.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              view v=new view(mp.user1.getText());
            v.setTitle("BUS BOOKING SYSTEM");
            v.setVisible(true);
            v.setBounds(100,100,500,500);
            v.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            v.cancel.addActionListener(new ActionListener() {
                  
                  public void actionPerformed(ActionEvent e) {
                      cancel c =new cancel(mp.user1.getText());
                c.setVisible(true);
            //c.setBounds(100,100,500,500);
            c.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                      v.setVisible(false);
                    /*System.out.println("hello");*/
                
                  }
              });
          }
      });
     
       el.go.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
              
                                                 source=el.from_tf.getText() ;
                                                 destination=el.to_tf.getText() ;
                                                 date=el.d.getSelectedItem().toString()+"/"+el.m.getSelectedIndex()+"/"+el.y.getSelectedItem().toString();
                                                 ab=new avaliablebus(source,destination,date);
                                                 c.remove(el);
                                                 c.add(ab);
                                                 ab.setLayout(null);
                                                 c.revalidate();
                                                 c.repaint();
                                                 ab.back.addActionListener(new ActionListener() {
                                                    
                                                     public void actionPerformed(ActionEvent e) {
                                                 
                                                 el.setLayout(null);
                                                 c.remove(ab);
                                                 c.add(el);
                                                 c.revalidate();
                                                 c.repaint();
                                                    }
                                                 });
                                                 
                                                 ab.b1.addActionListener(new ActionListener() 
                                                 {
                                                    public void actionPerformed(ActionEvent e) 
                                                    {
                                                    try {
                                                            
                                                    
                                                    Connection conn=DriverManager.getConnection(mp.link,mp.usersql,mp.passwordsql);
                                                    Statement smt=(Statement)conn.createStatement();
                                                    if(ab.list.getSelectedRow()>-1)
                                                    {
                                                    IDno=ab.i.get(ab.list.getSelectedRow());
                                                    String st =avaliablebus.i.get(avaliablebus.list.getSelectedRow());
                                                    //FOR DISPLAYING BOOKED SEATS
                                                    ResultSet rs=smt.executeQuery("select * from `bus`.`reserve` where `ID`=\""+st+"\"");
                                                    while(rs.next())
                                                    {
                                                        set=set+rs.getString("Seats");
                                                    }
                                                    
                                                    char [] s=set.toCharArray();
                                                    
                                                    for(int i=0;i<s.length;i=i+3)
                                                    {
                                                        String sa=""+s[i]+s[i+1];
                                                        
                                                        for(int j=0;j<seats.buttonlist.size();j++)
                                                        {
                                                        if(seats.buttonlist.get(j).getText().equals(sa))
                                                        {
                                                           seats.buttonlist.get(j).setEnabled(false);
                                                        }
                                                        
                                                        }
                                                        
                                                    }
                                                    c.remove(ab);
                                                    c.add(seats);
                                                    seats.setLayout(null);
                                                    c.revalidate();
                                                    c.repaint();
                                                    
                                                    }
                                                    else
                                                    {
                                                        ab.add(ab.notselect);
                                                        c.revalidate();
                                                    c.repaint();
                                                    }
                                                    
                                                    }
                                                    catch (Exception E) 
                                                    {
                                                        System.out.println(E);
                                                    }
                                                    }
                                                 });
                                                 
          }
      });
       seats.back.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
                                                 c.remove(seats);
                                                 c.add(ab);
                                                 ab.setLayout(null);
                                                 c.revalidate();
                                                 c.repaint();
          }
      });
       
       
       
       seats.next.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
              if(seats.al.isEmpty())
                  seats.msg.setText("Please Select minimum one seat");
              else
              {
                  try {
                      Connection conn=DriverManager.getConnection(mp.link,mp.usersql,mp.passwordsql);
                  Statement smt=(Statement)conn.createStatement();
                 ResultSet rs;
              String id=IDno;
              String firn="";
              String lasn="";
              String email="";
              String fare="";
              String from="";
              String destination2="";
              String jdate="";
              
              
             
              rs=smt.executeQuery("select * from `bus`.`user` where `Email`=\""+mp.user1.getText()+"\"");
              
              //if(!rs.next())
                //  rs=smt.executeQuery("select * from `bus`.`user` where `Email`=\""+mp.email.getText()+"\"");
               
              
              if(rs.next())
              {
                  firn=rs.getString("First name");
                  lasn=rs.getString("Last name");
                  email=rs.getString("Email");
              }
              
              rs=smt.executeQuery("select * from `bus`.`availablebus` where `ID`=\""+id+"\"");
              
              if(rs.next())
              {
                  Integer a=Integer.parseInt(rs.getString("Fare"))*(seats.al.size());
                  fare=a.toString();
              }
              
              for(int i=0;i<seats.al.size();i++)
              {
                  seat=seat+seats.al.get(i).getText()+",";
                  
              }
              from=el.from_tf.getText();
              destination2=el.to_tf.getText();
              jdate=el.d.getSelectedItem().toString()+"/"+el.m.getSelectedIndex()+"/"+el.y.getSelectedItem().toString();
              
              smt.executeUpdate("insert into `bus`.`reserve`(`ID`,`First Name`,`Last Name`,`Email`,`Seats`,`From`,`Destination`,`Journey Date`,`Total Amount`) values ('"+IDno+"','"+firn+"','"+lasn+"','"+email+"','"+seat+"','"+from+"','"+destination2+"','"+jdate+"','"+fare+"');");
               conn.close();
               c.remove(seats);
               tk=new thanks();
               c.add(tk);
               tk.setLayout(null);
               c.revalidate();
               c.repaint();
                tk.back.addActionListener(new ActionListener() {
          
                     public void actionPerformed(ActionEvent e) {
               el=new enterlocation();
               c.remove(tk);
               el.setLayout(null);
               c.add(el);
               c.revalidate();
               c.repaint();
          
                                  }
                                 });
               
               
                  }
               catch (Exception E) {
                      System.out.println(E);
                  }
                  
                  
              
              
              }
              
          }
      });
       
        
       
            this.pack();
       
    }
}
