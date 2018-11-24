package module2MemoryManagement.task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OomeJavaHeap {

//    Task 1
//    The parallel collector will throw an OutOfMemoryError if too much time is being spent in garbage collection: if more than 98% of the total time is spent in garbage collection and less than 2% of the heap is recovered
    public static void main(String[] argv) throws Exception
    {
        List<Object> fixedData = consumeAvailableMemory();
        while (true)
        {
            Object data = new byte[64 * 1024 - 1];
        }
    }

    private static List<Object> consumeAvailableMemory() throws Exception
    {
        LinkedList<Object> holder = new LinkedList<Object>();
        while (true)
        {
            try
            {
                holder.add(new byte[128 * 1024]);
            }
            catch (OutOfMemoryError ex)
            {
                holder.removeLast();
                return holder;
            }
        }
    }

}
