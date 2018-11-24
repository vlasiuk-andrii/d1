package module2MemoryManagement.task1;

public class OomeMetaspace {

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String args[]) throws Exception
    {
        for (int i = 0; i < 1000000000; i++) {
            Class c = cp.makeClass("com.saket.demo.Metaspace" + i).toClass();
            System.out.println("i = [" + i + "]");
        }
    }

//    https://www.geeksforgeeks.org/understanding-outofmemoryerror-exception-java/
}