package module3SpringCore.task2.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Race {

    private int durationInSeconds;
    private int amountOfHorses;
    private Horse winner;

    public Race() {
    }

    public Race getRace(){
        return this;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    @Autowired
    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public int getAmountOfHorses() {
        return amountOfHorses;
    }

    @Autowired
    public void setAmountOfHorses(int amountOfHorses) {
        this.amountOfHorses = amountOfHorses;
    }

    @Autowired
    public void setWinner(Horse winner) {
        this.winner = winner;
    }


}
