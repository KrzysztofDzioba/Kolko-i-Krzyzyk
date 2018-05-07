package edu.dzioba;

public enum Sign {
    X,
    O;

    public static Sign getOppositeSign(Sign winningSign) {
        if(winningSign == Sign.X)
            return Sign.O;
        else
            return Sign.X;
    }
}
