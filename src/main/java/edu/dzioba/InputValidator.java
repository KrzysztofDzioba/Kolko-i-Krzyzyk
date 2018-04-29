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

    public boolean properCoordinates(String userInput) {
        String[] coordinatesStr = userInput.split(" ");
        try {
            Integer.valueOf(coordinatesStr[0]);
            Integer.valueOf(coordinatesStr[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
