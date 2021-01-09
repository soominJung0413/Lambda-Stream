package Lambda.predicate;

import Lambda.function.FunctionTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Soo min",29),
                new Person("Jung jin", 29)
        );
        BiPredicate<Person,Person> personPredicate  = (person1,person2) -> person1.getAge() == person2.getAge();

        BiPredicate<Person,Person> ageBiPredicate = (person, person2) -> person.getName().equals(person2.getName());

        BiPredicate<Person, Person> compositePredicate = personPredicate.and(ageBiPredicate);


        System.out.println(compositePredicate.test(people.get(0),people.get(1))); //false

        //isEqual
        Predicate condition = Predicate.isEqual("Java 8");

        System.out.println(condition.test("Java 8")); // true
    }
}
