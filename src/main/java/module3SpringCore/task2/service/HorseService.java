package module3SpringCore.task2.service;

import module3SpringCore.task2.domain.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
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

    @Autowired
    public void setHourses(List<Horse> hourses) {
        this.hourses = hourses;
    }

}
