package edu.dzioba;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class GameSessionManager {
    Supplier<String> userInputProvider;
    private Consumer<String> output;

    public GameSessionManager(Supplier<String> userInputProvider, Consumer<String> output) {
        this.userInputProvider = userInputProvider;
        this.output = output;
    }

    public Player getWinner() { // TODO
        return new Player();
    }

    public boolean isEndOfGameSession(GameSession session) {
        return session.games.size() == 3;
    }
}
