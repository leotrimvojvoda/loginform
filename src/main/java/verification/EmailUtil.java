package verification;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void prepareEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-MVC"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

 public void sendForReal(String toEmail, String code){
     final String fromEmail = "springloginform@gmail.com"; //requires valid gmail id
     final String password = "dynkob-kibTom-byrny4"; // correct password for gmail id


     System.out.println("TLSEmail Start");
     Properties props = new Properties();
     props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
     props.put("mail.smtp.port", "587"); //TLS Port
     props.put("mail.smtp.auth", "true"); //enable authentication
     props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
         //override the getPasswordAuthentication method
         protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(fromEmail, password);
         }
     };
     Session session = Session.getInstance(props, auth);

     EmailUtil.prepareEmail(session, toEmail,"This is your confirmation code:", code);
 }

}
