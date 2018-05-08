package edu.dzioba;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class Journalist {
    private Locale language;
    private Consumer<String> output;

    public Journalist(Locale language, Consumer<String> output) {
        this.language = language;
        this.output = output;
    }

    public String sayMessage(Messages message) {
        ResourceBundle bundle = ResourceBundle.getBundle("language", language);
        output.accept(bundle.getString(message.name()));
        return bundle.getString(message.name());
    }

    public String sayMessageWithParameters(Messages message, String... strings) {
        ResourceBundle bundle = ResourceBundle.getBundle("language", language);
        if(strings == null || strings.length == 0) {
            output.accept(String.format(bundle.getString(message.name()), ""));
            return String.format(bundle.getString(message.name()), "");
        }
        String outputMessage = String.format(bundle.getString(message.name()), strings);
        output.accept(outputMessage);
        return outputMessage;
    }

}
