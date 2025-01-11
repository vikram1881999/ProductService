package com.vikram.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{count}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("count") int count ) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < count; i++ ) {
            sb.append("Hello ").append(name).append("</br>");
        }
        return sb.toString();
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "bye";
    }
}
