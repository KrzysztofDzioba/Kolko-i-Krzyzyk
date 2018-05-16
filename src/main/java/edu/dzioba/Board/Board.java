package edu.dzioba.Board;

import edu.dzioba.Players.Sign;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Coordinates, Sign> fields;
    private BoardDimensions dimensions;
    private final int fieldsCount;

    public Board(BoardDimensions dimensions) {
        this.fields = new HashMap<>();
        this.dimensions = dimensions;
        fieldsCount = dimensions.height * dimensions.width;
    }

    public BoardDimensions getDimensions() {
        return dimensions;
    }

    public void insertCoordinates(Coordinates coordinates, Sign sign) {
        fields.put(coordinates, sign);
    }

    public Sign getField(Coordinates cords) {
        return fields.get(cords);
    }

    public Sign getField(int row, int col) {
        return getField(new Coordinates(row, col));
    }

    public void insertCoordinates(int row, int col, Sign sign) {
        insertCoordinates(new Coordinates(row, col), sign);
    }

    public boolean isDraw() {
        return fieldsCount == fields.size();
    }
}
