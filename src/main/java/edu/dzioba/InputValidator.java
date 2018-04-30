package edu.dzioba;

public class InputValidator {

    private InputConverter converter;

    public InputValidator(InputConverter converter) {
        this.converter = converter;
    }

    public boolean properBoardSizeInput(String boardSize) {
        try {
            converter.getBoardSize(boardSize);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean properWinningNumber(String userInput, BoardDimensions dimensions) {
        Integer value;
        try {
            value = Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return !(value > Math.max(dimensions.width, dimensions.height));
    }

    public boolean properCoordinatesSchema(String userInput) {
        if(userInput == null)
            return false;
        String[] coordinatesStr = userInput.split(" ");
        if(coordinatesStr.length == 1)
            return false;
        try {
            Integer.valueOf(coordinatesStr[0]);
            Integer.valueOf(coordinatesStr[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean coordinatesInBoard(BoardDimensions dimensions, Coordinates cords) {
        return cords.getRow() <= dimensions.height && cords.getCol() <= dimensions.width &&
               (cords.getRow() >= 1 && cords.getCol() >= 1);
    }

    public boolean coordsAreEmptyInBoard(Board board, Coordinates coords) {
        return board.getField(coords) == null;
    }
}
