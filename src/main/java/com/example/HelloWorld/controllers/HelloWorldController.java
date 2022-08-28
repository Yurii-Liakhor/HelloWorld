package com.example.HelloWorld.controllers;

import com.example.HelloWorld.exceptions.NoSuchElementFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
public class HelloWorldController {

    private static final Set<String> allowedNames = Set.of("Yura", "Yurii");

    @RequestMapping("/")
    public String helloWorld() {
        log.info("helloWorld()");
        throw new RuntimeException("hello world error");
//        return "Hello World!";
    }

    @RequestMapping("/1")
    public String helloWorld1() {
        log.info("helloWorld1()");
        return "Hello World 1!";
    }

    @RequestMapping("/2")
    public String helloWorld2() {
        log.info("helloWorld2()");
        return "Hello World 2!";
    }

    @RequestMapping(value = "/", params = "name")
    public String helloWorld(String name) {
        if(!allowedNames.contains(name)) {
            throw new NoSuchElementFoundException("name: " + name + " not allowed");
        }
        return "Hello " + name + "!";
    }
}
