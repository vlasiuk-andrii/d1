package module1LambdasStreams.task1;

import java.util.function.Supplier;

public class JavaFunctionalInterfacesImplementation {

    public static void main(String[] args) {
        Supplier<String> supplier = ()->"supplierValue";

        System.out.println(supplier.get());
    }
}
