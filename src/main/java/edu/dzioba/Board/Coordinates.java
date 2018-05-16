package edu.dzioba.Board;

public class Coordinates {
    private Integer row;
    private Integer col;

    public Coordinates(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * row.hashCode() + prime * col.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Coordinates)) {
            return false;
        }
        Coordinates cords = (Coordinates) o;
        return cords.row.equals(row) && cords.col.equals(col);
    }
}
