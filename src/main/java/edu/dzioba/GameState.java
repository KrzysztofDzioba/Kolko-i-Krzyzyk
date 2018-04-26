package edu.dzioba;

import java.util.List;
import java.util.function.Supplier;

public abstract class GameState {

    public static int gamesAlreadyPlayed = 0;

    Language language;
    Journalist journalist;
    Supplier<String> input;
    List<Player> players;
    Board board;


    GameState(Journalist output, Supplier<String> input, Language lang, Board board, List<Player> players) {
        this.journalist = output;
        this.input = input;
        this.language = lang;
        this.board = board;
        this.players = players;
    }

    GameState(GameState previousState) {
        this.journalist = previousState.journalist;
        this.input = previousState.input;
        this.language = previousState.language;
        this.board = previousState.board;
        this.players = previousState.players;
    }

    abstract GameState getNextState();
}
