package edu.dzioba.Players;

import java.util.List;

public class Players {
    final private List<Player> players;
    private Player currentPlayer;
    private Player gameBeginner;

    public Players(List<Player> players, Sign currentPlayer) {
        this.players = players;
        this.currentPlayer = getPlayer(currentPlayer);
    }

    public Player getPlayer(Sign sign) {
        for (Player player : players) {
            if(player.getSign().equals(sign))
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
        return currentPlayer.getSign();
    }

    public Player getGameBeginner() {
        return gameBeginner;
    }

    public void setGameBeginner() {
        gameBeginner = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
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

    public void swapCurrentPlayer() {
        this.currentPlayer = getNextPlayer();
    }
}
