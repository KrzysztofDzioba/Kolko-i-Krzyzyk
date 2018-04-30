package edu.dzioba;

import java.util.function.Supplier;

public class RunningState extends GameState {

    RunningState(Journalist output, Supplier<String> input, Players players, Games games) {
        super(output, input, players, games);
    }

    RunningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        Coordinates cords = manager.getCoordinates(players.currentPlayer, getCurrentGame().board.dimensions, getCurrentGame());
        getCurrentGame().board.insertCoordinates(cords, players.getCurrentsPlayerSign());
        players.currentPlayer = players.getNextPlayer();
        return new WinState(this);
    }


}
