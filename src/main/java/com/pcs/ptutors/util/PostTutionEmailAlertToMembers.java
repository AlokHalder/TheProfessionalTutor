/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class PostTutionEmailAlertToMembers {
         private static final String EMAIL_SUBJECT = " Alert : New Tution Posted to The Professional Tutors !";
         public void sendPostTutionAlertEmail(String studentId,String studentName ,String tutionTitle,String tutionSubject,String tutionSegment) {
         Transport transport = null;

         try {
             PopulateMembersEmailAddress populateMembersEmailAddress = new PopulateMembersEmailAddress();
             List<String> listOfEmailAddress =  populateMembersEmailAddress.populateMembersEmailAddress();            

             InternetAddress[] addressTo = new InternetAddress[listOfEmailAddress.size()];
             for(int i=0;i<listOfEmailAddress.size();i++ ){
                 addressTo[i] = new InternetAddress(listOfEmailAddress.get(i));
             }

            Properties props = System.getProperties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "relay-hosting.secureserver.net");

            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.user", "admin@theprofessionaltutors.com");
            props.setProperty("mail.password", "PTutor12");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject(EMAIL_SUBJECT);
            message.setFrom(new InternetAddress("admin@theprofessionaltutors.com"));
            message.setRecipients(Message.RecipientType.TO, addressTo);
            message.setRecipient(Message.RecipientType.CC, new InternetAddress("helpdesk@theprofessionaltutors.com"));
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress("alokhalder@gmail.com"));

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();



            String content = "<html><head><title>"
                    + message.getSubject()
                    + "</title></head><body><h1>"
                    + message.getSubject()
                    + "</h1><p> Dear Members ,"+ " </p>"
                    + "<p> We are pleased to announced that following tution requirement has been posted to www.theprofessionaltutors.com </p>"
                    + "<p> Please visit/contact helpdesk to get contact details of this tution requirement urgently" + "</p>"
                    + "<p> <b>" + " Posted Tution Details :"+ "<b></p>"
                    + "<p>" + "<b> Student Name :</b> " + studentName + " </p>"
                    + "<p>" + " <b>Student Id :</b> " + studentId + "</p>"
                    + "<p>" + " <b> Tution Title: </b>" + tutionTitle + " </p>"
                    + "<p>" + " <b>Tution Subject : </b>" + tutionSubject + " </p>"
                    + "<p>" + "<b> Tution Class/Segment :</b>" + tutionSegment + " </p>"
                    + "<p><b>"+ "Getting Help: " + "</b></p>"
                    + "<p>" + "If you have a question or need assistance, please contact The Professional Tutors Help Desk at helpdesk@theprofessionaltutors.com or +919748556776" +"</p>"
                    + "<p><b>"+ "Referral : " + "<b></p>"
                    + "<p>"+ " Do not forget to refer your family ,friends , colleagues and earned 50% referral bonus for each referral to new Tutors , Student , any advertisement  to The Professional Tutors " + "</p>"
                    + "<p>All the Best</p>"
                    + "<p>The Professional Tutors</p>"
                    + "<p>Helpdesk : helpdesk@theprofessionaltutors.com</p>"
                    + "<p>Mobile:919748556776</p>"
                    + "</body></html>";
          

            //  String content  = goDaddySubjectContent(message,membershipId,senderName, sendTo ,userName,password);
            messageBodyPart.setContent(content, "text/html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            transport.connect("relay-hosting.secureserver.net", "xxxxxxx@xxx.com", "password");
            // setHTMLContent(message,membershipId,senderName, sendTo,userName,password);
            message.saveChanges(); // don't forget this
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            System.out.println("Mail Sent  ");

        } catch (Exception e) {
            System.out.println("Message : " + e.getMessage());
            e.printStackTrace();
        }

        }

 
    
}
