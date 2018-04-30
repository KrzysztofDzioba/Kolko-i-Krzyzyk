package edu.dzioba;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Coordinates, Sign> fields;
    BoardDimensions dimensions;

    public Board(BoardDimensions dimensions) {
        this.fields = new HashMap<>();
        this.dimensions = dimensions;
    }

    public void insertCoordinates(Coordinates coordinates, Sign sign) {
        fields.put(coordinates, sign);
    }

    public Sign getField(Coordinates cords) {
        return fields.get(cords);
    }

    public void insertCoordinates(int row, int col, Sign sign) {
        insertCoordinates(new Coordinates(row, col), sign);
    }
}
