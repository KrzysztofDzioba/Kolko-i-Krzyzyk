package edu.dzioba;

public class RunningState extends GameState {

    RunningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        boardPrinter.printBoard();
        players.currentPlayer = players.getNextPlayer();
        Coordinates cords = manager.getCoordinates(players.currentPlayer, getCurrentGame().board.dimensions, getCurrentGame());
        if(cords == null) {
            players.currentPlayer = players.getNextPlayer();
            return new WinState(this);
        }
        getCurrentGame().board.insertCoordinates(cords, players.getCurrentsPlayerSign());
        if(isWinnerInGame(cords))
            return new WinState(this);
        else if(getCurrentGame().board.isDraw())
            return new DrawState(this);
        return new RunningState(this);
    }
}
