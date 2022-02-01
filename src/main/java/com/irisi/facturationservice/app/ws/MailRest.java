package com.irisi.facturationservice.app.ws;

import com.irisi.facturationservice.app.dto.MailParameter;
import com.irisi.facturationservice.infra.impl.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
public class MailRest {
    @Autowired
    MailSender mailSender;

    @PostMapping("/sendKafka")
    public void sendMailKafka(@RequestBody MailParameter mailParameter) {
        mailSender.sendKafkaMessage(mailParameter);
    }
}
