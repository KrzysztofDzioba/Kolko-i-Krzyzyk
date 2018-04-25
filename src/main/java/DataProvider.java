import java.util.function.Consumer;

public class DataProvider {


    private final Consumer<String> provider;

    public DataProvider(Consumer<String> provider) {
        this.provider = provider;
    }

    public String getUserInput() {
        return "";
    }
}
