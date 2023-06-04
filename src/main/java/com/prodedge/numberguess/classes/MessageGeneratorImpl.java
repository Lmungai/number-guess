package com.prodedge.numberguess.classes;

import com.prodedge.numberguess.interfaces.Game;
import com.prodedge.numberguess.interfaces.MessageGenerator;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.text.MessageFormat;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @Override
    public String getMainMessage() {
        return String.format("Number is between %s and %s. Can you guess it?", game.getSmallest(), game.getBiggest());
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()) {
            return MessageFormat.format("You guessed it! The number was {0}", game.getNumber());
        } else if(game.isGameLost()) {
            return String.format("You lost. The number was %s", game.getNumber());
        } else if(!game.isValidNumberRange()) {
            return "Invalid number Range!";
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber())
                direction = "Higher";

            return MessageFormat.format("{0}! You have {1} guesses left", direction, game.getRemainingGuesses());
        }
    }

    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }
}
