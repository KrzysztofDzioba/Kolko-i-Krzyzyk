package edu.dzioba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Games {
    Game currentGame;
    List<Game> games;
    private BoardDimensions boardDimensions;

    public Games(List<Game> games) {
        this.games = games;
        currentGame = games.get(0);
    }

    public static List<Game> initializeGames(BoardDimensions dimensions) {
        return new ArrayList<>(Arrays.asList(new Game(new Board(dimensions))));
    }

    public boolean threeGamesWerePlayed() {
        return games.size() == 3;
    }

    public void addNewGame() {
        Game newGame = new Game(new Board(boardDimensions));
        games.add(newGame);
        currentGame = newGame;
    }

    public void setBoardDimensions(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
    }
}
