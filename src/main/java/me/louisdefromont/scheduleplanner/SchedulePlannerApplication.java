package me.louisdefromont.scheduleplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("me.louisdefromont")
@ComponentScan(basePackages = { "me.louisdefromont" })
@EntityScan("me.louisdefromont")
public class SchedulePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulePlannerApplication.class, args);
	}

}
