package com.irisi.facturationservice.infra.impl;

import com.irisi.facturationservice.app.dto.MailParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class MailSender {

    @Autowired
    private KafkaTemplate<String, MailParameter> kafkaTemplate;

    @Value("${kafka.topic.mail}")
    String topicName;

    public void sendKafkaMessage(MailParameter mailParameter) {


        ListenableFuture<SendResult<String, MailParameter>> future =
                kafkaTemplate.send(topicName, mailParameter);

        future.addCallback(new ListenableFutureCallback<SendResult<String, MailParameter>>() {

            @Override
            public void onSuccess(SendResult<String, MailParameter> result) {
                System.out.println("Sent message=[" + mailParameter.getSubject() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + mailParameter.getSubject() + "] due to : " + ex.getMessage());
            }
        });
    }
}
