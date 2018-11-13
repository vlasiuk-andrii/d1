package module1LambdasStreams.task3;

public class Main {

    public static void main(String[] args) {

        ThreeFunction<Double> threeFunction1 = (x1, x2, x3) -> x1 * x2 + x3 ;
        ThreeFunction<Double> threeFunction2 = (x1, x2, x3) -> x1 + x2 * x3 ;

        System.out.println("First  implementation: " + threeFunction1.act(1.0, 2.0, 3.0));
        System.out.println("Second implementation: " + threeFunction2.act(1.0, 2.0, 3.0));
    }
}
