package edu.dzioba;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WinCheckerTest {


    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_leftUp_to_coords() {
        //given
        int numberOfWinningSigns = 3;
        WinChecker winChecker = new WinChecker(numberOfWinningSigns, new InputValidator());
        Coordinates winningCoords = new Coordinates(1, 1);
        Sign winningSign = Sign.X;
        Board board = new Board(new BoardDimensions(3, 3));
        board.insertCoordinates(3, 3, winningSign);
        board.insertCoordinates(2, 2, winningSign);
        //when
        boolean winnerExists = winChecker.isWinner(winningSign, board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_leftUp_to_coords() {
        //given
        int numberOfWinningSigns = 3;
        WinChecker winChecker = new WinChecker(numberOfWinningSigns, new InputValidator());
        Coordinates loosingCoords = new Coordinates(1,2);
        Sign winningSign = Sign.X;
        Board board = new Board(new BoardDimensions(3, 3));
        board.insertCoordinates(1, 1, winningSign);
        board.insertCoordinates(2, 2, winningSign);
        //when
        boolean winnerExists = winChecker.isWinner(winningSign, board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_RightUp_to_coords() {
        int numberOfWinningSigns = 3;
        WinChecker winChecker = new WinChecker(numberOfWinningSigns, new InputValidator());
        Coordinates winningCoords = new Coordinates(3, 1);
        Sign winningSign = Sign.X;
        Board board = new Board(new BoardDimensions(3, 3));
        board.insertCoordinates(1, 3, winningSign);
        board.insertCoordinates(2, 2, winningSign);
        //when
        boolean winnerExists = winChecker.isWinner(winningSign, board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

}
