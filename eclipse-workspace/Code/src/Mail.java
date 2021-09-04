
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
 
 

import java.util.Properties;  
//import javax.mail.*;  
//import javax.mail.internet.*;

public class Mail {
public static void main(String[] args) {
//change these according to you
String HOST_NAME="smtp.gmail.com";
final String USER_NAME="skpalancha@gmail.com";
final String PASSWORD="chintumani";
String TO="pnithin2833@gmail.com";
//get session object
Properties props = new Properties();
props.put("mail.smtp.starttls.enable", true);
props.put("mail.smtp.host",HOST_NAME);
props.put("mail.smtp.auth", "true"); 
//props.put("mail.setTLS","true");

props.put("mail.smtp.port", "587");
Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(USER_NAME,PASSWORD);
}
});
try {
//compose message
MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(USER_NAME));
message.addRecipient(Message.RecipientType.TO,new InternetAddress(TO));
message.setSubject("Java Send Mail");
message.setText("Testing Java Send Mail!!!");
//send message
Transport.send(message);
System.out.println("Message Sent!!!");
} catch (MessagingException e) {
e.printStackTrace();
}
}
}
