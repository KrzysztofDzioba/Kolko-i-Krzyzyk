package edu.dzioba;

import java.util.Locale;

public enum Language {
    en{
        @Override
        Locale getLocale() {
            return Locale.ENGLISH;
        }
    },
    pl{
        @Override
        Locale getLocale() {
            return new Locale("pl", "PL");
        }
    };

    abstract Locale getLocale();
}
