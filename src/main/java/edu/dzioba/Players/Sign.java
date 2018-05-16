package edu.dzioba.Players;

public enum Sign {
    X{
        public Sign getOppositeSign() {
            return Sign.O;
        }
    },
    O{
        public Sign getOppositeSign() {
            return Sign.X;
        }
    };

    public abstract Sign getOppositeSign();
}
