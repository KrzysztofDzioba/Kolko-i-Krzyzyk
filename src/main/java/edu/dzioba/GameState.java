package edu.dzioba;

import java.util.function.Supplier;

public abstract class GameState {

    public static int gamesAlreadyPlayed = 0;

    Games games;
    Journalist journalist;
    Supplier<String> input;
    Players players;
    GameSessionManager manager;
    WinChecker winChecker;

    GameState(GameState previousState) {
        this.journalist = previousState.journalist;
        this.input = previousState.input;
        this.players = previousState.players;
        this.manager = previousState.manager;
        this.games = previousState.games;
        this.winChecker = previousState.winChecker;
    }

    GameState(GameSessionManager manager) {
        this.journalist = manager.getJournalist();
        this.input = manager.userInputProvider;
        this.manager = manager;
    }

    Game getCurrentGame() {
        return games.currentGame;
    }

    boolean isWinnerInGame(Coordinates coords) {
        return winChecker.isWinner(players.getCurrentsPlayerSign(), games.currentGame.board, coords);
    }

    abstract GameState getNextState();
}
