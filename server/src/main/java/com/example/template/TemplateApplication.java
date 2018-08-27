package com.example.template;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateApplication {

	@PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-4"));   // It will set UTC timezone
        System.out.println("Spring boot application running in UTC timezone :"+new Date());   // It will print UTC timezone
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}
}
