package edu.dzioba;

public class GameSession {
    private GameSessionManager manager;
    private GameState currentState;

    public GameSession (GameSessionManager manager, GameState state) {
        this.manager = manager;
        this.currentState = state;
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

}
