package com.example.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableMongoRepositories()
public class KafkaListners {

    @Autowired
    MessageRepository messageRepository;


    @KafkaListener(topics = "sheriftopic", groupId = "groupId")
    void sherifListner(String data){

        System.out.println("Recieved to Sherif : " + data);
        messageRepository.save(new Message("Recieved to Sherif : " + data));


    }


    @KafkaListener(topics = "omartopic", groupId = "groupId")
    void omarListner(String data){

        System.out.println("Recieved to Omar : " + data);
        messageRepository.save(new Message("Recieved to Omar : " + data));
    }
}
