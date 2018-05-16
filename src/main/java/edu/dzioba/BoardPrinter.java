package edu.dzioba;

public class BoardPrinter {
    private Board board;
    private Journalist journalist;

    public BoardPrinter(Board board, Journalist journalist) {
        this.board = board;
        this.journalist = journalist;
    }

    public String printBoard() {
        int boardWidth = this.board.dimensions.width;
        int boardHeight = this.board.dimensions.height;
        StringBuilder boardToPrint = new StringBuilder();

        StringBuilder highestRow = getPrintedHighestRow(boardWidth);
        StringBuilder restOfTheBoard = getPrintedRows(boardWidth, boardHeight);

        boardToPrint.append(highestRow.toString());
        boardToPrint.append(restOfTheBoard.toString());

        String boardStr = boardToPrint.toString();
        journalist.sayMessage(boardStr);
        return boardStr;
    }

    private StringBuilder getPrintedRows(int boardWidth, int boardHeight) {
        StringBuilder middleBoard = new StringBuilder();
        for(int row = 1; row <= boardHeight; row++) {
            middleBoard.append(rowNumber(row));
            for(int col = 1; col <= boardWidth; col++) {
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
        int boardHeight = board.dimensions.height;
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
        int boardWidth = board.dimensions.width;
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
        int boardWidth = board.dimensions.width;
        int colDigitNumber = String.valueOf(boardWidth).length();

        StringBuilder builder = new StringBuilder();

        builder.append(" ");
        if(sign == null){
            builder.append(" ");//empty sign, because sign is null
            for(int i = 0; i < colDigitNumber; i++)
                builder.append(" ");
            builder.append("|");
        }
        else if (sign.name().equals("O")) {
            builder.append(sign.name());
            for(int i = 0; i < colDigitNumber; i++)
                builder.append(" ");
            builder.append("|");
        }
        else {
            builder.append(sign.name());
            for(int i = 0; i < colDigitNumber; i++)
                builder.append(" ");
            builder.append("|");
        }
        return builder.toString();
    }

}
