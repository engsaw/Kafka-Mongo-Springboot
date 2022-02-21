package com.example.kafka.controller;

import com.example.kafka.MockData;
import com.example.kafka.PersonRepository;
import com.example.kafka.beans.Person;
import com.example.kafka.beans.SherifAddress;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("kafka")
public class ProducerController {

    @Autowired
    PersonRepository personRepository;

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/post/omar/{message}")
    public String postToOmar(@PathVariable("message") String message) {

        kafkaTemplate.send("omartopic",message);
        return message;
    }

    @PostMapping(value = "/post/sherif/{message}")
    public String postToSherif(@PathVariable("message") String message) {

        kafkaTemplate.send("sheriftopic",message);
        return message;
    }

    @PostMapping(value = "/post/persons/")
    public String postPeople() throws IOException {

        SherifAddress myAddress = new SherifAddress("Butt","aa","1234");

        Person myPerson = new Person(1,"A","A","A","G",12,myAddress);

       personRepository.saveAll(MockData.getPeople());

        return "done";
    }

    @GetMapping(value = "/post/persons/")
    public List<Person> getPeople() throws IOException {

        List<Person> all = personRepository.findAll();
all.stream().filter(p -> p.getAge()>1).collect(Collectors.toList());

       // all.forEach(System.out::println);
        return all.stream().filter(p -> p.getAge()>1).collect(Collectors.toList());
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
