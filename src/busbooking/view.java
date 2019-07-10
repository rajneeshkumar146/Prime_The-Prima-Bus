
package busbooking;

import static busbooking.thanks.sendEmail;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class view extends JFrame{

JButton con=new JButton("CONFIRM");
JButton cancel =new JButton("CANCEL YOUR BOOKING");
    DefaultTableModel model=new DefaultTableModel(new String[]{"ID","First Name","Last Name","Email","Seats","From","Destination","Journey Date","Fare"},0);
    String usersql="root";
    JButton back=new JButton("Book Another Ticket");
    String passwordsql="aditya123";
    String link="jdbc:mysql://localhost:3306/";
    String data="";
    Container contain;
   
    
    public view(String email) {
        
        try {
            this.getContentPane().setLayout(null);
        Font font=new Font("Ariel",Font.BOLD,20);
        //String line="ID                     "+"First Name                               "+"Last Name                          "+"Email                                                                           "+"Seats                   "+"From                 "+"Destination                 "+"Journey Date";
       // JLabel lineJLabel= new JLabel(line);
       // lineJLabel.setForeground(Color.YELLOW);
        //lineJLabel.setBounds(200, 200, 1200, 50);
        Connection conn=DriverManager.getConnection(link,usersql,passwordsql);
            Statement smt=(Statement)conn.createStatement();
            model.addRow(new Object[]{"BUS ID","First Name","Last Name","Email","Seats","From","Destination","Journey Date","Fare"});
                 contain=this.getContentPane();
            
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
            this.getContentPane().add(lab);
            this.getContentPane().add(T);
            
            //this.getContentPane().add(lineJLabel);
     
             
            
            
            cancel.setBounds(500, 550, 300, 50);
            this.add(cancel);
            
            
            
            
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
        
  
    

    
}
