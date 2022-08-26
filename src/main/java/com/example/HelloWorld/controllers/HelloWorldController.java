package com.example.HelloWorld.controllers;

import com.example.HelloWorld.exceptions.NoSuchElementFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class HelloWorldController {

    private static final Set<String> allowedNames = Set.of("Yura", "Yurii");

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping(value = "/", params = "name")
    public String helloWorld(String name) {
        if(!allowedNames.contains(name)) {
            throw new NoSuchElementFoundException("name: " + name + " not allowed");
        }
        return "Hello " + name + "!";
    }
}
