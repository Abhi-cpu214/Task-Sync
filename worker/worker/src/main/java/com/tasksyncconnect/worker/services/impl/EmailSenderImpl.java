package com.tasksyncconnect.worker.services.impl;

import com.tasksyncconnect.worker.dtos.EmailDTO;
import com.tasksyncconnect.worker.services.EmailSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:application.yml")
public class EmailSenderImpl implements EmailSender {

    @Qualifier(value = "JavaMailSender")
    private final JavaMailSender javaMailSender;

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void send(EmailDTO emailDTO) {
        SimpleMailMessage mail = new SimpleMailMessage();
        try {
            mail.setFrom(fromEmail);
            mail.setTo(emailDTO.getEmail());
            mail.setSubject(emailDTO.getSubject());
            mail.setText(emailDTO.getBody());

            javaMailSender.send(mail);
        } catch (Exception e) {
            throw new RuntimeException("Error while sending Mail :: {}" + e.getMessage());
        }
    }
}
