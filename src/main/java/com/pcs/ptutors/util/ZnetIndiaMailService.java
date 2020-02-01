/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.util;

import com.pcs.ptutors.exception.ProfessionalTutorsException;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author ALOK
 */
public class ZnetIndiaMailService {

    public String sendEmail(String senderName, String membershipId, String sendTo, String userName, String password)throws ProfessionalTutorsException, Exception {
             System.out.println(" Control is inside email....");
             String emailMessage = "";
           Transport transport = null;

        try {
            Properties props = System.getProperties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "mail.ptutors.org");
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.user", "helpdesk@ptutors.org");
            props.setProperty("mail.password", "Ptutor12");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject("Welcome to The Professional Tutors Family !");
            message.setFrom(new InternetAddress("helpdesk@ptutors.org"));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            //message.setRecipient(Message.RecipientType.CC, new InternetAddress("admin@theprofessionaltutors.com"));
           // message.setRecipient(Message.RecipientType.BCC, new InternetAddress("alokhalder@gmail.com"));

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();


             String content = "<html><head><title>"
                    + message.getSubject()
                    + "</title></head><body><h4>"
                    + message.getSubject()
                    + "</h4><p> Dear " + senderName + " , </p>"
                    + "<p>Thank you for signing up with us. Your new account has been setup and you can now login to sign-up area using the details below. </p>"
                    + "<p>Membership Id: " + membershipId + " </p>"
                    + "<p>Email Address: " + sendTo + "</p>"
                    + "<p>User Id: " + userName + " </p>"
                    + "<p>Password: " + password + " </p>"
                    + "<p>To login, visit http://www.ptutors.org </p>"
                    + "<p>Assuring you of our best, fast & effective education services </p>"
                    + "<p>&nbsp;</p>"
                    + "<p>Warm Regards</p>"
                    + "<p>The Professional Tutors</p>"
                    + "<p>Helpdesk : helpdesk@ptutors.org</p>"
                    + "<p>Land Phone : (033) 65400826 Mobile:919748556776</p>"
                    + "</body></html>";

          //  String content  = goDaddySubjectContent(message,membershipId,senderName, sendTo ,userName,password);
            messageBodyPart.setContent(content, "text/html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            transport.connect("mail.ptutors.org", "helpdesk@ptutors.org", "Ptutor12");
           // setHTMLContent(message,membershipId,senderName, sendTo,userName,password);
            message.saveChanges(); // don't forget this
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.BCC));

            System.out.println("Mail Sent  ");


        }catch(MessagingException  messagingException){
           emailMessage =  messagingException.getMessage();
        }
        catch (Exception e) {
            emailMessage =  e.getMessage();
           
            e.printStackTrace();
        }
    return emailMessage;
    }
}
