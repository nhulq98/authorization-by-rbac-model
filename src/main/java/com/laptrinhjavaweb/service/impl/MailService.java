package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.service.interf.IMailService;
import sun.net.smtp.SmtpClient;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

public class MailService implements IMailService {

    // mail client. send mail with localhost
    @Override
    public void sendMail() {
        String host = "smtp.hcm.vnn.vn";
        String from = "n16dcat035@student.ptithcm.edu.vn";
        String to = "nhule2031998@gmail.com";
        String subject = "WARNING USER CHANGED ROLE";
        String body = "user A changed role set-role of user B at 15:47 PM 10/24/2020";
        try{

            // create object send mail by SMTP protocol. Host is server mail's address
            SmtpClient mailer = new SmtpClient(host);

            // setup send people address
            mailer.from(from);
            mailer.to(to);

            //get flow write data to send mail
            java.io.PrintStream ps = mailer.startMessage();

            // print mail content - title part
            ps.println("From: "+ from);
            ps.println("To: " + to);
            ps.println("subject: " + subject);
            ps.println();

            // print content or mail body part
            ps.println(body);

            //finished process send mail
            mailer.closeServer();
            System.out.println("Mail has been sent");



        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void sendMailForRoleUpdateMethod(String strOldRoleCode, String strUpdateRoleCode, String userNameCurrent, String userNameUpdate) {
        // user add RoleCode
        if(strUpdateRoleCode.length() > strOldRoleCode.length()){
            //===> SEND GMAIL warning!!!
            String[] listRole = strUpdateRoleCode.split(",");
            // create content
            String subjectMail = "WARNING "+ userNameCurrent +" Recently changed ROLE";
            String contentMail = "Dear admin: User <b> "+ userNameCurrent +"</b> Add role <b>"+ listRole[listRole.length - 1] +"</b> for user <b>"+ userNameUpdate +"</b> at <b>"+ new Timestamp(System.currentTimeMillis()) +"</b>";

            IMailService mailService = new MailService();
            try {
                mailService.sendMailWithAPI(subjectMail, contentMail);

            }catch (MessagingException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // User delete RoleCode
        }else if(strUpdateRoleCode.length() < strOldRoleCode.length()){
            //===> SEND GMAIL warning!!!

            // convert to arr .SURPOR: compare every elements
            String[] listOldRole = strOldRoleCode.split(",");
            String[] listUpdateRole = strUpdateRoleCode.split(",");
            String elementDeleted = "";

            // find all element of listUpdateRole in listOldRole. if element not found ==> that element deleted
            for(int i = 0; i < listOldRole.length; i++){

                boolean check = false;// default not exists
                for(int j = 0; j < listUpdateRole.length; j++){
                    if(listOldRole[i].equals(listUpdateRole[j])){
                        check = true;// exists
                    }
                }
                if(check ==false){// not exists==> this was delete element
                    elementDeleted = listOldRole[i];
                    break;
                }
            }

            // create content
            String subjectMail = "WARNING "+ userNameCurrent +" Recently Changed Role!!";
            String contentMail = "Dear admin: User <b> "+ userNameCurrent +"</b> Delete role <b>"+ elementDeleted +"</b> for user <b>"+userNameUpdate+"</b> at <b>"+ new Timestamp(System.currentTimeMillis()) +"</b>";

            IMailService mailService = new MailService();
            try {
                mailService.sendMailWithAPI(subjectMail, contentMail);

            }catch (MessagingException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendMailWithAPI(String subjectMail, String contentMail) throws MessagingException, UnsupportedEncodingException {
        // Create Properties Object store informations need initialization
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");

        // set host
        properties.setProperty("smtp.gmail.com", "lequangnhu");

        // show log Debug
        properties.put("mail.debug", "true");

        // can change port
        //properties.put("mail.smtp.socketFactory.port", "465");

        // create Sesion Object
        Session mailSession = Session.getInstance(properties, null);

        //
        /*
        mail.store.protocol
        mail.transport.protocol
        mail.host
        mail.user
        mail.from
        * */

        // content object
        MimeMessage message = new MimeMessage(mailSession);

        // set Subject Mail
        message.setSubject(subjectMail);

        //set Mail Content
//        message.setText("Dear Custumer, your order, ...");

        // format Content
        message.setContent(contentMail, "text/html");

        // create Address Class to create sender address, receiver address
        Address address = new InternetAddress("mk.pub@cinet.vnnews.com", "heheh");

        // create receiver address
        Address toAddress = new InternetAddress("tranhuucanh223@gmail.com");
        Address ccAddress = new InternetAddress("nhule2031998@gmail.com");

        // assignment address for receiver
        //Message.RecipientType.TO
        message.addRecipients(Message.RecipientType.TO, String.valueOf(toAddress));// address receiver
        message.addRecipients(Message.RecipientType.CC, String.valueOf(ccAddress));// address people need reference

        //set sender address
        Address senderAddress = new InternetAddress("n16dcat035@student.ptithcm.edu.vn", "Nhu Le");
        message.setFrom(senderAddress);

       // Transport class
        // have methods send mail to Mail Server
        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "n16dcat035@student.ptithcm.edu.vn","lequangnhu2031998");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public void redMailWithAPI(){
        // require user choice send protocol and mail store

        // create Message object. this object will store mail information  need send like that: address send people, address recieve people, title, mail content


        // Call Transport.send() or sendMessage() method of Transport object to send mail


    }

    public void sendMailWithAPI2() throws MessagingException {
        // require user choice send protocol and mail store

        // create Message object. this object will store mail information  need send like that: address send people, address recieve people, title, mail content


        // Call Transport.send() or sendMessage() method of Transport object to send mail

        String username = "n16dcat035@student.ptithcm.edu.vn";
        String password = "lequangnhu2031998";
        String recipient = "nhule2031998@gmail.com";

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.from", "myemail@gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.debug", "true");

        Session session = Session.getInstance(props, null);
        MimeMessage msg = new MimeMessage(session);

        msg.setRecipients(Message.RecipientType.TO, recipient);
        msg.setSubject("JavaMail hello world example");
        msg.setSentDate(new Date());
        msg.setText("Hello, world!\n");

        Transport transport = session.getTransport("smtp");

        transport.connect(username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

    }

    public void sendMailWithAPI3() throws MessagingException {
        String to = "nhule2031998@gmail.com";
        String subject = "subject";
        String msg = "email text....";
        final String from = "n16dcat035@student.ptithcm.edu.vn";
        final String password = "lequangnhu2031998";


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        //session.setDebug(true);
        Transport transport = session.getTransport();
        InternetAddress addressFrom = new InternetAddress(from);

        MimeMessage message = new MimeMessage(session);
        message.setSender(addressFrom);
        message.setSubject(subject);
        message.setContent(msg, "text/plain");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        transport.connect();
        Transport.send(message);
        transport.close();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        MailService mailService = new MailService();
        //mailService.sendMailWithAPI();

        // Session Class store information for one session connect
    }
}
