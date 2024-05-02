package com.four_bro.deliverium.service;

import com.four_bro.deliverium.model.EmailModel;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String sender;

  public String sendSimpleMail(EmailModel details) {
    // Try block to check for exceptions
    try {
      // Creating a simple mail message
      SimpleMailMessage mailMessage = new SimpleMailMessage();

      // Setting up necessary details
      mailMessage.setFrom(sender);
      mailMessage.setTo(details.getRecipient());
      mailMessage.setText(details.getMsgBody());
      mailMessage.setSubject(details.getSubject());

      // Sending the mail
      javaMailSender.send(mailMessage);
      return "Mail Sent Successfully...";
    } catch (Exception e) { // Catch block to handle the exceptions
      return "Error while Sending Mail";
    }
  }

  // Method 2
  // To send an email with attachment
  public String sendMailWithAttachment(EmailModel details) {
    // Creating a mime message
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;

    try {
      // Setting multipart as true for attachments to
      // be send
      mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
      mimeMessageHelper.setFrom(sender);
      mimeMessageHelper.setTo(details.getRecipient());
      mimeMessageHelper.setText(details.getMsgBody());
      mimeMessageHelper.setSubject(details.getSubject());

      // Adding the attachment
      FileSystemResource file = new FileSystemResource(
        new File(details.getAttachment())
      );

      mimeMessageHelper.addAttachment(file.getFilename(), file);

      // Sending the mail
      javaMailSender.send(mimeMessage);
      return "Mail sent Successfully";
    } catch (MessagingException e) { // Catch block to handle MessagingException
      // Display message when exception occurred
      return "Error while sending mail!!!";
    }
  }
}
