package com.abc.reactiveexample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
@RestController
public class MyTestRest {

    @GetMapping(path = "/test")
    public Mono<String> test() {
        return Mono.just("OK").delayElement(Duration.ofMillis(2000));
    }


}
