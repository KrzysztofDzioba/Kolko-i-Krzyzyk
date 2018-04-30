package edu.dzioba;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.testng.Assert.assertTrue;

public class WinCheckerTest {

    private GameSessionManager gameSessionManager;
    private GameSession session;
    private Sign sampleSign = Sign.X;
    private InputValidator validator;
    private GameState basicRunningState;
    private Players players;
    private BoardDimensions sampleBoardDimensions;
    private Coordinates sampleCoordinates;



    @BeforeMethod
    private void setUp() {
        players = new Players(Arrays.asList(new Player("foo", Sign.X), new Player("bar", Sign.O)), Sign.X);
        sampleBoardDimensions = new BoardDimensions(3,3);

        gameSessionManager = new GameSessionManager(new Scanner(System.in)::nextLine,
                new Journalist(Language.ENGLISH),
                new InputConverter(), new InputValidator(new InputConverter()));

        validator = new InputValidator(new InputConverter());
        sampleCoordinates = new Coordinates(2,2);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_leftUp_to_coords() {
        //given
        int numberOfWinningSigns = 3;
        WinChecker winChecker = new WinChecker(numberOfWinningSigns, new InputValidator());
        Coordinates winningCoords = new Coordinates(3, 3);
        Sign winningSign = Sign.X;
        Board board = new Board(new BoardDimensions(3, 3));
        board.insertCoordinates(1, 1, winningSign);
        board.insertCoordinates(2, 2, winningSign);
        //when
        boolean winnerExists = winChecker.isWinner(winningSign, board, winningCoords);
        //then
        assertTrue(winnerExists);
    }
}
