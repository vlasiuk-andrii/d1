package module3SpringCore.task1.service;

import module3SpringCore.task1.domain.Race;

public class RaceService {
    private Race race;

    public RaceService() {
    }

    public RaceService(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }

    public void generateRacaData(){
        double random1 = Math.random();
        double random2 = Math.random();
        race.setAmountOfHorses((int) random1);
        race.setDurationInSeconds((int) random2);
    }

}
