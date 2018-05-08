package edu.dzioba;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        GameSessionManager manager = new GameSessionManager(
                                     new Scanner(System.in)::nextLine,
                                     args,
                                     new InputConverter(),
                                     new InputValidator(new InputConverter()),
                                     System.out::println);
        GameSession session = new GameSession(new SetUpState(manager));
        session.start();
    }
}
