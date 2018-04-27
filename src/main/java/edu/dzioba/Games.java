package edu.dzioba;

import java.util.List;

public class Games {
    List<Game> games;

    public Games(List<Game> games) {
        this.games = games;
    }

    public boolean threeGamesWerePlayed() {
        return games.size() == 3;
    }

    public void add(Game game) {
        games.add(game);
    }
}
