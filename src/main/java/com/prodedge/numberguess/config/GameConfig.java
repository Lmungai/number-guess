package com.prodedge.numberguess.config;

import com.prodedge.numberguess.classes.GuessCount;
import com.prodedge.numberguess.classes.MaxNumber;
import com.prodedge.numberguess.classes.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.prodedge")
@PropertySource("classpath:application.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.minNumber}")
    private int minNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
