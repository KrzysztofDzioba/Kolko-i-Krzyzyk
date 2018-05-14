package edu.dzioba;

public class GameBeginningState extends GameState {

    GameBeginningState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        journalist.sayMessageWithParameters(Messages.results,
                                            players.currentPlayer.toString(),
                                            String.valueOf(players.currentPlayer.getPoints()),
                                            players.getNextPlayer().toString(),
                                            String.valueOf(players.getNextPlayer().getPoints()));

        journalist.sayMessage(Messages.new_board);
        games.addNewGame();
        players.currentPlayer = players.getOppositePlayer(players.getGameBeginner());
        players.setGameBeginner();
        boardPrinter = new BoardPrinter(getCurrentGame().board, journalist);
        return new RunningState(this);
    }
}
