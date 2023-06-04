package com.prodedge.numberguess;

import com.prodedge.numberguess.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class NumberGuessApplication {

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
