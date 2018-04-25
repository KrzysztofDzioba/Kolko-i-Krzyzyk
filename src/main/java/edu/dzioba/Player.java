package edu.dzioba;

public class Player {
    private String name;

    Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public String getName() {
        return name;
    }
}
