import java.util.List;

public class GameSessionManager {
    List<Game> games;

    public GameSessionManager(List<Game> games) {
        this.games = games;
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
