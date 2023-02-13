package com.starters.ityogurt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"controller","dao","dto","service","serviceimpl"})

@SpringBootApplication
public class ItYogurtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItYogurtApplication.class, args);
	}

}
