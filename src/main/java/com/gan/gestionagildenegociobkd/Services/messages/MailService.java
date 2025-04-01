package com.gan.gestionagildenegociobkd.Services.messages;

@FunctionalInterface
public interface MailService {
    void sendMail(String toEmail, String subject, String body);
}
