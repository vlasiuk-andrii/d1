package module3SpringCore.task1.service;

import module3SpringCore.task1.domain.Horse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseService {
    private List<Horse> hourses;

    public HorseService(List<Horse> hourses) {
        this.hourses = hourses;
    }

    public List<Horse> getHourses() {
        return hourses;
    }

    public List<Horse> getRaceHourses(int myHorseId, int amount) {
        List<Horse> raceHorses = new ArrayList<>(hourses);
        raceHorses.removeIf(horse -> horse.getId() == myHorseId);
        while (raceHorses.size() >= amount) {
            Collections.shuffle(raceHorses);
            raceHorses.remove(0);
        }
        Horse myHorse = hourses.stream()
                .filter(horse -> myHorseId == horse.getId())
                .findFirst()
                .get();
        raceHorses.add(myHorse);
        return raceHorses;
    }

    public void setHourses(List<Horse> hourses) {
        this.hourses = hourses;
    }

}
