package verification;

import encryption.AES;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailUtilMulti implements Runnable{


    private  final String ABSOLUTE_PATH = "/Users/leotrimvojvoda/IdeaProjects/LoginForm/src/main/resources/credentials.properties";

    private String toEmail;
    private String body;
    private static Thread threadOne;

    public EmailUtilMulti(String toEmail, String body){
        this.toEmail = toEmail;
        this.body = body;
        threadOne = new Thread();
        threadOne.setName("Email Thread");
    }

    @Override
    public void run() {
        sendEmail(toEmail,body);
    }

    public void start () {
        System.out.println("Starting " +  threadOne.getName() );
        if (threadOne == null) {
            threadOne = new Thread (this, threadOne.getName());
            threadOne.run();
        }else{
            threadOne.run();
        }
    }

    public synchronized void prepareEmail(Session session, String toEmail, String subject, String body){
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
    public  synchronized void sendEmail(String toEmail, String code){

        String email =  null; //requires valid gmail id
        String password = null;

        try{
            FileReader reader=new FileReader(ABSOLUTE_PATH);

            Properties p=new Properties();
            p.load(reader);

            email = p.getProperty("email");
            password = p.getProperty("password");


        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error geting email + password");
        }

        //Encrypted sender information
        // correct password for gmail id


        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        final String EMAIL = AES.decrypt(email);
        final String PASSWORD = AES.decrypt(password);
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.prepareEmail(session, toEmail,"This is your confirmation code:", code);
    }
}
