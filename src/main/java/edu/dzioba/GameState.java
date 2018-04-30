package edu.dzioba;

import java.util.function.Supplier;

public abstract class GameState {

    public static int gamesAlreadyPlayed = 0;

    Games games;
    Journalist journalist;
    Supplier<String> input;
    Players players;
    GameSessionManager manager;
    int winningNumber;


    GameState(Journalist output, Supplier<String> input, Players players, Games games) {
        this.journalist = output;
        this.input = input;
        this.players = players;
        this.games = games;
    }

    GameState(GameState previousState) {
        this.journalist = previousState.journalist;
        this.input = previousState.input;
        this.players = previousState.players;
        this.manager = previousState.manager;
        this.games = previousState.games;
    }

    GameState(GameSessionManager manager) {
        this.journalist = manager.getJournalist();
        this.input = manager.userInputProvider;
        this.manager = manager;
    }

    Game getCurrentGame() {
        return games.currentGame;
    }

    abstract GameState getNextState();
}
