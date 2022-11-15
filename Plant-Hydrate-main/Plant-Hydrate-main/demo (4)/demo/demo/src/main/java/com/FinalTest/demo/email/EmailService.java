package com.FinalTest.demo.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author llove
 */
@Service
public class EmailService {

    /**
     * Connects to smtp and submits email to user
     *
     * @param subject
     * @param message
     * @param toEmail
     * @return true if email connects and sends
     */
    public boolean sendEmail(String subject, String message, String toEmail) {

        boolean emailCheck = false;

        String from = "planthydrate@gmail.com";
        String host = "smtp.gmail.com";

        //connects to simple mail transfer protocol
        Properties properties = System.getProperties();
        System.out.println("Properties " + properties);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //verifies gmail access
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("planthydrate@gmail.com", "qzxspgnjjvvqjvgz");
            }
        });
        session.setDebug(true);

        //creates MimeMessage obeject and submits email
        MimeMessage m = new MimeMessage(session);
        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            m.setSubject(subject);
            m.setContent(message, "text/html");

            Transport.send(m);
            emailCheck = true;
        } catch (MessagingException e) {
        }
        return emailCheck;
    }
}
