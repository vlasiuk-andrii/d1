package module2MemoryManagement.task1;

public class Race {
    private int number;

    public Race() {
    }

    public Race(int number) {
        this.number = number;
    }

    public Race getRace(){
        return this;
    }

    @Override
    public String toString() {
        return "Race{" +
                "number=" + number +
                '}';
    }
}
