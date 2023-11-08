package com.example.demo6;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSession;
import java.util.Properties;




public class Email2 {

    public static void sendEmail(String message,String subject,String to,String from) throws MessagingException {
        //variable for gmail host
        String host="smtp.gmail.com";

        //get the system properties

        Properties properties=System.getProperties();

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465"); // For SSL
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");


        //get the session object
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("plantpalcommunity@gmail.com","npvu uybc ohix qbko");
            }
        });
        session.setDebug(true);
        //compose message
        MimeMessage m=new MimeMessage(session);

        try
        {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
