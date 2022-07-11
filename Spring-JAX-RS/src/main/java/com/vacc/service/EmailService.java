package com.vacc.service;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.jena.sparql.function.library.leviathan.log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
    public String sendMail(String to, String subject, String body, ByteArrayDataSource ds ) {
        String response;
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            ClassPathResource pdf = new ClassPathResource("static/attachment.pdf");
            ClassPathResource image = new ClassPathResource("static/asbnotebook.png");
            helper.setTo(to);
            helper.setFrom(username);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.addAttachment("interesovanje.pdf", ds);
            javaMailSender.send(message);
            response = "Email has been sent to :" + to;
        } catch (MessagingException e) {
            response = "Email send failure to :" + to;
        }
        return response;
    }
//    public void sendMailWithAttachment()
//    {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(username);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.addAttachment("interesovanje.pdf", (InputStreamSource) ds, "application/pdf");
//        } catch (Exception e) {
//        }
//        javaMailSender.send(message);
//    }
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
