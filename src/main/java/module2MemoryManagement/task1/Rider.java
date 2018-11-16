package module2MemoryManagement.task1;

public class Rider {

    private String name;

    public Rider() {
    }

    public Rider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                '}';
    }
}
