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

    public boolean properWinningNumber(String userInput) {
        try {
            Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
