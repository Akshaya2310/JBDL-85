package com.example.L09_Logging_MVC_Annotations_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example","com.gfg"})
public class L09LoggingMvcAnnotationsDemoApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(L09LoggingMvcAnnotationsDemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(L09LoggingMvcAnnotationsDemoApplication.class, args);
		LOGGER.error("Logging error level");
		LOGGER.warn("Logging warn level");
		LOGGER.info("Logging Info level");
		LOGGER.debug("Logging debug level");
		LOGGER.trace("Logging trace level");
	}

}
