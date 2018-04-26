package edu.dzioba;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        GameSessionManager manager = new GameSessionManager(
                                     new Scanner(System.in)::nextLine,
                                     System.out::println);
        GameSession session = new GameSession(new ArrayList<>(), new ArrayList<>(), manager);
        session.start();
    }
}
