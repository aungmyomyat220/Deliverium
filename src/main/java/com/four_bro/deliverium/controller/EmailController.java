package com.four_bro.deliverium.controller;

import com.four_bro.deliverium.model.EmailModel;
import com.four_bro.deliverium.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController
// Class
public class EmailController {

  @Autowired
  private EmailService emailService;

  @PostMapping("/sendMail")
  public String sendMail(@RequestBody EmailModel details) {
    String status = emailService.sendSimpleMail(details);
    return status;
  }

  // Sending email with attachment
  @PostMapping("/sendMailWithAttachment")
  public String sendMailWithAttachment(@RequestBody EmailModel details) {
    String status = emailService.sendMailWithAttachment(details);
    return status;
  }
}
