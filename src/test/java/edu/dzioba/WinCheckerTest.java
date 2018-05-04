package edu.dzioba;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WinCheckerTest {
    private int numberOfWinningSigns = 3;
    private WinChecker sampleWinChecker;
    private Sign winningSign = Sign.X;
    private Board sample3x3Board;


    @BeforeTest
    private void setUpTests() {
        sampleWinChecker = new WinChecker(numberOfWinningSigns, new InputValidator());
    }

    @BeforeMethod
    private void setUpTest() {
        sample3x3Board = new Board(new BoardDimensions(3, 3));
    }


    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_DownRight() {
        //given
        Coordinates winningCoords = new Coordinates(1, 1);
        sample3x3Board.insertCoordinates(3, 3, winningSign);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_DownRight() {
        //given
        Coordinates loosingCoords = new Coordinates(1,2);
        sample3x3Board.insertCoordinates(3, 3, winningSign);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_UpRight() {
        //given
        Coordinates winningCoords = new Coordinates(3, 1);
        sample3x3Board.insertCoordinates(1, 3, winningSign);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_UpRight() {
        //given
        Coordinates loosingCoords = new Coordinates(3, 2);
        sample3x3Board.insertCoordinates(1, 3, winningSign);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_Right() {
        //given
        Coordinates winningCoords = new Coordinates(1, 1);
        sample3x3Board.insertCoordinates(1, 2, winningSign);
        sample3x3Board.insertCoordinates(1, 3, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_Right() {
        //given
        Coordinates loosingCoords = new Coordinates(2, 2);
        sample3x3Board.insertCoordinates(1, 2, winningSign);
        sample3x3Board.insertCoordinates(1, 3, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_Up() {
        //given
        Coordinates winningCoords = new Coordinates(3, 2);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(1, 2, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_Up() {
        //given
        Coordinates loosingCoords = new Coordinates(2, 3);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(1, 2, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_Left() {
        //given
        Coordinates winningCoords = new Coordinates(1, 3);
        sample3x3Board.insertCoordinates(1, 2, winningSign);
        sample3x3Board.insertCoordinates(1, 1, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_Left() {
        //given
        Coordinates loosingCoords = new Coordinates(3, 3);
        sample3x3Board.insertCoordinates(1, 2, winningSign);
        sample3x3Board.insertCoordinates(1, 1, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_DownLeft() {
        //given
        Coordinates winningCoords = new Coordinates(1, 3);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(3, 1, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_DownLeft() {
        //given
        Coordinates loosingCoords = new Coordinates(2, 3);
        sample3x3Board.insertCoordinates(2, 2, winningSign);
        sample3x3Board.insertCoordinates(3, 1, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_true_if_there_is_a_win_provided_win_is_coords_to_Down() {
        //given
        Coordinates winningCoords = new Coordinates(1, 1);
        sample3x3Board.insertCoordinates(2, 1, winningSign);
        sample3x3Board.insertCoordinates(3, 1, winningSign);
        sample3x3Board.insertCoordinates(winningCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, winningCoords);
        //then
        assertTrue(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_there_is_no_win_from_coords_to_Down() {
        //given
        Coordinates loosingCoords = new Coordinates(2, 3);
        sample3x3Board.insertCoordinates(2, 1, winningSign);
        sample3x3Board.insertCoordinates(3, 1, winningSign);
        sample3x3Board.insertCoordinates(loosingCoords, winningSign);
        //when
        boolean winnerExists = sampleWinChecker.isWinner(sample3x3Board, loosingCoords);
        //then
        assertFalse(winnerExists);
    }

    @Test
    public void win_checker_returns_false_if_opposite_sign_is_in_line() {
        //given
        int winningNumber = 3;
        WinChecker winChecker = new WinChecker(winningNumber, new InputValidator());
        Board board = new Board(new BoardDimensions(3, 3));
        board.insertCoordinates(1, 1, Sign.X);
        board.insertCoordinates(2, 2, Sign.O);
        board.insertCoordinates(3, 3, Sign.X);
        Coordinates coords = new Coordinates(3, 3);
        //when
        boolean winnerExists = winChecker.isWinner(board, coords);
        //then
        assertFalse(winnerExists);
    }

}
