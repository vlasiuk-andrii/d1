package module2MemoryManagement.task1;

import module2MemoryManagement.task1.domain.Hourse;
import module2MemoryManagement.task1.service.HourseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TotalizatorGame {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Hourse horse = (Hourse) context.getBean("Hourse1");
        System.out.println(horse.toString());
        HourseService hourseService = (HourseService) context.getBean("HourseService");
        System.out.println(hourseService.hourses);
    }
}
