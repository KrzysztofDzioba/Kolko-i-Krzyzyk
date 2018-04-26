package edu.dzioba;

import java.util.function.Consumer;

public class Journalist {
    private final Language language;
    private Consumer<String> output;

    public Journalist(Language language, Consumer<String> output) {
        this.language = language;
        this.output = output;
    }

    public Language getLanguage() {
        return language;
    }

    public String sayMessage(String messsage) {
        output.accept(messsage);
        return messsage;
    }

}
