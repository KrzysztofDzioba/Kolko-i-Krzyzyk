package edu.dzioba.States;

import edu.dzioba.Messaging.Messages;
import edu.dzioba.Players.Player;
import edu.dzioba.Players.Sign;

public class FinalState extends GameState {


    FinalState(GameState previousState) {
        super(previousState);
    }

    @Override
    public GameState getNextState() {
        Player playerX = players.getPlayer(Sign.X);
        Player playerY = players.getPlayer(Sign.O);
        journalist.sayMessage(Messages.end_of_game);
        journalist.sayMessageWithParameters(Messages.results,
                                            playerX.toString(),
                                            String.valueOf(playerX.getPoints()),
                                            playerY.toString(),
                                            String.valueOf(playerY.getPoints()));
        Player winner = players.getWinner();
        if(winner == null)
            journalist.sayMessage(Messages.same_fiercely);
        else
            journalist.sayMessageWithParameters(Messages.final_congratulation, winner.toString());
        System.exit(0);
        return null;
    }
}
