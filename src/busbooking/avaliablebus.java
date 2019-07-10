
package busbooking;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class avaliablebus extends JPanel{
    String usersql="root";
    String passwordsql="aditya123";
    String link="jdbc:mysql://localhost:3306/";
    DefaultTableModel model=new DefaultTableModel(new String[]{"BUS ID","Source","Destination","Type","Departure Time","Arrival At Destination","Fare"},0);
    
    public static JTable list=new JTable();
    JButton select=new JButton();
    String data;
    
    JLabel notselect =new JLabel("PLEASE SELECT A BUS");
    JButton back=new JButton("BACK");
    public static Vector<String> i=new Vector<String>();
    JButton b1=new JButton("NEXT");
    public avaliablebus(String source,String destination ,String date) {
        try {
            
            
            
            
            
            Connection conn=DriverManager.getConnection(link,usersql,passwordsql);
            Statement smt=(Statement)conn.createStatement();
            
            
            
            
           
            
            
            ResultSet rs=smt.executeQuery("select * from `bus`.`availablebus` where `Source`=\""+source+"\"and `Destination`=\""+destination+"\"and `Date`=\""+date+"\" ");
            if(rs.next())
            {
            model.addRow(new Object[]{"BUS ID","Source","Destination","Type","Departure Time","Arrival time","Fare"});
            rs.previous();
            while(rs.next())
            {  
                String id=rs.getString("ID");
                String sou=rs.getString("Source");
                String des=rs.getString("Destination");
                String typ=rs.getString("Type");
                String dep=rs.getString("Departure Time");
                String arr=rs.getString("Arrival time");
                String far=rs.getString("Fare");
                i.add(id);
                 model.addRow(new Object[]{id,sou,des,typ,dep,arr,far});
                
                
            }
          
           
           
            list.setModel(model);
            list.setBounds(300, 320, 800,(list.getRowCount()*16));
            ImageIcon icon=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\bus.jpg");
            JLabel sor=new JLabel(icon);
            sor.setBounds(0,0,1400,300);
            
            
            this.add(sor);
           
            this.setBackground(Color.BLACK);
            b1.setBounds(700, 620, 100, 50);
            back.setBounds(500,620, 100, 50);
            Font font=new Font("Ariel",Font.BOLD,15);
            notselect.setFont(font);
            notselect.setForeground(Color.white);
            notselect.setBounds(500, 550, 200, 100);
            
            this.add(b1);
            this.add(list);
            //this.add(lab);
            this.add(back);
            }
            else
            {
                ImageIcon icon=new ImageIcon("C:\\Users\\adity\\Desktop\\images\\sorry.jpg");
                Font font=new Font("Ariel",Font.BOLD,20);
           
                JLabel lab=new JLabel("SORRY NO BUSES FOUND FOR THE GIVEN LOCATION AT GIVEN DATE PLEASE CHOOSE ANOTHER DATE.........");
                JLabel sor=new JLabel(icon);
                
                lab.setBounds(102, 300, 1400, 50);
                sor.setBounds(550, 400, 150, 150);
                this.add(sor);
                lab.setFont(font);
                this.add(lab);
                this.setBackground(Color.WHITE);
                
                back.setBackground(Color.WHITE);
                 back.setBounds(580,600, 100, 50);
                  this.add(back);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       
       
    }
    
    
    
    
}
