package Lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionTest {
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

        Function<Person,String> stringFunction = Person::getName;
        ToIntFunction<Person> toIntFunction = Person::getAge;

        //        Soo min
        //        Jung jin
        //        29
        //        29
        people.forEach(person -> System.out.println(stringFunction.apply(person)));

        people.forEach(person -> System.out.println(toIntFunction.applyAsInt(person)));

    }
}
