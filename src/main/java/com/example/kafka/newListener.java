package com.example.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.MessageListener;

public class newListener implements MessageListener {
    @Override
    public void onMessage(Object data, Consumer consumer) {
        MessageListener.super.onMessage(data, consumer);

    }

    @Override
    public void onMessage(Object o) {

    }
}
