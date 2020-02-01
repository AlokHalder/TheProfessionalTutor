<%@page import="java.util.*" %>
<%@page import="java.io.*"%>
<%@page import="javax.mail.*"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="javax.activation.*"%>

<%
try
{
Properties props = System.getProperties();
props.setProperty("mail.transport.protocol", "smtp");
props.setProperty("mail.host", "relay-hosting.secureserver.net");

props.put("mail.smtp.auth", "true");
props.setProperty("mail.user", "admin@theprofessionaltutors.com");
props.setProperty("mail.password", "PTutor12");

Session mailSession = Session.getDefaultInstance(props, null);
mailSession.setDebug(true);
Transport transport = mailSession.getTransport("smtp");
MimeMessage message = new MimeMessage(mailSession);
message.setSentDate(new java.util.Date());
message.setSubject("Hi Test");
message.setFrom(new InternetAddress("admin@theprofessionaltutors.com"));
message.setRecipient(Message.RecipientType.TO, new InternetAddress("alokhalder@gmail.com"));
MimeMultipart multipart = new MimeMultipart("related");
// first part (the html)
BodyPart messageBodyPart = new MimeBodyPart();
messageBodyPart.setContent("Hi rsgdsdgdfgsdfg", "text/html");

// add it
multipart.addBodyPart(messageBodyPart);
// put everything together
message.setContent(multipart);

transport.connect("relay-hosting.secureserver.net", "xxxxxxx@xxx.com","password");
transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
transport.close();
out.println("Mail Sent  ");

}
catch (Exception e) {
out.println("Message : " + e.getMessage());
e.printStackTrace();
}
%>
