package module3SpringCore.task2;

import module3SpringCore.task2.domain.Horse;
import module3SpringCore.task2.service.EmulationService;
import module3SpringCore.task2.service.HorseService;
import module3SpringCore.task2.service.RaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Horse getHorse1(){
        return new Horse();
    }

    @Bean
    public Horse getHorse2(){
        return new Horse();
    }

    @Bean
    public Horse getHorse3(){
        return new Horse();
    }

    @Bean
    public HorseService getHorseService(){
        List<Horse> initialHorses = new ArrayList<>();
        initialHorses.add(getHorse1());
        initialHorses.add(getHorse2());
        initialHorses.add(getHorse3());
        return new HorseService(initialHorses);
    }

    @Bean
    public EmulationService getEmulationService(){
        return new EmulationService();
    }

    @Bean
    public RaceService getRaceService(){
        return new RaceService();
    }
}
