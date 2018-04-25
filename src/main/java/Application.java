import java.util.ArrayList;

public class Application {
    private static GameSessionManager gameSessionManager;
    static {
        gameSessionManager = new GameSessionManager(new ArrayList<>());
    }

    public static void main(String[] args) {

    }

    public GameSessionManager getGameSessionManager() {
        return gameSessionManager;
    }
}
