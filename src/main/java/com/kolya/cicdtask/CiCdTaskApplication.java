package com.kolya.cicdtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CiCdTaskApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CiCdTaskApplication.class, args);
	}
}
