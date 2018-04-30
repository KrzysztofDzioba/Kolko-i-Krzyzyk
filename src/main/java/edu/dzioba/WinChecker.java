package edu.dzioba;

public class WinChecker {

    private int winningSignNumber;
    private InputValidator validator;

    public WinChecker(int winningSignNumber, InputValidator validator) {
        this.winningSignNumber = winningSignNumber;
        this.validator = validator;
    }

    public boolean isWinner(Sign winningSign, Board board, Coordinates winningCoords) {
        int self = 1; // 1 because given sign is counting here
        int signsOnDownRight = signsInARowCounter(winningSign, board, winningCoords, 1, 1);
        int signsOnRight = signsInARowCounter(winningSign, board, winningCoords, 0, 1);
        int signsOnRightUp = signsInARowCounter(winningSign, board, winningCoords, -1, 1);
        int signsUp = signsInARowCounter(winningSign, board, winningCoords, -1, 0);
        int signsOnLeftUp = signsInARowCounter(winningSign, board, winningCoords, -1, -1);
        int signsOnLeft = signsInARowCounter(winningSign, board, winningCoords, 0, -1);
        int signsOnLeftDown = signsInARowCounter(winningSign, board, winningCoords, 1, -1);
        int signsOnDown = signsInARowCounter(winningSign, board, winningCoords, 1, 0);
        return self + signsOnDownRight + signsOnLeftUp >= winningSignNumber ||
                self + signsOnRight + signsOnLeft >= winningSignNumber ||
                self + signsOnRightUp + signsOnLeftDown >= winningSignNumber ||
                self + signsUp + signsOnDown >= winningSignNumber;
    }

    private int signsInARowCounter(Sign winningSign, Board board, Coordinates winningCoords,
                                   int rowIncreaser, int colIncreaser) {
        int signsInARowCounter = 0;
        int coordsRow = winningCoords.getRow();
        int coordsCol = winningCoords.getCol();
        for(int row = coordsRow, col = coordsCol; coordsInBoard(board, row, col); row += rowIncreaser, col += colIncreaser) {
                if(board.getField(row, col) == winningSign)
                    signsInARowCounter++;
        }
        return signsInARowCounter;
    }

    private boolean coordsInBoard(Board board, int row, int col) {
        return validator.coordinatesInBoard(board.dimensions, new Coordinates(row, col));
    }

}
