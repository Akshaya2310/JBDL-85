package com.example.L21_Kafka_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/push")
    ResponseEntity<String> pushDataToKafka(@RequestParam String topic, @RequestParam String data) throws ExecutionException, InterruptedException {
        Future future = kafkaTemplate.send(topic,data,data);
        LOGGER.info("Payload pushed to kafka : {}",future.get());
        return ResponseEntity.ok("Data pushed");
    }


    @PostMapping("/sendEmail")
    ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("sk.email.service@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        javaMailSender.send(simpleMailMessage);
        return ResponseEntity.ok("Email Sent");

    }


    @PostMapping("/sendEmailAsync")
    ResponseEntity<String> sendEmailAsync(@RequestBody EmailRequest emailRequest) throws ExecutionException, InterruptedException {
        Future future = kafkaTemplate.send("EmailToSend",emailRequest.getToEmail(),emailRequest);
        LOGGER.info("Payload pushed to kafka : {}",future.get());
        return ResponseEntity.ok("Pushed to kafka");

    }

}
