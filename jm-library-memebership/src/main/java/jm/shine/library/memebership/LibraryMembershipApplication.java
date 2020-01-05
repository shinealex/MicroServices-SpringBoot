package jm.shine.library.memebership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LibraryMembershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMembershipApplication.class, args);
	}

}
