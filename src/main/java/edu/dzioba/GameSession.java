package edu.dzioba;

import java.util.List;

public class GameSession {
    List<Game> games;
    List<Player> players;
    private GameSessionManager manager;
    private Integer winningNumber;
    private int[] boardsDimensions;
    private Player currentPlayer;
    private GameState currentState;

    public GameSession(List<Game> games, List<Player> players, GameSessionManager manager, GameState state) {
        this.games = games;
        this.players = players;
        this.manager = manager;
        this.currentState = state;
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
//        setUp();
        while (GameState.gamesAlreadyPlayed < 3) {
            doOneCycle();
        }
    }

    private void doOneCycle() {
        this.currentState = currentState.getNextState();
    }

    private void setUp() {
        manager.setUpSession(this);
        this.players = manager.setUpPlayers();
        this.currentPlayer = manager.setUpFirstPlayer();
        this.boardsDimensions = manager.getBoardsDimensions(new InputValidator(new InputConverter()));
        this.winningNumber = manager.getWinningNumber(new InputValidator(new InputConverter()), boardsDimensions);
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
}
