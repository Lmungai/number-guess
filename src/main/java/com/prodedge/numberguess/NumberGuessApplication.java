package com.prodedge.numberguess;

import com.prodedge.numberguess.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class NumberGuessApplication {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(NumberGuessApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NumberGuessApplication.class, args);
		log.info("Guess the number game");

		// create context (container)
		ConfigurableApplicationContext context
				= new AnnotationConfigApplicationContext(GameConfig.class);

		// close context (container)
		context.close();
	}

}
