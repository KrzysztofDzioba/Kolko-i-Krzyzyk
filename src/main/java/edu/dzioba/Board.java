package edu.dzioba;

public class Board {

    private Sign[][] fields;
    int width;
    int height;

    public Board(int[] dimensions) {
        this.fields = new Sign[dimensions[0]][dimensions[1]];
        createBoardFields(dimensions);
        this.width = fields[0].length;
        this.height = fields[1].length;
    }

    public Sign[][] getFields() {
        return fields;
    }

    private void createBoardFields(int[] dimensions) {
        for(int i = 0; i < dimensions[0]; i++) {
            for(int c = 0; c < dimensions[1]; c++) {
                fields[i][c] = Sign.EMPTY;
            }
        }
    }
}
