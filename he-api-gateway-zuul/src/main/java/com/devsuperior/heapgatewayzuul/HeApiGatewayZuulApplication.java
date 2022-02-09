package com.devsuperior.heapgatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class HeApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeApiGatewayZuulApplication.class, args);
	}

}
