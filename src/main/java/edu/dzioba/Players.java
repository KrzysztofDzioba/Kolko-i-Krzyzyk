package edu.dzioba;

import java.util.List;

public class Players {
    final List<Player> players;
    Player currentPlayer;

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
            if(currentPlayer.equals(player))
                continue;
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
}
