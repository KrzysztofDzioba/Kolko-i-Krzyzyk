package edu.dzioba;

public enum BoardField {
    O {
        @Override
        BoardField sign() {
            return X;
        }
    }, X {
        @Override
        BoardField sign() {
            return O;
        }
    }, EMPTY {
        @Override
        BoardField sign() {
            return EMPTY;
        }
    };

    abstract BoardField sign();
}
