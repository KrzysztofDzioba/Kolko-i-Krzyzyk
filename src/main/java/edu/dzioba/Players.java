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

    public void setNextGameBeginner() {
        for (Player player : players) {
            if(gameBeginner == player) // == because in running state there is player's swapping
                gameBeginner = player;
        }
    }

    public void setGameBeginner() {
        gameBeginner = getNextPlayer(); //
    }
}
