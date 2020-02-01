/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

/**
 *
 * @author ibm
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
public class MainUtil {private static final String SMTP_HOST_NAME = "gmail-smtp.l.google.com";

	private static final String SMTP_AUTH_USER = "from@gmail.com";

	private static final String SMTP_AUTH_PWD = "password";

	private static final String emailMsgTxt = "Please visit my project at ";

	private static final String emailSubjectTxt = "Order Confirmation Subject";

	private static final String emailFromAddress = "alokhalder@gmail.com";

	// Add List of Email address to who email needs to be sent to
	private static final String[] emailList = { "alokhalder@gmail.com" };

	public static void main(String args[]) throws Exception {
		MainUtil smtpMailSender = new MainUtil();
		smtpMailSender.postMail(emailList, emailSubjectTxt, emailMsgTxt,
				emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void postMail(String recipients[], String subject, String message,
			String from) throws MessagingException {
		boolean debug = false;
		java.security.Security
				.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		//Set the host smtp address
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		//props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
                props.put("mail.smtp.port", "587");
		//props.put("mail.smtp.auth", "true");
                //props.put("mail.smtp.starttls.required", "true"); // added this line

		// auth = new SMTPAuthenticator();

		// session = Session.getDefaultInstance(props, auth);

		//session.setDebug(debug);

                //Transport transport = session.getTransport("smtps");

                Session session = Session.getInstance(props);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication when the SMTP
	 * server requires it.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}



}


