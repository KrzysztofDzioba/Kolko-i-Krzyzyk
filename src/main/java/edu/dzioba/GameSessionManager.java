package edu.dzioba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GameSessionManager {
    Supplier<String> userInputProvider;
    private Journalist journalist;
    private GameSession session;
    InputConverter converter;

    public GameSessionManager(Supplier<String> userInputProvider, Journalist journalist, InputConverter converter) {
        this.userInputProvider = userInputProvider;
        this.journalist = journalist;
        this.converter = converter;
    }

    public Player getWinner() { // TODO
        return new Player("Foo", Sign.X);
    }

    public Players setUpPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(setUpPlayer(Sign.X));
        journalist.sayMessage("Player added");
        players.add(setUpPlayer(Sign.O));
        journalist.sayMessage("Player added");
        return new Players(players, null);
    }

    private Player setUpPlayer(Sign sign) {
        journalist.sayMessage("Hello player " + sign.name() + ". Please say me what is your name: ");
        String playerName = userInputProvider.get();
        return new Player(playerName, sign);
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public Sign askWhoShouldBegin() {
        String userInput;
        do {
            journalist.sayMessage("Who should begin? (X or O)");
            userInput = userInputProvider.get();
        } while (!userInput.equals("O") && !userInput.equals("X"));
        return Sign.valueOf(userInput);
    }

    public void setUpSession(GameSession gameSession) {
        this.session = gameSession;
    }

    public Player setUpFirstPlayer(Players players) {
        Sign sign = askWhoShouldBegin();
        return players.getPlayer(sign);
    }

    public int[] getBoardsDimensions(InputValidator validator) {
        journalist.sayMessage("Please tell me how the board should look like? Type: X,Y (where X is width and Y is height)");
        String userInput = userInputProvider.get();
        boolean wrongUserInput = true;
        while(wrongUserInput) {
            if(validator.properBoardSizeInput(userInput)) {
                return converter.getBoardSize(userInput);
            }
            else {
                journalist.sayMessage("Please provide proper dimensions (example: 4,5)");
                userInput = userInputProvider.get();
            }
        }
        return null;
    }

    public Integer getWinningNumber(InputValidator validator, int[] boardsDimensions) {
        journalist.sayMessage("Please tell me how many signs in a row wins?");
        String userInput = userInputProvider.get();
        boolean wrongUserInput = true;
        while(wrongUserInput) {
            if(validator.properWinningNumber(userInput, boardsDimensions)) {
                return Integer.valueOf(userInput);
            }
            else {
                journalist.sayMessage("Please provide proper number (example: 3). " +
                        "Number of winning number can't be larger than board dimensions");
                userInput = userInputProvider.get();
            }
        }
        return null;
    }
}
