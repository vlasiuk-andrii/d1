package module3SpringCore.task1;

import module3SpringCore.task1.domain.Horse;
import module3SpringCore.task1.service.EmulationService;
import module3SpringCore.task1.service.HorseService;
import module3SpringCore.task1.service.RaceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class TotalizatorGame {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");

        printCharsWithDelay("\nYou are welcome to the Totalizator Game!\n");
        printCharsWithDelay("Choose you horse please:\n");

        HorseService horseService = (HorseService) context.getBean("HorseService");
        EmulationService emulationService = (EmulationService) context.getBean("EmulationService");
        RaceService raceService = (RaceService) context.getBean("RaceService");
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
        raceService.generateRacaData();

        int amountOfHorses = raceService.getRace().getAmountOfHorses();
        printCharsWithDelay("Amount of horses: " + amountOfHorses +
                "  Duration:" + raceService.getRace().getDurationInSeconds());
        printPlaces(amountOfHorses);

        emulationService.setInitialValues(horseService.getRaceHourses(choosenHorseId, amountOfHorses).stream()
                .map(Horse::getId)
                .collect(Collectors.toList()));

        printResultsOfGame(emulationService, raceService.getRace().getDurationInSeconds());

        printCharsWithDelay("The WINNER is - " + horseService.getHourses().stream()
            .filter(horse -> horse.getId() == emulationService.getWinnerId())
            .findFirst()
            .map(Horse::toString)
            .get());

        if (emulationService.getWinnerId() == choosenHorseId){
            printCharsWithDelay("\n\nYOU WON!!! Congratulations!!!");
        } else {
            printCharsWithDelay("\n\nYou lose.. GAME OVER");
        }

    }

    private static void printResultsOfGame(EmulationService emulationService, int durationInSeconds) throws InterruptedException {
        System.out.println();
        do {
            printWithSecondDelay(emulationService.generateNewOrder().toString());
            durationInSeconds--;
        } while (durationInSeconds > 0);
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

    private static void printPlaces(int total) {
        System.out.println();
        IntStream.range(1, total + 1)
                .forEach(i -> System.out.print(" " + String.valueOf(i) + "  "));
    }
}
