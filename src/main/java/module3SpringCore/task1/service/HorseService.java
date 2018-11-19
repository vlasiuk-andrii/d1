package module3SpringCore.task1.service;

import module3SpringCore.task1.domain.Horse;

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

    public List<Horse> getRaceHourses(int amount) {
        List<Horse> raceHorses = hourses;
        do {
            Collections.shuffle(raceHorses);
            raceHorses.remove(0);
        } while (raceHorses.size() > amount);
        return raceHorses;
    }

    public void setHourses(List<Horse> hourses) {
        this.hourses = hourses;
    }

}
