package edu.dzioba.States;

import edu.dzioba.Messaging.Messages;

public class WinState extends GameState {

    WinState(GameState previousState) {
        super(previousState);
    }

    @Override
    public GameState getNextState() {
        players.getCurrentPlayer().addPoints(3);
        boardPrinter.printBoard();
        if(games.threeGamesWerePlayed())
            return new FinalState(this);
        journalist.sayMessageWithParameters(Messages.player_won, players.getCurrentPlayer().toString());
        return new GameBeginningState(this);
    }
}
