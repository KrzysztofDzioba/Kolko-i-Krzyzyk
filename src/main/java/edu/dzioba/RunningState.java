package edu.dzioba;

import java.util.List;
import java.util.function.Supplier;

public class RunningState extends GameState {


    RunningState(Journalist output, Supplier<String> input, Language lang, Board board, List<Player> players) {
        super(output, input, lang, board, players);
    }

    RunningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        System.out.println("dzialam");
        return new WinState(this);
    }
}
