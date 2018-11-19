package module3SpringCore.task1.domain;

public class Breed {

    private String name;

    public Breed(String name) {
        this.name = name;
    }

    public Breed() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                '}';
    }
}
