package com.mindcraft.servicediscoverydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //this make the server the as the discovery 
public class ServiceDiscoveryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryDemoApplication.class, args);
	}

}
