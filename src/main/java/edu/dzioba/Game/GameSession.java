package edu.dzioba.Game;

import edu.dzioba.States.GameState;

public class GameSession {
    private GameState currentState;

    public GameSession (GameState state) {
        this.currentState = state;
    }

    public void start() {
        while (GameState.gamesAlreadyPlayed < 3) {
            doOneCycle();
        }
    }

    private void doOneCycle() {
        this.currentState = currentState.getNextState();
    }

}
