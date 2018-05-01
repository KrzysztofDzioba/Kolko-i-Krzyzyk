package edu.dzioba;

public class DrawState extends GameState {

    public DrawState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        System.out.println("Draw State");
        return new RunningState(this);
    }
}
