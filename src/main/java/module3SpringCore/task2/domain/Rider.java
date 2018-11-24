package module3SpringCore.task2.domain;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
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
