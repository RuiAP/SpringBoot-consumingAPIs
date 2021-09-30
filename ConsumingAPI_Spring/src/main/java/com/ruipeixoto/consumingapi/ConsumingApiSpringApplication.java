package com.ruipeixoto.consumingapi;

import com.ruipeixoto.consumingapi.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class ConsumingApiSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumingApiSpringApplication.class, args);

        try{

        sleep(3000);
        }catch (Exception e){

        }
        new MainController().fetch();
    }



}
