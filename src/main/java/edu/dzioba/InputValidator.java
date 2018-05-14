package edu.dzioba;

public class InputValidator {

    private InputConverter converter;

    public InputValidator(InputConverter converter) {
        this.converter = converter;
    }

    public InputValidator() {
    }

    public boolean properBoardSizeInput(String boardSize) {
        BoardDimensions boardDimensions;
        try {
            boardDimensions = converter.getBoardSize(boardSize);
        } catch (NumberFormatException e){
            return false;
        }
        return !(boardDimensions.height > 100 || boardDimensions.width > 100);
    }

    public boolean properWinningNumber(String userInput, BoardDimensions dimensions) {
        Integer value;
        try {
            value = converter.parseToInteger(userInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return !(value > Math.max(dimensions.width, dimensions.height)) && value > 0;
    }

    public boolean properCoordinatesSchema(String userInput) {
        String[] coordinatesStr;
        if(userInput == null)
            return false;
        coordinatesStr = converter.splitStringIntoCoordinates(userInput);
        if(coordinatesStr.length == 1 || coordinatesStr.length == 0)
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
