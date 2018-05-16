package edu.dzioba.States;

import edu.dzioba.Board.BoardPrinter;
import edu.dzioba.Board.Coordinates;
import edu.dzioba.Game.Game;
import edu.dzioba.Game.GameSessionManager;
import edu.dzioba.Game.Games;
import edu.dzioba.Game.WinChecker;
import edu.dzioba.Messaging.Journalist;
import edu.dzioba.Players.Players;

import java.util.function.Supplier;

public abstract class GameState {

    public static int gamesAlreadyPlayed = 0;

    Games games;
    Journalist journalist;
    Supplier<String> input;
    Players players;
    GameSessionManager manager;
    WinChecker winChecker;
    BoardPrinter boardPrinter;

    GameState(GameState previousState) {
        this.journalist = previousState.journalist;
        this.input = previousState.input;
        this.players = previousState.players;
        this.manager = previousState.manager;
        this.games = previousState.games;
        this.winChecker = previousState.winChecker;
        this.boardPrinter = previousState.boardPrinter;
    }

    GameState(GameSessionManager manager) {
        this.journalist = manager.getJournalist();
        this.input = manager.getUserInputProvider();
        this.manager = manager;
    }

    Game getCurrentGame() {
        return games.getCurrentGame();
    }

    boolean isWinnerInGame(Coordinates coords) {
        return winChecker.isWinner(games.getCurrentGame().getBoard(), coords);
    }

    public abstract GameState getNextState();
}
