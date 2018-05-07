package edu.dzioba;

import java.util.Arrays;

public class SetUpState extends GameState {

    public SetUpState(GameSessionManager manager) {
        super(manager);
    }

    @Override
    GameState getNextState() {
        setUp(); // PRODUCTION MODE
//        setDefaultsForTests(); // TEST MODE
        return new RunningState(this);
    }

    private void setUp() {
        players = manager.setUpPlayers();
        players.currentPlayer = manager.getFirstPlayer(players);
        players.setGameBeginner();
        BoardDimensions dimensions = manager.getBoardsDimensions(new InputValidator(new InputConverter()));
        games = new Games(Games.initializeGames(dimensions));
        games.setBoardDimensions(dimensions);
        getCurrentGame().board = new Board(dimensions);
        int winningNumber = manager.getWinningNumber(new InputValidator(new InputConverter()), dimensions);
        this.winChecker = new WinChecker(winningNumber, new InputValidator());
        journalist.sayMessage("Remember: player can always give up by pressing 'q' during his move.");
    }


    private void setDefaultsForTests() {
        players = new Players(Arrays.asList(new Player("foo", Sign.X), new Player("bar", Sign.O)), Sign.X);
        players.setGameBeginner();
        BoardDimensions dimensions = new BoardDimensions(3,3);
        games = new Games(Games.initializeGames(dimensions));
        games.setBoardDimensions(dimensions);
        getCurrentGame().board = new Board(dimensions);
        int winningNumber = 3;
        this.winChecker = new WinChecker(winningNumber, new InputValidator());
        System.out.println("Test set up finished. \n");
        journalist.sayMessage("Remember: player can always give up by pressing 'q' during his move. \n");
    }

}
