package edu.dzioba;

public class Player {
    private String name;
    Sign sign;
    private int points;

    Player(String name, Sign x) {
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
}
