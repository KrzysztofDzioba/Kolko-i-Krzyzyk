package edu.dzioba;

import java.util.List;
import java.util.function.Supplier;

public class WinState extends GameState {

    WinState(Journalist output, Supplier<String> input, Language lang, Board board, List<Player> players) {
        super(output, input, lang, board, players);
    }

    WinState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        System.out.println("Win");
        return new RunningState(this);
    }
}
