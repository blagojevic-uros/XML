package com.vacc.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService{
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String to, String body, String topic) {
        System.out.println("Sending email...");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("xmlmladduf@gmail.com");
        msg.setTo(to);
        msg.setSubject(topic);
        msg.setText(body);
        javaMailSender.send(msg);
        System.out.println("Email sent...");
    }

    public void sendMailForSaglasnost(String email, Date datumVakcinisanja) throws Exception {
        try
        {
            Thread t = new Thread(() -> sendEmail(email,interesovanjeMail(datumVakcinisanja),"Vakcinisanje protiv COVID-19"));
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
