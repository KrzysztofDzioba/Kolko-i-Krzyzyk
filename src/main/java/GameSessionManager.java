import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GameSessionManager {
    private List<Game> games;
    private Supplier<String> userInputProvider;
    private Consumer<String> output;

    public GameSessionManager(List<Game> games, Supplier<String> userInputProvider, Consumer<String> output) {
        this.games = games;
        this.userInputProvider = userInputProvider;
        this.output = output;
    }

    public Player getWinner() { // TODO
        return new Player();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean isEndOfGameSession() {
        return games.size() == 3;
    }
}
