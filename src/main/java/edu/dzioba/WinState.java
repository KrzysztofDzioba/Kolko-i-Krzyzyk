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
        journalist.sayMessageWithParameters("Congratulations player %s! You won this game." +
                                                    " 3 points are going to your account.",
                                                    players.currentPlayer.toString());
        return new GameBeginningState(this);
    }
}
