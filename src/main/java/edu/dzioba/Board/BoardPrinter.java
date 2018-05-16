package edu.dzioba.Board;

import edu.dzioba.Messaging.Journalist;
import edu.dzioba.Players.Sign;

public class BoardPrinter {
    private Board board;
    private Journalist journalist;

    public BoardPrinter(Board board, Journalist journalist) {
        this.board = board;
        this.journalist = journalist;
    }

    public String printBoard() {
        BoardDimensions dimensions = board.getDimensions();
        StringBuilder boardToPrint = new StringBuilder();

        StringBuilder highestRow = getPrintedHighestRow(dimensions.width);
        StringBuilder restOfTheBoard = getPrintedRows(dimensions);

        boardToPrint.append(highestRow.toString());
        boardToPrint.append(restOfTheBoard.toString());

        String boardStr = boardToPrint.toString();
        journalist.sayMessage(boardStr);
        return boardStr;
    }

    private StringBuilder getPrintedRows(BoardDimensions dimensions) {
        StringBuilder middleBoard = new StringBuilder();
        for(int row = 1; row <= dimensions.height; row++) {
            middleBoard.append(rowNumber(row));
            for(int col = 1; col <= dimensions.width; col++) {
                Sign currentField = board.getField(row, col);
                middleBoard.append(currentField(currentField));
            }
            middleBoard.append("\n");
        }
        return middleBoard;
    }

    private StringBuilder getPrintedHighestRow(int boardWidth) {
        StringBuilder highestRow = new StringBuilder();
        highestRow.append(rowNumber(0));
        for(int i = 1; i <= boardWidth; i++)
            highestRow.append(colNumber(i));
        highestRow.append("\n");
        return highestRow;
    }

    private String rowNumber(int currentRowNum){
        int boardHeight = board.getDimensions().height;
        int rowDigitNumber = String.valueOf(boardHeight).length();
        int currentRowDigitNumber = String.valueOf(currentRowNum).length();
        int currentSpaces = rowDigitNumber - currentRowDigitNumber;

        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(currentRowNum);
        for(int i = 0; i < currentSpaces; i++)
            builder.append(" ");
        builder.append(" |");
        return builder.toString();
    }

    private String colNumber(int currentColNum){
        int boardWidth = board.getDimensions().width;
        int colDigitNumber = String.valueOf(boardWidth).length();
        int currentColDigitNumber = String.valueOf(currentColNum).length();
        int currentSpaces = colDigitNumber - currentColDigitNumber;

        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(currentColNum);
        for(int i = 0; i < currentSpaces; i++)
            builder.append(" ");
        builder.append(" |");
        return builder.toString();
    }

    private String currentField(Sign sign) {
        int boardWidth = board.getDimensions().width;
        int colDigitNumber = String.valueOf(boardWidth).length();

        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(sign == null ? " " : sign.name());
        for(int i = 0; i < colDigitNumber; i++)
            builder.append(" ");
        builder.append("|");

        return builder.toString();
    }

}
