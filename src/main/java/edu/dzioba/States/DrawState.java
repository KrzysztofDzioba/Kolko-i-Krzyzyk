package edu.dzioba.States;

import edu.dzioba.Messaging.Messages;

public class DrawState extends GameState {

    public DrawState(GameState previousState) {
        super(previousState);
    }

    @Override
    public GameState getNextState() {
        players.getCurrentPlayer().addPoints(1);
        players.getNextPlayer().addPoints(1);
        boardPrinter.printBoard();
        journalist.sayMessage(Messages.draw_after_game);
        if(games.threeGamesWerePlayed())
            return new FinalState(this);
        return new GameBeginningState(this);
    }
}
