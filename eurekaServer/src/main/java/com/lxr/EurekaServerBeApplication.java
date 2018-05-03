package com.lxr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaServerBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerBeApplication.class, args);
	}
}
