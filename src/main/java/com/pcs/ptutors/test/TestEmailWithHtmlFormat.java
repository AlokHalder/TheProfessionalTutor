package com.pcs.ptutors.test;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

// Send a simple, single part, text/plain e-mail
//http://www.vipan.com/htdocs/javamail.html
// Very Usefull link regarding Java Mail

public class TestEmailWithHtmlFormat {

    private static final String SMTP_AUTH_USER = "admin@theprofessionaltutors.com";
  //  private static final String SMTP_AUTH_PWD = "Alok123";
    private static final String SMTP_AUTH_PWD = "PTutor12";

    public static void main(String[] args) {

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
            msg.setSubject("Welcome to The Professional Tutors Family !!");
            msg.setSentDate(new Date());

          //  msg.setHeader("content-type", "text/html");


            // Set message content
         /*   msg.setText(" <html> <font color='red'>This is a test of sending a "
                    + "plain text e-mail through Java.\n"
                    + "Here is line 2.</font></html>");
*/

            // Send message with authentication!
            Transport tr = session.getTransport("smtp");
            tr.connect(host, SMTP_AUTH_USER, SMTP_AUTH_PWD);

            setHTMLContent(msg);

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


    // Set a single part html content.
    // Sending data of any type is similar.
    public static void setHTMLContent(Message msg) throws MessagingException {


         String html = "<html><head><title>"
                    + msg.getSubject()
                    + "</title></head><body><h4>"
                    + msg.getSubject()
                    + "</h4><p> Dear " + "Sir/Madam" + " , </p>"
                    + "<p>Thank you for signing up with us. Your new account has been setup and you can now login to sign-up area using the details below. </p>"
                    + "<p>Membership Id: " + " " + " </p>"
                    + "<p>Email Address: " + " " + "</p>"
                    + "<p>User Id: " + "" + " </p>"
                    + "<p>Password: " + " " + " </p>"
                    + "<p>To login, visit http://www.theprofessionaltutors.com </p>"
                    + "<p>Assuring you of our best, fast & effective education services </p>"
                    + "<p>&nbsp;</p>"
                    + "<p>Warm Regards</p>"
                    + "<p>The Professional Tutors</p>"
                    + "<p>Helpdesk : helpdesk@theprofessionaltutors.com</p>"
                    + "<p>Mobile:919748556776</p>"
                    + "</body></html>";


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
}//End of class
