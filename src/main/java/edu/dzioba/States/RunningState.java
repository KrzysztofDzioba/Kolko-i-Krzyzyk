package edu.dzioba.States;

import edu.dzioba.Board.Coordinates;

public class RunningState extends GameState {

    RunningState(GameState previousState) {
        super(previousState);
    }

    @Override
    public GameState getNextState() {
        boardPrinter.printBoard();
        players.swapCurrentPlayer();
        Coordinates cords = manager.getCoordinates(players.getCurrentPlayer(),
                                                    getCurrentGame().getBoard().getDimensions(), getCurrentGame());
        if(cords == null) {
            players.swapCurrentPlayer();
            return new WinState(this);
        }
        getCurrentGame().getBoard().insertCoordinates(cords, players.getCurrentsPlayerSign());
        if(isWinnerInGame(cords))
            return new WinState(this);
        else if(getCurrentGame().getBoard().isDraw())
            return new DrawState(this);
        return new RunningState(this);
    }
}
