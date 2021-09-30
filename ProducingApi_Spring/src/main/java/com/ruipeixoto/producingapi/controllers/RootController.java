package com.ruipeixoto.producingapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping
    @ResponseBody()
    public String helloWorld(){
        return "<h1>Hello World</h1>";
    }
}
