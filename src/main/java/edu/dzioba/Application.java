package edu.dzioba;

import edu.dzioba.Game.GameSession;
import edu.dzioba.Game.GameSessionManager;
import edu.dzioba.States.SetUpState;
import edu.dzioba.UserInputHandling.InputConverter;
import edu.dzioba.UserInputHandling.InputValidator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        GameSessionManager manager = new GameSessionManager(
                                     new Scanner(System.in)::nextLine,
                                     args,
                                     new InputConverter(),
                                     new InputValidator(),
                                     System.out::println);
        GameSession session = new GameSession(new SetUpState(manager));
        session.start();
    }
}
