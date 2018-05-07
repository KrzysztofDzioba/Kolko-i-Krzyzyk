package edu.dzioba;

public class DrawState extends GameState {

    public DrawState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        journalist.sayMessage("Draw! All fields are filled, but no winner exists. 1 point is going to both players.");
        players.currentPlayer.addPoints(1);
        players.getNextPlayer().addPoints(1);
        return new GameBeginningState(this);
    }
}
