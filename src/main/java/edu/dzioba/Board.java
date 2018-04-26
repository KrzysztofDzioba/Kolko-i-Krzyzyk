package edu.dzioba;

public class Board {

    private BoardField[][] fields;

    public Board(BoardField[][] fields) {
        this.fields = fields;
    }

    public BoardField[][] getFields() {
        return fields;
    }
}
