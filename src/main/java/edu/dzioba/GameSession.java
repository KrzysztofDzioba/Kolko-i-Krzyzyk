package edu.dzioba;

import java.util.List;

public class GameSession {
    List<Game> games;
    List<Player> players;
    private GameSessionManager manager;

    public GameSession(List<Game> games, List<Player> players, GameSessionManager manager) {
        this.games = games;
        this.players = players;
        this.manager = manager;
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

    public void start() {
        manager.setUpSession(this);
        manager.setUpPlayers();
        manager.setUpFirstPlayer();
        manager.setBoardsDimensions(new InputValidator(new InputConverter()));
    }

}
