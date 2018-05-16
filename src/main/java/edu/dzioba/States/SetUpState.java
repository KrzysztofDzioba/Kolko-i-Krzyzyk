package edu.dzioba.States;

import edu.dzioba.Board.BoardDimensions;
import edu.dzioba.Board.BoardPrinter;
import edu.dzioba.Game.GameSessionManager;
import edu.dzioba.Game.Games;
import edu.dzioba.Game.WinChecker;
import edu.dzioba.Messaging.Messages;
import edu.dzioba.Players.Player;
import edu.dzioba.Players.Players;
import edu.dzioba.Players.Sign;
import edu.dzioba.UserInputHandling.InputValidator;

import java.util.Arrays;

public class SetUpState extends GameState {

    public SetUpState(GameSessionManager manager) {
        super(manager);
    }

    @Override
    public GameState getNextState() {
        setUp(); // PRODUCTION MODE
//        setUpDefaults(); // TEST MODE
        return new RunningState(this);
    }

    private void setUp() {
        setUpPlayers();
        BoardDimensions dimensions = setUpBoard();
        setUpWinningConditions(dimensions);
        outputStartMessages();
    }

    private void setUpDefaults() {
        setUpDefaultPlayers();
        setUpDefaultBoard();
        setUpDefaultWinningConditions();
        journalist.sayMessage("Test set up finished. \n");
        outputStartMessages();
    }

    private void outputStartMessages() {
        journalist.sayMessage(Messages.give_up);
        journalist.sayMessage(Messages.moving);
        boardPrinter = new BoardPrinter(games.getCurrentGame().getBoard(), journalist);
    }

    private BoardDimensions setUpBoard() {
        BoardDimensions dimensions = manager.getBoardsDimensions(new InputValidator());
        games = new Games(Games.initializeGames(dimensions));
        games.setBoardDimensions(dimensions);
        getCurrentGame().setNewBoard(dimensions);
        return dimensions;
    }

    private void setUpWinningConditions(BoardDimensions dimensions) {
        int winningNumber = manager.getWinningNumber(new InputValidator(), dimensions);
        this.winChecker = new WinChecker(winningNumber, new InputValidator());
    }

    private void setUpPlayers() {
        players = manager.setUpPlayers();
        players.setCurrentPlayer(manager.getFirstPlayer(players));
        players.setGameBeginner();
    }

    private void setUpDefaultBoard() {
        BoardDimensions dimensions = new BoardDimensions(5,10);
        games = new Games(Games.initializeGames(dimensions));
        games.setBoardDimensions(dimensions);
        getCurrentGame().setNewBoard(dimensions);
    }

    private void setUpDefaultWinningConditions() {
        int winningNumber = 3;
        this.winChecker = new WinChecker(winningNumber, new InputValidator());
    }

    private void setUpDefaultPlayers() {
        players = new Players(Arrays.asList(new Player("foo", Sign.X), new Player("bar", Sign.O)), Sign.X);
        players.setGameBeginner();
    }
}
