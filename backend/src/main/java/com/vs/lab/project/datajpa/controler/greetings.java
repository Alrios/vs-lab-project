package com.vs.lab.project.datajpa.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetings {

    
    @GetMapping(value = "/greeting")
    String helloWorld(){
        return new String("Hello fellow human");
    }
}