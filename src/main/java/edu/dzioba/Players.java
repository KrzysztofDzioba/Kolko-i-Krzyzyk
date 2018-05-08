package edu.dzioba;

import java.util.List;

public class Players {
    final List<Player> players;
    Player currentPlayer;
    private Player gameBeginner;

    public Players(List<Player> players, Sign currentPlayer) {
        this.players = players;
        this.currentPlayer = getPlayer(currentPlayer);
    }

    Player getPlayer(Sign sign) {
        for (Player player : players) {
            if(player.sign.equals(sign))
                return player;
        }
        return null;
    }

    public Player getNextPlayer() {
        for (Player player : players) {
            if(!currentPlayer.equals(player))
                return player;
        }
        return null;
    }

    public void setCurrentPlayer(Sign sign) {
        currentPlayer = getPlayer(sign);
    }

    public boolean addPlayer(Player player) {
        players.add(player);
        return true;
    }

    public Sign getCurrentsPlayerSign() {
        return currentPlayer.sign;
    }

    public Player getGameBeginner() {
        return gameBeginner;
    }

    public void setGameBeginner() {
        gameBeginner = currentPlayer;
    }

    public Player getOppositePlayer(Player givenPlayer) {
        for(Player player : players) {
            if(givenPlayer != player)
                return player;
        }
        return null;
    }

    public Player getWinner() {
        Player winner = currentPlayer;
        for(Player player : players) {
            if(player.getPoints() > winner.getPoints())
                winner = player;
        }
        if(winner.getPoints() == getOppositePlayer(winner).getPoints())
            return null; // draw
        return winner;
    }
}
