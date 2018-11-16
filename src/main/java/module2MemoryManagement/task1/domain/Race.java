package module2MemoryManagement.task1.domain;

public class Race {
    private int number;
    private Hourse winner;

    public Race() {
    }

    public Race(int number) {
        this.number = number;
    }

    public Race getRace(){
        return this;
    }

    public Hourse getWinner() {
        return winner;
    }

    public void setWinner(Hourse winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Race{" +
                "number=" + number +
                ", winner=" + winner +
                '}';
    }
}
