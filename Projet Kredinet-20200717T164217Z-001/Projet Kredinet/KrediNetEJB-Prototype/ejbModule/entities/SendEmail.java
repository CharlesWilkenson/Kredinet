package entities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import javax.management.RuntimeErrorException;

public class SendEmail {
	static String emailFrom="";
	 final static String username="";
	 final static String password="";
	private static String idSession=id();
	 
	 
	 public static  void sendEmail(String codeCompte,String emailTo){
		   String sujet="confirmation";  
		   String message="Votre code secret";


		 	
		 	Properties prop=new Properties();
		 	prop.put("mail.smtp.host","smtp.gmail.com" );
		 	prop.put("mail.smtp.auth","true");
		 	prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.starttls.enable","true");
		 	prop.put("mail.smtp.debug", "true");
		 	//prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLServerSocketFactory");
		 	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		 	
		 	prop.put("mail.smtp.socketFactory.port","587");
		 	prop.put("mail.smtp.socketFactory.fallback", "false");
		 	
		 	
		 	Session session=Session.getInstance(prop,new javax.mail.Authenticator(){
		 	protected PasswordAuthentication getPasswordAuthentication(){
		 		return new PasswordAuthentication(username,password);
		 	}
		 		
		 	});

		 	try {
		 		Message mailMessage=new MimeMessage(session);
		 		mailMessage.setFrom(new InternetAddress(emailFrom));
		 		mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
		 	
		 	mailMessage.setSubject(sujet);
		 mailMessage.setText(message+codeCompte);
		 Transport.send(mailMessage);
		 	} catch (MessagingException e) {
		 		throw new RuntimeException(e);
		 	}

		 	
		 	
		 }

public static  void emailConf (String emailTo) {

  String sujet="configuration";  
  String message="Cliquez pour configurer votre compte  ";


	
	Properties prop=new Properties();
	prop.put("mail.smtp.host","smtp.gmail.com");
	prop.put("mail.smtp.auth","true");
	prop.put("mail.smtp.port", "587");
	prop.put("mail.smtp.starttls.enable","true");
 	prop.put("mail.smtp.debug", "true");
//	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.dSSLServerSocketFactory");
	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	
	prop.put("mail.smtp.socketFactory.port","587");
	prop.put("mail.smtp.socketFactory.fallback", "587");
	
	
	Session session=Session.getInstance(prop,new javax.mail.Authenticator(){
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(username,password);
	}
		
	});

	try {
		Message mailMessage=new MimeMessage(session);
		mailMessage.setFrom(new InternetAddress(emailFrom));
		mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
	
	mailMessage.setSubject(sujet);
mailMessage.setSentDate(new java.util.Date());

// Appel de la fonction qui construit le contenu HTML
 try {
	buildMessage("Contenu du fichier", mailMessage,emailTo);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Transport.send(mailMessage);
	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}

	
	
}




public static void buildMessage(String contenu, Message msg,String emailTo) throws MessagingException, IOException {
String cliquer="Cliquer";
  String sujet = msg.getSubject();
  StringBuilder sb = new StringBuilder();
sb.append("<head>");
  sb.append("<title>");
  sb.append(sujet + "");
  sb.append("</title>");
  sb.append("</head>");
  

  String pattern = "yyyy-mm-dd hh:mm:ss";
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
  String date1 = simpleDateFormat.format(new Date());
  
  String url="<a href=http://localhost:8080/KrediNetWebDesign/faces/static/CompteProfil.xhtml?";
  String relativeURL="email="+emailTo+"&id="+idSession+"&date="+date1+">";

  String absoluteUL=url+relativeURL;
  sb.append("<body>");
  sb.append("<H1>" + sujet + "</H1>" + "");
  sb.append(absoluteUL +cliquer+ "</a>");
  sb.append(contenu);
  sb.append("");

  sb.append("</body>");
  sb.append("</html>");

  msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));
}



public static  String id(){
	Random rd=new Random();

String id=String.format("%s-%s-%s-%s-%s", rd.nextInt(9999), 
		rd.nextInt(9999), rd.nextInt(9999), rd.nextInt(9999), rd.nextInt(9999));
return	id;
}

}

