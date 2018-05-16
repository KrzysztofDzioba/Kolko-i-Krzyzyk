package edu.dzioba.UserInputHandling;

import edu.dzioba.Board.BoardDimensions;
import edu.dzioba.Board.Coordinates;
import edu.dzioba.CustomExceptions.ValueZeroOrLessException;

public class InputConverter {

    public BoardDimensions getBoardSize(String userInput) throws NumberFormatException {
        String[] values = userInput.split(",");
        if(values.length == 1 || values.length == 0)
            throw new NumberFormatException();
        int width = Integer.valueOf(values[0]);
        int height = Integer.valueOf(values[1]);
        if(width < 1 || height < 1)
            throw new ValueZeroOrLessException();
        return new BoardDimensions(width, height);
    }

    public Coordinates getCoordinates(String userInput) {
        String[] cordsStr = userInput.split(" ");
        return new Coordinates(Integer.valueOf(cordsStr[0]), Integer.valueOf(cordsStr[1]));
    }

    public Integer parseToInteger(String input) throws NumberFormatException{
        return Integer.valueOf(input);
    }

    public String[] splitStringIntoCoordinates(String userInput) {
        return userInput.split(" ");
    }
}
