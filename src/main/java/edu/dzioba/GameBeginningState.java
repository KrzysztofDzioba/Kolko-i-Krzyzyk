package edu.dzioba;

public class GameBeginningState extends GameState {

    GameBeginningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        journalist.sayMessageWithParameters("Results: player %s: %s points, player %s: %s points.",
                                                    players.currentPlayer.toString(),
                                                    String.valueOf(players.currentPlayer.getPoints()),
                                                    players.getNextPlayer().toString(),
                                                    String.valueOf(players.getNextPlayer().getPoints()));

        journalist.sayMessage("\n Creating new board.");
        games.addNewGame();
        players.currentPlayer = players.getOppositePlayer(players.getGameBeginner());
        players.setGameBeginner();
        return new RunningState(this);
    }
}
