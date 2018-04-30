package edu.dzioba;

public class InputConverter {

    public BoardDimensions getBoardSize(String userInput) throws NumberFormatException {
        String[] values = userInput.split(",");
        int width = Integer.valueOf(values[0]);
        int height = Integer.valueOf(values[1]);
        return new BoardDimensions(width, height);
    }

    public Coordinates getCoordinates(String userInput) {
        String[] cordsStr = userInput.split(" ");
        return new Coordinates(Integer.valueOf(cordsStr[0]), Integer.valueOf(cordsStr[1]));
    }

}
