package edu.dzioba;

public class InputConverter {

    public int[] getBoardSize(String userInput) throws NumberFormatException {
        String[] values = userInput.split(", ");
        int width = Integer.valueOf(values[0]);
        int height = Integer.valueOf(values[1]);
        return new int[]{width, height};
    }
}
