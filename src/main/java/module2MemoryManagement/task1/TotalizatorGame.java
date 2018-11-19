package module2MemoryManagement.task1;

import module2MemoryManagement.task1.domain.Horse;
import module2MemoryManagement.task1.domain.Race;
import module2MemoryManagement.task1.service.EmulationService;
import module2MemoryManagement.task1.service.HorseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class TotalizatorGame {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");

        printWithDelay("\nYou are welcome to the Totalizator Game!\n");
        printWithDelay("Choose you horse please:\n");

        HorseService horseService = (HorseService) context.getBean("HorseService");
        EmulationService emulationService = (EmulationService) context.getBean("EmulationService");
        horseService.getHourses().forEach(System.out::println);

        printWithDelay("Enter horseId: ");
        Scanner scanner = new Scanner(System.in);
        Integer choosenHorseId = scanner.nextInt();

        Horse choosenHorse = horseService.getHourses().stream()
                .filter(horse -> horse.getId() == choosenHorseId)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No horse with such ID\n GAME OVER"));

        printWithDelay("Your choice is " + choosenHorse.toString());
        printWithDelay("\n  --- Let's play the game ---");

        //Race race = (Race) context.getBean("Race");

        emulationService.setInitialValues(horseService.getHourses().stream()
                .map(Horse::getId)
                .collect(Collectors.toList()));
        printWithDelay(emulationService.generateNewOrder().toString());
        printWithDelay(emulationService.generateNewOrder().toString());
        printWithDelay(emulationService.generateNewOrder().toString());
        printWithDelay(emulationService.generateNewOrder().toString());


    }

    static void printWithDelay(String data) throws InterruptedException {
        for (char ch:data.toCharArray()) {
            MILLISECONDS.sleep(20);
            System.out.print(ch);
        }
    }

    static void printWithSecondDelay(String data) throws InterruptedException {
        MILLISECONDS.sleep(1000);
        System.out.println(data);
    }
}
