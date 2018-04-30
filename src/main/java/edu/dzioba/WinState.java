package edu.dzioba;

public class WinState extends GameState {

    WinState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        System.out.println("Win State");
        return new RunningState(this);
    }
}
