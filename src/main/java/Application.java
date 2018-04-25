import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static GameSessionManager gameSessionManager;
    static {
        gameSessionManager = new GameSessionManager(
                new ArrayList<>(),
                new Scanner(System.in)::nextLine,
                System.out::println);
    }

    public static void main(String[] args) {

    }

    public GameSessionManager getGameSessionManager() {
        return gameSessionManager;
    }
}
