package edu.dzioba.Players;

public class Player {
    private String name;
    private final Sign sign;
    private int points;

    public Player(String name, Sign x) {
        this.name = name;
        this.sign = x;
        this.points = 0;
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + sign + ")";
    }

    public void addPoints(int wonPoints) {
        this.points += wonPoints;
    }

    public int getPoints() {
        return points;
    }

    public Sign getSign() {
        return sign;
    }
}
