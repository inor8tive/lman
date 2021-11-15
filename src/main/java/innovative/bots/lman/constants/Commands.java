package innovative.bots.lman.constants;

public enum Commands {
    SYNONYMS("synonyms", "Retrieve synonyms of any English word"),
    ANTONYMS("antonyms", "Retrieve opposites of any English word");

    public String name;
    public String description;

    Commands(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
