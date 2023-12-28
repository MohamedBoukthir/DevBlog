package com.mohamed.blog.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

     @GetMapping
    public String Home(){
         return "Hello World";
     }

}
