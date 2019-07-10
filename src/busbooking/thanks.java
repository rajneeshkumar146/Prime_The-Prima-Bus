
package busbooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import busbooking.GUI;
import javax.swing.table.DefaultTableModel;

public class thanks extends JPanel{
    JButton con=new JButton("CONFIRM");
    DefaultTableModel model=new DefaultTableModel(new String[]{"ID","First Name","Last Name","Email","Seats","From","Destination","Journey Date","Fare"},0);
    
    String usersql="root";
    JButton back=new JButton("Book Another Ticket");
    String passwordsql="aditya123";
    String link="jdbc:mysql://localhost:3306/";
    String data="";
     JButton ticket=new JButton("Send Ticket To email");
     String Message;
    public thanks() {
        try {
            
        Font font=new Font("Ariel",Font.BOLD,20);
        JLabel msg= new JLabel("Thanks For Traveling With PRIME BUS");
        JLabel msg2= new JLabel("PLEASE CHECH YOUR DETAILS");
        JLabel msg3= new JLabel("PAYMENT WILL BE DONE AT THE BOARDING POINT");
        JLabel msg4= new JLabel("FOR ANY QUERIES OR CANCELATION PLEASE CONTACT CUSTOMER SUPPORT :-1800633121");
         model.addRow(new Object[]{"BUS ID","First Name","Last Name","Email","Seats","From","Destination","Journey Date","Fare"});
        msg.setBounds(200, 100, 700, 100);
        msg.setForeground(Color.YELLOW);
        msg2.setForeground(Color.YELLOW);
        msg3.setForeground(Color.YELLOW);
        msg4.setForeground(Color.YELLOW);
        msg4.setBounds(200, 150, 700, 100);
        
        this.setBackground(Color.blue);
       // String line="ID                     "+"First Name                               "+"Last Name                          "+"Email                                                                           "+"Seats                   "+"From                 "+"Destination                 "+"Journey Date";
       // JLabel lineJLabel= new JLabel(line);
       // lineJLabel.setForeground(Color.YELLOW);
       // lineJLabel.setBounds(200, 200, 1200, 50);
            Connection conn=DriverManager.getConnection(link,usersql,passwordsql);
            Statement smt=(Statement)conn.createStatement();
            ResultSet rs=smt.executeQuery("select * from `bus`.`reserve` where `Seats`=\""+GUI.seat+"\"");
           Message="";
            while(rs.next())
            {   
                String id=rs.getString("ID");
                String fn=rs.getString("First Name");
                String ln=rs.getString("Last Name");
                String em=rs.getString("Email");
                String sea=rs.getString("Seats");
                String fr=rs.getString("From");
                String des=rs.getString("Destination");
                String jour=rs.getString("Journey Date");
                String fare=rs.getString("Total Amount");
                model.addRow(new Object[]{id,fn,ln,em,sea,fr,des,jour,fare});
                Message="ID ="+id+"\n";
                Message=Message+"First Name ="+fn+"\n";
                Message=Message+"Last Name ="+ln+"\n";
                Message=Message+"Email ="+em+"\n";
                Message=Message+"Seats ="+sea+"\n";
                Message=Message+"FROM ="+fr+"\n";
                Message=Message+"Destination="+des+"\n";
                Message=Message+"Journey Date="+jour+"\n";
                Message=Message+"Fare ="+fare+"\n";
                
            }
            JTable T=new JTable();
            T.setModel(model);
            T.setBounds(200,250,1000,(T.getRowCount()*16));
            msg3.setBounds(200,350,1200,100);
            msg4.setBounds(200, 450, 700, 100);
            back.setBounds(500, 550, 300, 50);
            ticket.setBounds(500, 650, 300, 50);
            this.add(ticket);
            this.add(msg);
            this.add(msg2);
            this.add(msg3);
            this.add(msg4);
            //this.add(lineJLabel);
            this.add(back);
            this.add(T);
            
            ticket.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    if(rs.isAfterLast())
                        rs.previous();
                
                sendEmail(Message,rs.getString("Email"));    
                } catch (Exception E) {
                    System.out.println(E);
                }
                
            }
        });
            
            
            } catch (Exception e) {
        }
    }
 
    public static void sendEmail(String message,String to)
    {
        String[] t=new String[1];
        t[0]=to;
       if( Emailsender.sendMail("aditya.it.msit@gmail.com","aditya/.,",message,t))
       {
           System.out.println("Email sent");
       }
       else
       {
           System.out.println("Email not sent");
       }
    }
    
    
}
