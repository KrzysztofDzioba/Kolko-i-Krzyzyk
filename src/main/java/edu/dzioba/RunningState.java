package edu.dzioba;

public class RunningState extends GameState {

    RunningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        players.currentPlayer = players.getNextPlayer();
        Coordinates cords = manager.getCoordinates(players.currentPlayer, getCurrentGame().board.dimensions, getCurrentGame());
        if(cords == null) {
            players.currentPlayer = players.getNextPlayer();
            return new WinState(this);
        }
        getCurrentGame().board.insertCoordinates(cords, players.getCurrentsPlayerSign());
        if(getCurrentGame().board.isDraw())
            return new DrawState(this);
        else if(isWinnerInGame(cords))
            return new WinState(this);
        return new RunningState(this);
    }


}
