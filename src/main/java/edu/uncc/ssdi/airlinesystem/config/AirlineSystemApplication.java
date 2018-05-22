package edu.uncc.ssdi.airlinesystem.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.mysql.jdbc.log.Log;

@SpringBootApplication
@ComponentScan(basePackages = "edu.uncc")
public class AirlineSystemApplication extends SpringBootServletInitializer {

	private static Logger LOG = LoggerFactory.getLogger(AirlineSystemApplication.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AirlineSystemApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(AirlineSystemApplication.class, args);
	}
	
}
