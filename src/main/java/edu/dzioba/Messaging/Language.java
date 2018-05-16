package edu.dzioba.Messaging;

import java.util.Locale;

public enum Language {
    en{
        @Override
        public Locale getLocale() {
            return Locale.ENGLISH;
        }
    },
    pl{
        @Override
        public Locale getLocale() {
            return new Locale("pl", "PL");
        }
    };

    public abstract Locale getLocale();
}
