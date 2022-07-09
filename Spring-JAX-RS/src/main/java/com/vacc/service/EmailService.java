package com.vacc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public void sendMailForSaglasnost(String email, Date datumVakcinisanja) throws Exception {
        try
        {
            Thread t = new Thread(() -> sendEmail(email,"Vakcinisanje protiv COVID-19",interesovanjeMail(datumVakcinisanja),));
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

}
