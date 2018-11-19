package module2MemoryManagement.task1.domain;

public class Race {
    private int durationInSeconds;
    private Horse winner;

    public Race() {
    }

    public Race(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Race getRace(){
        return this;
    }

    public Horse getWinner() {
        return winner;
    }

    public void setWinner(Horse winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Race{" +
                "durationInSeconds=" + durationInSeconds +
                ", winner=" + winner +
                '}';
    }
}
