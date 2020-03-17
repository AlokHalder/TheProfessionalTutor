package com.pcs.ptutors.test;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

// Send a simple, single part, text/plain e-mail
//http://www.vipan.com/htdocs/javamail.html
// Very Usefull link regarding Java Mail

public class TestEmail {

    private static final String SMTP_AUTH_USER = "admin@theprofessionaltutors.com";
  //  private static final String SMTP_AUTH_PWD = "Alok123";
    private static final String SMTP_AUTH_PWD = "PTutor12";

    public static void main(String[] args) {

        System.out.println(" Hiss");
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        String to = "alokhalder@gmail.com";
       //String to = "alokhalder@yahoo.com";

        String from = "admin@theprofessionaltutors.com";
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        String host = "smtp.gmail.com";

        // Create properties, get Session
        Properties props = new Properties();

        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        // To see what is going on behind the scene
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);


        //Session session = Session.getInstance(props);

        try {
            // Instantiatee a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Test E-Mail through Java");
            msg.setSentDate(new Date());
            msg.setHeader("content-type", "text/html");


            // Set message content
            msg.setText(" <html> <font color='red'>This is a test of sending a "
                    + "plain text e-mail through Java.\n"
                    + "Here is line 2.</font></html>");


            // Send message with authentication!
            Transport tr = session.getTransport("smtp");
            tr.connect(host, SMTP_AUTH_USER, SMTP_AUTH_PWD);
            msg.saveChanges(); // don't forget this
            tr.sendMessage(msg, msg.getAllRecipients());
            tr.close();


            //Send the message
            // Transport.send(msg);

        } catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            //mex.printStackTrace();
        }
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}//End of class
