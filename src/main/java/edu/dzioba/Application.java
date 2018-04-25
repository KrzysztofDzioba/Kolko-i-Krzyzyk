package edu.dzioba;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static GameSessionManager gameSessionManager;
    static {
        gameSessionManager = new GameSessionManager(
                new Scanner(System.in)::nextLine,
                System.out::println);
    }

    public static void main(String[] args) {
        GameSession session = new GameSession(new ArrayList<>(), new ArrayList<>());
        gameSessionManager.setUpPlayers(session);
    }

    public GameSessionManager getGameSessionManager() {
        return gameSessionManager;
    }
}
