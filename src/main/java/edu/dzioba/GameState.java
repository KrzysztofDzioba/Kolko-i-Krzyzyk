package edu.dzioba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class GameState {

    public static int gamesAlreadyPlayed = 0;

    Games games;
    Journalist journalist;
    Supplier<String> input;
    Players players;
    Board board;
    GameSessionManager manager;
    int winningNumber;


    GameState(Journalist output, Supplier<String> input, Board board, Players players) {
        this.journalist = output;
        this.input = input;
        this.board = board;
        this.players = players;
    }

    GameState(GameState previousState) {
        this.journalist = previousState.journalist;
        this.input = previousState.input;
        this.board = previousState.board;
        this.players = previousState.players;
    }

    GameState(GameSessionManager manager) {
        this.journalist = manager.getJournalist();
        this.input = manager.userInputProvider;
        this.manager = manager;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addPlayer(Player player) {
        players.addPlayer(player);
    }

    abstract GameState getNextState();
}
