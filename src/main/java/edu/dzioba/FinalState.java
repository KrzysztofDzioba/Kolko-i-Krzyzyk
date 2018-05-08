package edu.dzioba;

public class FinalState extends GameState {


    FinalState(GameState previousState) {
        super(previousState);
    }

    @Override
    GameState getNextState() {
        Player playerX = players.getPlayer(Sign.X);
        Player playerY = players.getPlayer(Sign.O);
        journalist.sayMessage("End of game!");
        journalist.sayMessageWithParameters("Results: \nPlayer %s: %s points. Player %s: %s points.",
                                            playerX.toString(),
                                            String.valueOf(playerX.getPoints()),
                                            playerY.toString(),
                                            String.valueOf(playerY.getPoints()));
        Player winner = players.getWinner();
        if(winner == null)
            journalist.sayMessage("Draw. Both players fought the same fiercely ");
        else
            journalist.sayMessageWithParameters("Congratulations player %s, you win!", winner.toString());
        System.exit(0);
        return null;
    }
}
