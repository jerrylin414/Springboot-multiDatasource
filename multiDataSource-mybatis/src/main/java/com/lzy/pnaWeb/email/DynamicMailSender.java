package com.lzy.pnaWeb.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class DynamicMailSender {
    public static JavaMailSender createGmailSender(String username, String password) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.connectiontimeout", "5000");
//        props.put("mail.smtp.timeout", "5000");
//        props.put("mail.smtp.writetimeout", "5000");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
