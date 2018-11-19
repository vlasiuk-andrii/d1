package module2MemoryManagement.task1.service;

import java.util.Collections;
import java.util.List;

public class EmulationService {

    private List<Integer> currentOrder;

    public EmulationService() {
    }

    public EmulationService(List<Integer> currentOrder) {
        this.currentOrder = currentOrder;
    }

    public void setInitialValues(List<Integer> initialValues){
        currentOrder = initialValues;
    }

    public List<Integer> generateNewOrder(){
        Collections.shuffle(currentOrder);
        return currentOrder;
    }
}
