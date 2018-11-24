package module3SpringCore.task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
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
