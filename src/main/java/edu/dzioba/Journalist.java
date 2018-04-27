package edu.dzioba;

public class Journalist {
    private final Language language;

    public Journalist(Language language) {
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public String sayMessage(String messsage) {
        System.out.println(messsage);
        return messsage;
    }

    public String sayMessageWithParameters(String message, String... strings) {
        if(strings == null || strings.length == 0) {
            System.out.println(String.format(message, ""));
            return String.format(message, "");
        }
        String outputMessage = String.format(message, strings);
        System.out.println(outputMessage);
        return outputMessage;
    }

}
