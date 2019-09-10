package com.dhyanpraveshika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dhyanpraveshika.controller","com.dhyanpraveshika.database","com.dhyanpraveshika.dto","com.dhyanpraveshika.service"})
public class DhyanPraveshikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DhyanPraveshikaApplication.class, args);
	}

}
