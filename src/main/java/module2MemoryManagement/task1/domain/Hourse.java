package module2MemoryManagement.task1.domain;

public class Hourse {

    private Rider rider;
    private Breed breed;
    private int power;

    public Hourse() {
    }

    public Hourse(Rider rider, Breed breed, int power) {
        this.rider = rider;
        this.breed = breed;
        this.power = power;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Hourse{" +
                "rider=" + rider +
                ", breed=" + breed +
                ", power=" + power +
                '}';
    }
}
