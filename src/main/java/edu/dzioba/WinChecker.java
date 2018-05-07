package edu.dzioba;

public class WinChecker {

    private int winningSignNumber;
    private InputValidator validator;

    public WinChecker(int winningSignNumber, InputValidator validator) {
        this.winningSignNumber = winningSignNumber;
        this.validator = validator;
    }

    public boolean isWinner(Board board, Coordinates winningCoords) {
        int self = 1; // 1 because given sign is counting here
        int signsOnDownRight = signsInARowCounter(board, winningCoords, 1, 1);
        int signsOnRight = signsInARowCounter(board, winningCoords, 0, 1);
        int signsOnRightUp = signsInARowCounter( board, winningCoords, -1, 1);
        int signsUp = signsInARowCounter(board, winningCoords, -1, 0);
        int signsOnLeftUp = signsInARowCounter( board, winningCoords, -1, -1);
        int signsOnLeft = signsInARowCounter(board, winningCoords, 0, -1);
        int signsOnLeftDown = signsInARowCounter(board, winningCoords, 1, -1);
        int signsOnDown = signsInARowCounter(board, winningCoords, 1, 0);

        return self + signsOnDownRight + signsOnLeftUp >= winningSignNumber ||
                self + signsOnRight + signsOnLeft >= winningSignNumber ||
                self + signsOnRightUp + signsOnLeftDown >= winningSignNumber ||
                self + signsUp + signsOnDown >= winningSignNumber;
    }

    private int signsInARowCounter(Board board, Coordinates winningCoords,
                                   int rowIncreaser, int colIncreaser) {
        int signsInARowCounter = 0;
        Sign winningSign = board.getField(winningCoords);
        int coordsRow = winningCoords.getRow();
        int coordsCol = winningCoords.getCol();
        Sign oppositeSign = Sign.getOppositeSign(winningSign);
        for(int row = coordsRow + rowIncreaser, col = coordsCol + colIncreaser; coordsInBoard(board, row, col); row += rowIncreaser, col += colIncreaser) {
                Sign fieldChecking = board.getField(row, col);
                if(fieldChecking == winningSign)
                    signsInARowCounter++;
                else if(fieldChecking == oppositeSign || fieldChecking == null)
                    break;
        }
        return signsInARowCounter;
    }

    private boolean coordsInBoard(Board board, int row, int col) {
        return validator.coordinatesInBoard(board.dimensions, new Coordinates(row, col));
    }

}
