package com.luv2code.demoClass.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api123")
public class TestController2 {
  
       public TestController2() {
    	   
       }
    
       @GetMapping
       public String getString() {
           return "Hello World0";
       }
       
       @GetMapping("/154")
       public String getString1() {
           return "Hello World1";
       }

}
