package com.luv2code.demoClass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoClassApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoClassApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoClassApplication.class, args);
	}

	@RestController
	class HelloController {
	 
	    @RequestMapping("/hello/{name}")
	    String hello(@PathVariable String name) {
	 
	        return "Hi " + name + " !";
	 
	    }
	}
}
