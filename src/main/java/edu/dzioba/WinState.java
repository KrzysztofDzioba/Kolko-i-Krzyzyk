package edu.dzioba;

public class WinState extends GameState {

    WinState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        players.currentPlayer.addPoints(3);
        if(games.threeGamesWerePlayed())
            return new FinalState(this);
        journalist.sayMessageWithParameters(Messages.player_won, players.currentPlayer.toString());
        return new GameBeginningState(this);
    }
}
