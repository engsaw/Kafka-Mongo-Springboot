package com.example.kafka;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("messages")
@Data
public class Message {

    @Id
    private String id;
    private String message;


    public Message(String message) {
        super();
        this.message = message;

    }
}
