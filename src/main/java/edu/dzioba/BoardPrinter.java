package edu.dzioba;

public class BoardPrinter {
    private Board board;
    private Journalist journalist;

    public BoardPrinter(Board board, Journalist journalist) {
        this.board = board;
        this.journalist = journalist;
    }

    public void printBoard() {
        int boardWidth = this.board.dimensions.width;
        int boardHeight = this.board.dimensions.height;
        StringBuilder board = new StringBuilder();
        StringBuilder highestRow = new StringBuilder();
        highestRow.append("   |");
        for(int i = 1; i <= boardWidth; i++) {
            highestRow.append(" " + i + " |");
        }
    }
}
