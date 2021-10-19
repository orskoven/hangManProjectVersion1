import java.util.ArrayList;
import java.util.Collection;

public class Frogs {
    private String name;

    public Frogs(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Frogs{" +
                "name='" + name + '\'' +
                '}';
    }
}
