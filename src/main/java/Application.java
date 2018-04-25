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
        System.out.println("Witaj w grze Kółko i krzyżyk!");
        System.out.print("Proszę, podaj swoje imię: ");
        String imie = gameSessionManager.userInputProvider.get();
        System.out.println("Graczu " + imie + ". Wygrałeś!");
    }

    public GameSessionManager getGameSessionManager() {
        return gameSessionManager;
    }
}
