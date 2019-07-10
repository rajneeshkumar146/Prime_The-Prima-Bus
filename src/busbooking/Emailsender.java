package busbooking;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Emailsender {
    public static boolean sendMail(String from,String Password,String message,String to[])
    {
        String host="smtp.gmail.com";
        Properties props=System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", Password);
        props.put("mail.smtp.port",587);
        props.put("mail.smtp.auth","true");
        Session session=Session.getDefaultInstance(props,null);
        MimeMessage mimeMessage=new MimeMessage(session);
        try {
             mimeMessage.setFrom(new InternetAddress(from));
             InternetAddress[] toAddresses=new InternetAddress[to.length];
             for(int i=0;i<to.length;i++)
             {
                 toAddresses[i]=new InternetAddress(to[i]);
                 
             }
             
             for(int i=0;i<toAddresses.length;i++)
             {
               mimeMessage.addRecipient(Message.RecipientType.TO,toAddresses[i]);
               
             }
             
             mimeMessage.setSubject("Your Bus Booking Ticket");
             mimeMessage.setText(message);
             Transport transPort=session.getTransport("smtp");
             transPort.connect(host,from,Password);
             transPort.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
             transPort.close();
             return true;
             
        } catch (Exception e) {
            System.out.println(e);
        }
       
    return false;
    }
    
}
