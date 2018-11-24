package module2MemoryManagement.task1;

public class StackOverflowRecursion {

    public static void main(String[] args) {
        System.out.println(antiFibonacci(1));
    }

    static int antiFibonacci(int n)  {
        System.out.println(n);
        if(n == 100)
            return 9;
        else
            return antiFibonacci(n + 1) * antiFibonacci(n + 2);
    }
}
