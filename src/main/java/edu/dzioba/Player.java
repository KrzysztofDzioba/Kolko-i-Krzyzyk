package edu.dzioba;

public class Player {
    private String name;
    Sign sign;

    Player(String name, Sign x) {
        this.name = name;
        sign = x;
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public String getName() {
        return name;
    }
}
