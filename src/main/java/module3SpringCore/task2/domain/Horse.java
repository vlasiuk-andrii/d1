package module3SpringCore.task2.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Horse {

    private Rider rider;
    private Breed breed;
    private int raiting;

    private int id;

    public Horse() {
    }

    public Horse(Rider rider, Breed breed, int raiting) {
        this.rider = rider;
        this.breed = breed;
        this.raiting = raiting;
    }

    public Rider getRider() {
        return rider;
    }

    @Autowired
    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Breed getBreed() {
        return breed;
    }

    @Autowired
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public int getRaiting() {
        return raiting;
    }

    @Autowired
    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getId() {
        return id;
    }

    @Autowired
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", rider=" + rider +
                ", breed=" + breed +
                ", raiting=" + raiting +
                '}';
    }
}
