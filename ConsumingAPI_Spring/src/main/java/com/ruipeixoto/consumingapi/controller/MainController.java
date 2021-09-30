package com.ruipeixoto.consumingapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruipeixoto.consumingapi.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

//    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    public void fetch() {

        String servicosResourceUrl = "http://producing:8080/students";
        ResponseEntity<String> response = restTemplate.getForEntity(servicosResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info("Received: {}", root.toString());
        logger.info("Received: {}", root.toPrettyString());
        JsonNode name = root.path("name");
        logger.info("Received: {}", name);

        Student[] students = restTemplate.getForObject(servicosResourceUrl, Student[].class);

        logger.info("Received student: {}", students[0]);
    }
}
