package com.devfolio.backend.controller;

import com.devfolio.backend.entity.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://dev-folio-y8wt.vercel.app"
})
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public String sendEmail(@RequestBody ContactRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();

        // Your Gmail
        message.setTo("dhanshribhosale11@gmail.com");

        message.setSubject("New Portfolio Contact : " + request.getSubject());

        message.setText(
                "Name : " + request.getName()
                        + "\n\nEmail : " + request.getEmail()
                        + "\n\nSubject : " + request.getSubject()
                        + "\n\nMessage :\n\n"
                        + request.getMessage()
        );

        mailSender.send(message);

        return "Message Sent Successfully";
    }
}
