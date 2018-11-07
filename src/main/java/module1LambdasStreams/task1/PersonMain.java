package module1LambdasStreams.task1;

import java.util.Arrays;
import java.util.Comparator;

public class PersonMain {

    public static void main(String[] args) {
        Person[] persons = new Person[]{new Person("Peter", "24"),
                                        new Person("Kate","31"),
                                        new Person("John","30"),
                                        new Person("Tatiana", "19"),
                                        new Person("Donald", "54")};
        Arrays.stream(persons).forEach(person -> System.out.println( person.getName() + "  " + person.getAge()));

        Comparator<Person> byName = Comparator.comparing( (Person person) ->  person.getName() );
        Comparator<Person> byAge = Comparator.comparing( (Person person) -> person.getAge());

//        Arrays.sort(persons, new Comparator<Person>() {
//            public int compare(Person o1, Person o2) {
//                return o1.getName().compareTo( o2.getName() );
//            }
//        });
//        Arrays.sort(persons, Comparator.comparing( (Person person) ->  person.getName() ));
//        Arrays.sort(persons, Comparator.comparing( Person::getAge ));

        Arrays.sort(persons, byName);
        System.out.println("---- ByName:");
        Arrays.stream(persons).forEach(person -> System.out.println( person.getName() + "  " + person.getAge()));

        Arrays.sort(persons, byAge);
        System.out.println("---- ByAge:");
        Arrays.stream(persons).forEach( person -> System.out.println( person.getName() + "  " + person.getAge()));

    }

}
