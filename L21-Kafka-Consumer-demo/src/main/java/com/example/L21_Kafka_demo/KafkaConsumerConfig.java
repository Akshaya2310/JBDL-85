package com.example.L21_Kafka_demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Java;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "jbdlpar2rep2", groupId = "app1")
    public void consumeData(Object payload){
        String data = (String) ((ConsumerRecord) payload).value();
        LOGGER.info("Data Consuming payload: {}",payload);
        LOGGER.info("Data Consuming Value: {}",data);
    }

    @KafkaListener(topics = "EmailToSend", groupId = "email")
    public void emailToSend(Object payload) throws JsonProcessingException {
        String jsonValue = (String) ((ConsumerRecord)payload).value();
        EmailRequest emailRequest = objectMapper.readValue(jsonValue,EmailRequest.class);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("sk.email.service@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        javaMailSender.send(simpleMailMessage);
        LOGGER.info("Email sent to: {}",emailRequest.getToEmail());
    }


}
