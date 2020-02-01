/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

import java.util.Properties;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author ALOK
 */
public class EmailService {


    private static final String SMTP_AUTH_USER = "admin@theprofessionaltutors.com";
    private static final String SMTP_AUTH_PWD = "PTutor12";
    Transport tr = null;

      //  String to = "alokhalder@gmail.com";
      //String to = "sweety_chaudhury@yahoo.com";
        String from = "admin@theprofessionaltutors.com";

    public  void sendEmail(String senderName,String membershipId,String sendTo,String userName,String password) {

        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
      //  String to = "alokhalder@gmail.com";
        //String to = "sweety_chaudhury@yahoo.com";
       // String from = "admin@theprofessionaltutors.com";

        String to = sendTo;
        System.out.println(" Send To ::::: " + to);

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
            msg.setRecipients(Message.RecipientType.TO,address);

          //msg.setRecipients(Message.RecipientType.TO,Message.RecipientType.CC,Message.RecipientType.BCC, address);

            msg.setSubject("Welcome to The Professional Tutors Family !");
            msg.setSentDate(new Date());

           // Send message with authentication!
            tr = session.getTransport("smtp");
            tr.connect(host, SMTP_AUTH_USER, SMTP_AUTH_PWD);
             // Set message content
            setHTMLContent(msg,membershipId,senderName, to,userName,password);
            msg.saveChanges(); // don't forget this
            tr.sendMessage(msg, msg.getAllRecipients());
           


            //Send the message
            // Transport.send(msg);

        } catch (MessagingException mex) {
            System.out.println(" Messaging Exception ::$$$$ "+ mex);
            // Prints all nested (chained) exceptions as well
            //mex.printStackTrace();
        }catch(Exception exception){
            System.out.println(" exception : "+ exception);
        }finally{
            try{
            tr.close();
            }catch (MessagingException mex) {
            System.out.println(" Messaging Exception :: -->"+ mex);
            // Prints all nested (chained) exceptions as well
            //mex.printStackTrace();
            }
        }
    }


    // Set a single part html content.
    // Sending data of any type is similar.
    public static void setHTMLContent(Message msg,String membershipId,String memberName, String to ,String user,String password) throws MessagingException {
   
        String html = "<html><head><title>" +
                        msg.getSubject() 
                        +"</title></head><body><h1>"
                        + msg.getSubject()
                        + "</h1><p> Dear "+ memberName + " , </p>"
                        + "<p>Thank you for signing up with us. Your new account has been setup and you can now login to sign-up area using the details below. </p>"
                        + "<p>Membership Id: "+membershipId+" </p>"
                        + "<p>Email Address: "+ to + "</p>"
                        + "<p>User Id: "+user+" </p>"
                        + "<p>Password: "+password+" </p>"
                        + "<p>To login, visit http://www.theprofessionaltutors.com </p>"
                        + "<p>Assuring you of our best, fast & effective education services </p>"
                        + "<p>&nbsp;</p>"
                        + "<p>Warm Regards</p>"
                        + "<p>The Professional Tutors</p>"
                        + "<p>Helpdesk : helpdesk@theprofessionaltutors.com</p>"
                        + "<p>Mobile:919748556776</p>"
                        +"</body></html>";


        // HTMLDataSource is an inner class
        msg.setDataHandler(new DataHandler(new HTMLDataSource(html)));
    }

  /*
     * Inner class to act as a JAF datasource to send HTML e-mail content
     */
    static class HTMLDataSource implements DataSource {
        private String html;

        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        // Return html string in an InputStream.
        // A new stream must be returned each time.
        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("Null HTML");
            return new ByteArrayInputStream(html.getBytes());
        }

        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        public String getContentType() {
            return "text/html";
        }

        public String getName() {
            return "JAF text/html dataSource to send e-mail only";
        }
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }

}
