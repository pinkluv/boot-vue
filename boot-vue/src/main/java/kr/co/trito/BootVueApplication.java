package kr.co.trito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootVueApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BootVueApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {		
		return builder.sources(BootVueApplication.class);
	}			
}
