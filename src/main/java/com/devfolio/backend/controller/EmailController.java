package com.devfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.devfolio.backend.dto.ContactRequest;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public String sendEmail(@RequestBody ContactRequest request) {

        try {

            SimpleMailMessage message = new SimpleMailMessage();

            // Receiver
            message.setTo("dhanshribhosale11@gmail.com");

            // Sender email (visitor)
            message.setReplyTo(request.getEmail());

            // Subject
            message.setSubject("Portfolio Contact : " + request.getSubject());

            // Body
            message.setText(
                    "New Portfolio Contact Request\n\n"
                    + "Name : " + request.getName() + "\n\n"
                    + "Email : " + request.getEmail() + "\n\n"
                    + "Subject : " + request.getSubject() + "\n\n"
                    + "Message :\n"
                    + request.getMessage()
            );

            mailSender.send(message);

            return "Message Sent Successfully";

        }catch (Exception e) {

    e.printStackTrace();

    return e.getMessage();
}
    }

}
