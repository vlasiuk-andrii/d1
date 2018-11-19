package module2MemoryManagement.task1.domain;

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

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getId() {
        return id;
    }

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
