package edu.dzioba;

public class Board {

    private Sign[][] fields;
    int width;
    int height;

    public Board(BoardDimensions dimensions) {
        this.fields = new Sign[dimensions.width][dimensions.height];
        createBoardFields(dimensions);
        this.width = dimensions.width;
        this.height = dimensions.height;
    }

    public Sign[][] getFields() {
        return fields;
    }

    private void createBoardFields(BoardDimensions dimensions) {
        for(int i = 0; i < dimensions.width; i++) {
            for(int c = 0; c < dimensions.height; c++) {
                fields[i][c] = Sign.EMPTY;
            }
        }
    }
}
