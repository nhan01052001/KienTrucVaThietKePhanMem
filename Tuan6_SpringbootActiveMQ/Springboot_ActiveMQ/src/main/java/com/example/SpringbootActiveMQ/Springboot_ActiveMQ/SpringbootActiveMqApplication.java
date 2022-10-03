package com.example.SpringbootActiveMQ.Springboot_ActiveMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringbootActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActiveMqApplication.class, args);
	}

}
