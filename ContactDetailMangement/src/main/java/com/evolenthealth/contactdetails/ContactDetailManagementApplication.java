package com.evolenthealth.contactdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ContactDetailManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactDetailManagementApplication.class, args);
	}

}
