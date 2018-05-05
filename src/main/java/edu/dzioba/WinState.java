package edu.dzioba;

public class WinState extends GameState {

    WinState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        journalist.sayMessageWithParameters("Congratulations player %s! You won this game." +
                                                    " 3 points are going to your account.",
                                                    players.currentPlayer.toString());
        players.currentPlayer.addPoints(3);



        return new GameBeginningState(this);
    }
}
