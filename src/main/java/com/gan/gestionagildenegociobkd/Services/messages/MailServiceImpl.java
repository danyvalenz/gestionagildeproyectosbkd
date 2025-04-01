package com.gan.gestionagildenegociobkd.Services.messages;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;


@Component
public class MailServiceImpl implements MailService {

    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);


    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFromUserName;


    @Override
    public void sendMail(String toEmail, String subject, String body) {

        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
            messageHelper.setSubject(subject);
            messageHelper.setText(body, true);
            messageHelper.setFrom(mailFromUserName);
            messageHelper.setTo(toEmail);
            mailSender.send(message);


        }catch (MessagingException exception){
            log.error("ocurrion un error al enviar el correo {}",exception);
        }

    }
}
