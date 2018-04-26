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

}
