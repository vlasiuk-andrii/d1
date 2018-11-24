package module3SpringCore.task1.service;

import module3SpringCore.task1.domain.Race;

import java.util.Random;

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
        Random r = new Random(System.currentTimeMillis());
        race.setAmountOfHorses(r.nextInt(5) + 2);
        race.setDurationInSeconds(r.nextInt(10) + 2);
    }

}
