package module1LambdasStreams.task1;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class JavaFunctionalInterfacesImplementation {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        List<String> incorrectNames = Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");
        List<String> correctNames = Arrays.asList("John","Mark","Hanna");

        System.out.println("//------------");

        Supplier<String> supplier = ()->"supplierValue";
        System.out.println("Supplier: " + supplier.get());

        System.out.println("//------------");

        Predicate<String> predicate = (s)->s.startsWith("G");
        incorrectNames.stream()
                .filter(predicate)
                .forEach(System.out::println);

        System.out.println("//------------");

        Consumer<String> consumer = (name) -> System.out.println("Hello " + name);
        correctNames.forEach(consumer);

        System.out.println("//------------");

        UnaryOperator<String> toUpperCaesOperator = String::toUpperCase;
        correctNames.replaceAll(toUpperCaesOperator);
        correctNames.forEach(System.out::println);

        BinaryOperator<Integer> sumOperator = (i1, i2) -> i1 + i2;
        int sum = values.stream()
                .reduce(0, sumOperator);
        System.out.println("sum=" + sum);

        System.out.println("//------------");

        CustomInterface<Double> numberMaker1 = new CustomInterface<Double>() {
            @Override
            public Double perform(double i1, double i2) {
                return i1*10+i2;
            }
        };
        System.out.println("Inner anonymous class: " + numberMaker1.perform(4, 2) );

        CustomInterface<Double> numberMaker2 = (i1, i2) -> (i2*10+i1);
        System.out.println("Lambda implementation: " +  numberMaker2.perform(4, 2));

        System.out.println("1st default method: " + numberMaker2.standartisizeString("schwaRtsneGER"));
        System.out.println("2st default method: " + numberMaker2.cutLastLetter("schwaRtsneGER"));
        System.out.println("1st static method: " + CustomInterface.returnHardcodedString());
        System.out.println("2st static method: " + CustomInterface.concatenateStrings("Apple", "Pen"));

    }
}
