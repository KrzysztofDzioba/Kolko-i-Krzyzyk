package edu.dzioba;

public class WinChecker {

    private int winningSignNumber;
    private InputValidator validator;

    public WinChecker(int winningSignNumber, InputValidator validator) {
        this.winningSignNumber = winningSignNumber;
        this.validator = validator;
    }

    public boolean isWinner(Sign winningSign, Board board, Coordinates winningCoords) {
        int leftUpRightDownSignsCounter = 1; // 1 because given sign is counting here
        leftUpRightDownSignsCounter += signsLeftUpToSign(winningSign, board, winningCoords);
        return leftUpRightDownSignsCounter == 3;
    }

    private int signsLeftUpToSign(Sign winningSign, Board board, Coordinates winningCoords) {
        int signsInARowCounter = 0;
        for(int row = 1, col = 1; validator.coordinatesInBoard(board.dimensions, new Coordinates(row, col)); row++, col++) {
            Coordinates coords = new Coordinates(row, col);
            if(board.getField(coords) == winningSign)
                signsInARowCounter++;
        }
        return signsInARowCounter;
    }

}
