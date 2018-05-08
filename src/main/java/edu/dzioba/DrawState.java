package edu.dzioba;

public class DrawState extends GameState {

    public DrawState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        players.currentPlayer.addPoints(1);
        players.getNextPlayer().addPoints(1);
        journalist.sayMessage(Messages.draw_after_game);
        if(games.threeGamesWerePlayed())
            return new FinalState(this);
        return new GameBeginningState(this);
    }
}
