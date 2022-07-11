package com.vacc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService{

    @Autowired
    private JavaMailSender javaMailSender;
    //wnrkrxbhsucgzhoh

//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }

    final String username = "xmlmauf@gmail.com";
    final String password = "zhuybtutzjgrftsb";


    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
        System.out.println("Email sent...");
    }

    public void sendMailWithAttachment(String to, String subject, String body,  ByteArrayDataSource ds)
    {
        MimeMessagePreparator preparator = new MimeMessagePreparator()
        {
            public void prepare(MimeMessage mimeMessage) throws Exception
            {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                mimeMessage.setFrom(new InternetAddress(username));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(body);
                MimeMultipart mimeMultipart = new MimeMultipart();
                MimeBodyPart attachment = new MimeBodyPart();
                attachment.setDataHandler(new DataHandler(ds));
                attachment.setFileName("Interesovanje.pdf");
                mimeMultipart.addBodyPart(attachment);
                mimeMessage.setContent(mimeMultipart);
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            }
        };

        try {
            javaMailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
    public void sendMailForSaglasnost(String email, Date datumVakcinisanja) throws Exception {
        try
        {
            Thread t = new Thread(() -> sendEmail(email,"Vakcinisanje protiv COVID-19",interesovanjeMail(datumVakcinisanja)));
            t.start();
        }
        catch(Exception e) {
            throw new Exception();
        }
    }
    public String interesovanjeMail(Date datumVakcinisanja){
        String body = "Postovani,\n Saljemo vam mail u vezi vaseg interesovanja za vakcinaciju. " +
                "Vas termin je " + datumVakcinisanja + ". Molimo vas da popunite dokument o saglasnosti pre zadatog termina kako bi ste mogli da izvrsite vakcinisanje.\n " +
                "Dokument saglasnosti mozete popuniti na sledecem linku: http://localhost:4200/saglasnost/create";
        return body;
    }

    public void sendZahtevDeclineMail(String email,String reason) throws Exception {
        try
        {
            String body = "Vas zahtev za sertifikat je odbijen\n Razlog:" + reason;
            Thread t = new Thread(() -> sendEmail(email,"Odbijen zahtev za sertifikat",body));
            t.start();
        }
        catch(Exception e) {
            throw new Exception();
        }
    }

}
