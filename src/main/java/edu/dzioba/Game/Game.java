package edu.dzioba.Game;

import edu.dzioba.Board.Board;
import edu.dzioba.Board.BoardDimensions;

public class Game {

    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public Game(){}

    public Board getBoard() {
        return board;
    }

    public void setNewBoard(BoardDimensions dimensions) {
        this.board = new Board(dimensions);
    }
}
