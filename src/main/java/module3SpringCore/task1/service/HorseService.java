package module3SpringCore.task1.service;

import module3SpringCore.task1.domain.Horse;

import java.util.List;

public class HorseService {
    private List<Horse> hourses;

    public HorseService(List<Horse> hourses) {
        this.hourses = hourses;
    }

    public List<Horse> getHourses() {
        return hourses;
    }

    public void setHourses(List<Horse> hourses) {
        this.hourses = hourses;
    }

}
