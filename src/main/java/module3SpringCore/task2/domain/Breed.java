package module3SpringCore.task2.domain;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
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
