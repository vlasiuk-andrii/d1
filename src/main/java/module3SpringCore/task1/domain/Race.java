package module3SpringCore.task1.domain;

public class Race {

    private int durationInSeconds;
    private int amountOfHorses;
    private Horse winner;

    public Race() {
    }

    public Race(int durationInSeconds, int amountOfHorses) {
        this.durationInSeconds = durationInSeconds;
        this.amountOfHorses = amountOfHorses;
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

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public int getAmountOfHorses() {
        return amountOfHorses;
    }

    public void setAmountOfHorses(int amountOfHorses) {
        this.amountOfHorses = amountOfHorses;
    }
}
