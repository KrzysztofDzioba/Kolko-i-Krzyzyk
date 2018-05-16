package edu.dzioba.States;

import edu.dzioba.Board.BoardPrinter;
import edu.dzioba.Messaging.Messages;

public class GameBeginningState extends GameState {

    GameBeginningState(GameState previousState) {
        super(previousState);
    }

    @Override
    public GameState getNextState() {
        journalist.sayMessageWithParameters(Messages.results,
                                            players.getCurrentPlayer().toString(),
                                            String.valueOf(players.getCurrentPlayer().getPoints()),
                                            players.getNextPlayer().toString(),
                                            String.valueOf(players.getNextPlayer().getPoints()));

        journalist.sayMessage(Messages.new_board);
        games.addNewGame();
        players.setCurrentPlayer(players.getOppositePlayer(players.getGameBeginner()));
        players.setGameBeginner();
        boardPrinter = new BoardPrinter(getCurrentGame().getBoard(), journalist);
        return new RunningState(this);
    }
}
