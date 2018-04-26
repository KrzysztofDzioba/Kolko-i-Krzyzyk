package edu.dzioba;

import java.util.function.Supplier;

public class GameSessionManager {
    Supplier<String> userInputProvider;
    private Journalist journalist;

    public GameSessionManager(Supplier<String> userInputProvider, Journalist journalist) {
        this.userInputProvider = userInputProvider;
        this.journalist = journalist;
    }

    public Player getWinner() { // TODO
        return new Player("Foo", Sign.X);
    }

    public boolean isEndOfGameSession(GameSession session) {
        return session.games.size() == 3;
    }

    public void setUpPlayers(GameSession session) {
        setUpPlayer(session, Sign.X);
        journalist.sayMessage("Player added");
        setUpPlayer(session, Sign.O);
        journalist.sayMessage("Player added");
    }

    private void setUpPlayer(GameSession session, Sign sign) {
        journalist.sayMessage("Hello player " + sign.name() + ". Please say me what is your name: ");
        String playerName = userInputProvider.get();
        session.addPlayer(new Player(playerName, sign));
    }

    public Journalist getJournalist() {
        return journalist;
    }
}
