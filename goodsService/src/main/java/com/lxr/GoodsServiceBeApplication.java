package com.lxr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GoodsServiceBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsServiceBeApplication.class, args);
	}
}
