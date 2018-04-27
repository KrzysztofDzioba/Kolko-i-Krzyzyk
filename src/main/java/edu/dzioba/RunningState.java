package edu.dzioba;

import java.util.function.Supplier;

public class RunningState extends GameState {


    RunningState(Journalist output, Supplier<String> input, Board board, Players players) {
        super(output, input, board, players);
    }

    RunningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        journalist.sayMessage("Player " + players.currentPlayer + ". Please make your move.");
        String userInput = input.get();
        players.currentPlayer = players.getNextPlayer();
        return new WinState(this);
    }
}
