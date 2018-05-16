package edu.dzioba.Game;

import edu.dzioba.Board.BoardDimensions;
import edu.dzioba.Board.Coordinates;
import edu.dzioba.Messaging.Journalist;
import edu.dzioba.Messaging.Language;
import edu.dzioba.Messaging.Messages;
import edu.dzioba.Players.Player;
import edu.dzioba.Players.Players;
import edu.dzioba.Players.Sign;
import edu.dzioba.UserInputHandling.InputConverter;
import edu.dzioba.UserInputHandling.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GameSessionManager {
    private Supplier<String> userInputProvider;
    private Journalist journalist;
    private InputConverter converter;
    private InputValidator validator;

    public GameSessionManager(Supplier<String> userInputProvider, String[] programArguments, InputConverter converter,
                              InputValidator validator, Consumer<String> output) {
        this.userInputProvider = userInputProvider;
        this.journalist = createJournalist(programArguments, output);
        this.converter = converter;
        this.validator = validator;
    }

    private Journalist createJournalist(String[] programArguments, Consumer<String> output) {
        if(programArguments.length == 0)
            return new Journalist(Locale.ENGLISH, output);
        Language lang;
        try {
            lang = Language.valueOf(programArguments[0]);
        } catch (IllegalArgumentException e) {
            Journalist journalist = new Journalist(Locale.ENGLISH, output);
            journalist.sayMessage(Messages.wrong_configurable_variable);
            return journalist;
        }
        return new Journalist(lang.getLocale(), output);
    }

    public Players setUpPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(setUpPlayer(Sign.X));
        journalist.sayMessage(Messages.player_added);
        players.add(setUpPlayer(Sign.O));
        journalist.sayMessage(Messages.player_added);
        return new Players(players, null);
    }

    private Player setUpPlayer(Sign sign) {
        journalist.sayMessageWithParameters(Messages.get_player_name, sign.name());
        String playerName = userInputProvider.get();
        return new Player(playerName, sign);
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public Sign askWhoShouldBegin() {
        String userInput;
        do {
            journalist.sayMessage(Messages.who_should_begin);
            userInput = userInputProvider.get();
        } while (!userInput.equalsIgnoreCase("O") && !userInput.equalsIgnoreCase("X"));
        return Sign.valueOf(userInput.toUpperCase());
    }

    public Player getFirstPlayer(Players players) {
        Sign sign = askWhoShouldBegin();
        Sign firstPlayerSign = sign.getOppositeSign(); // opposite because in RunningState at the beginning there is current player swapping
        return players.getPlayer(firstPlayerSign);
    }

    public BoardDimensions getBoardsDimensions(InputValidator validator) {
        journalist.sayMessage(Messages.board_dimensions);
        String userInput = userInputProvider.get();
        boolean wrongUserInput = true;
        while(wrongUserInput) {
            if(validator.properBoardSizeInput(userInput)) {
                return converter.getBoardSize(userInput);
            }
            else {
                journalist.sayMessage(Messages.proper_dimensions);
                userInput = userInputProvider.get();
            }
        }
        return null;
    }

    public Integer getWinningNumber(InputValidator validator, BoardDimensions boardsDimensions) {
        journalist.sayMessage(Messages.provide_winning_signs);
        String userInput = userInputProvider.get();
        boolean wrongUserInput = true;
        while(wrongUserInput) {
            if(validator.properWinningNumber(userInput, boardsDimensions)) {
                return Integer.valueOf(userInput);
            }
            else {
                journalist.sayMessage(Messages.provide_proper_winning_signs);
                userInput = userInputProvider.get();
            }
        }
        return null;
    }

    public Coordinates getCoordinates(Player currentPlayer, BoardDimensions dimensions, Game currentGame) {
        journalist.sayMessageWithParameters(Messages.player_make_move, currentPlayer.toString());
        String userInput = userInputProvider.get();
        boolean wrongUserInput = true;
        while(wrongUserInput) {
            if(userInput.equals("q"))
                break;
            boolean validCoordsSchema = validator.properCoordinatesSchema(userInput);
            if(validCoordsSchema) {
                Coordinates coords = converter.getCoordinates(userInput);
                boolean coordsInBoard = validator.coordinatesInBoard(dimensions, coords);
                boolean coordsEmpty = validator.coordsAreEmptyInBoard(currentGame.getBoard(), coords);
                if(coordsInBoard && coordsEmpty)
                    return converter.getCoordinates(userInput);
                else {
                    journalist.sayMessage(Messages.wrong_field);
                    userInput = userInputProvider.get();
                }
            }
            else {
                journalist.sayMessage(Messages.bad_way_coordinates);
                userInput = userInputProvider.get();
            }
        }
        return null;
    }

    public Supplier<String> getUserInputProvider() {
        return userInputProvider;
    }
}
