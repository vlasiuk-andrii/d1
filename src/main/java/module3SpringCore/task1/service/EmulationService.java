package module3SpringCore.task1.service;

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
    public Integer getWinnerId(){
        return currentOrder.get(0);
    }

    public List<Integer> generateNewOrder(){
        Collections.shuffle(currentOrder);
        return currentOrder;
    }
}
