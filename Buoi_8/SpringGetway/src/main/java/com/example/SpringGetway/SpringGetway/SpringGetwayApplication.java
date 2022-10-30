package com.example.SpringGetway.SpringGetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGetwayApplication.class, args);
	}

}
