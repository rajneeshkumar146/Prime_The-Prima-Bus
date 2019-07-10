
package busbooking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class cancel extends JFrame{
    JButton con=new JButton("CONFIRM");
    DefaultTableModel model=new DefaultTableModel(new String[]{"ID","First Name","Last Name","Email","Seats","From","Destination","Journey Date","Fare"},0);
    String usersql="root";
    JButton back=new JButton("Book Another Ticket");
    String passwordsql="aditya123";
    String link="jdbc:mysql://localhost:3306/";
    String data="";

    public cancel(String email) {
        
        try {
            this.setLayout(null);
        Font font=new Font("Ariel",Font.BOLD,20);
        //String line="ID                     "+"First Name                               "+"Last Name                          "+"Email                                                                           "+"Seats                   "+"From                 "+"Destination                 "+"Journey Date";
       // JLabel lineJLabel= new JLabel(line);
       // lineJLabel.setForeground(Color.YELLOW);
        //lineJLabel.setBounds(200, 200, 1200, 50);
        Connection conn=DriverManager.getConnection(link,usersql,passwordsql);
            Statement smt=(Statement)conn.createStatement();
            model.addRow(new Object[]{"BUS ID","First Name","Last Name","Email","Seats","From","Destination","Journey Date","Fare"});
            JLabel l=new JLabel("SELECT THE BOOKING ");
            l.setBounds(200, 200, 300, 50);
                    l.setFont(font);
                    this.add(l);
            
            ResultSet rs=smt.executeQuery("select * from `bus`.`reserve` where `Email`=\""+email+"\"");
            if(rs.next())
            {
               
               
            rs.previous();
            
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
                
            }
            JLabel lab=new JLabel("YOUR BOOKINGS ");
             
                 
                lab.setFont(font);
                lab.setBounds(200, 150, 600, 50);
            JTable T=new JTable();
            T.setModel(model);
            T.setBounds(200,250,1000,(T.getRowCount()*16));
            this.add(lab);
            this.add(T);
            JButton cancel =new JButton("CANCEL BOOKING");
             cancel.setBounds(500, 550, 300, 50);
            this.add(cancel);
            
            cancel.addActionListener(new ActionListener() {
              
                public void actionPerformed(ActionEvent e) {
                    try {
                        String f=(String)T.getModel().getValueAt(T.getSelectedRow(), 4);
                        
                    smt.executeUpdate("delete from `bus`.`reserve` where `Seats`= \""+f+"\"");
                    
                        sendEmail("YOUR BOOKING OF BUS FROM "+(String)T.getModel().getValueAt(T.getSelectedRow(), 5)+"  TO"+(String)T.getModel().getValueAt(T.getSelectedRow(), 6)+"ON "+(String)T.getModel().getValueAt(T.getSelectedRow(),7)+"  HAS BEEN CANCELED", email);
                    
                    
                    
                    } catch (Exception E) {
                        System.out.println(E);
                    }
                    
                }
            });
            
            
            //this.getContentPane().add(lineJLabel);
            
            this.repaint();
            this.revalidate();
            this.setVisible(true);
            
            
            }
            else
            {
                
            
            ImageIcon icon=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\sorry.jpg");
               
           
                JLabel lab=new JLabel("SORRY YOU DON'T HAVE ANY BOOKING .........");
                JLabel sor=new JLabel(icon);
                lab.setFont(font);
                lab.setBounds(402, 300, 1400, 50);
                sor.setBounds(550, 400, 150, 150);
                this.setBackground(Color.WHITE);
                this.add(sor);
                this.add(lab);
            }
            
            
            
            } catch (Exception e) {
                System.out.println(e);
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
