package edu.dzioba;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Coordinates, Sign> fields;
    int width;
    int height;

    public Board(BoardDimensions dimensions) {
        this.fields = new HashMap<>();
        this.width = dimensions.width;
        this.height = dimensions.height;
    }

    public void insertCoordinates(Coordinates coordinates, Sign sign) {
        fields.put(coordinates, sign);
    }

    public Sign getField(Coordinates cords) {
        return fields.get(cords);
    }

}
