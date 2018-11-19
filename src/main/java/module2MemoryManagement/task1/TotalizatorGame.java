package module2MemoryManagement.task1;

import module2MemoryManagement.task1.domain.Horse;
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

        printCharsWithDelay("\nYou are welcome to the Totalizator Game!\n");
        printCharsWithDelay("Choose you horse please:\n");

        HorseService horseService = (HorseService) context.getBean("HorseService");
        EmulationService emulationService = (EmulationService) context.getBean("EmulationService");
        horseService.getHourses().forEach(System.out::println);

        printCharsWithDelay("Enter horseId: ");
        Scanner scanner = new Scanner(System.in);
        Integer choosenHorseId = scanner.nextInt();

        Horse choosenHorse = horseService.getHourses().stream()
                .filter(horse -> horse.getId() == choosenHorseId)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No horse with such ID\n GAME OVER"));

        printCharsWithDelay("Your choice is " + choosenHorse.toString());
        printCharsWithDelay("\n\n  --- Let's play the game ---\n");
        printCharsWithDelay("\n  1   2   3   4\n");

        //Race race = (Race) context.getBean("Race");

        emulationService.setInitialValues(horseService.getHourses().stream()
                .map(Horse::getId)
                .collect(Collectors.toList()));
        printWithSecondDelay(emulationService.generateNewOrder().toString());
        printWithSecondDelay(emulationService.generateNewOrder().toString());
        printWithSecondDelay(emulationService.generateNewOrder().toString());
        printWithSecondDelay(emulationService.generateNewOrder().toString());

        printCharsWithDelay("The WINNER is - " + horseService.getHourses().stream()
            .filter(horse -> horse.getId() == emulationService.getWinnerId())
            .findFirst()
            .map(Horse::toString));

        if (emulationService.getWinnerId() == choosenHorseId){
            printCharsWithDelay("\n\nYOU WON!!! Congratulations!!!");
        } else {
            printCharsWithDelay("\n\nYou loose.. GAME OVER");
        }

    }

    private static void printCharsWithDelay(String data) throws InterruptedException {
        for (char ch:data.toCharArray()) {
            MILLISECONDS.sleep(40);
            System.out.print(ch);
        }
    }

    private static void printWithSecondDelay(String data) throws InterruptedException {
        MILLISECONDS.sleep(2000);
        System.out.println(data);
    }
}
