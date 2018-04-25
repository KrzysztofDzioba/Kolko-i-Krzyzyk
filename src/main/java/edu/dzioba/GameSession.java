package edu.dzioba;

import java.util.List;

public class GameSession {
    List<Game> games;
    List<Player> players;

    public GameSession(List<Game> games, List<Player> players) {
        this.games = games;
        this.players = players;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
