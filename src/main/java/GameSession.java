import java.util.ArrayList;
import java.util.List;

public class GameSession {
    List<Game> games;

    public GameSession(ArrayList<Game> games) {
        this.games = games;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }
}
