package com.lxr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayBeApplication.class, args);
	}
}
