package stream.basic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectionGroup {
    static class Student {
        private String name;
        private String className;
        private int score;
        private boolean graduated;

        public Student(String name, String className, int score, boolean graduated) {
            this.name = name;
            this.className = className;
            this.score = score;
            this.graduated = graduated;
        }

        public String getName() {
            return name;
        }

        public String getClassName() {
            return className;
        }

        public int getScore() {
            return score;
        }

        public boolean isGraduated() {
            return graduated;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", className='" + className + '\'' +
                    ", score=" + score +
                    ", graduated=" + graduated +
                    '}';
        }
    }

    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("정수민","D",50,false),
                new Student("신용권","C",92,true),
                new Student("남궁성","B",95,true),
                new Student("최범균","A", 97,true)
        );
        Map<String, Map<String, Map<Boolean, List<Student>>>> collect =
                studentStream
                        .collect(
                                groupingBy(Student::getClassName,
                                        groupingBy(Student::getName,
                                                partitioningBy(Student::isGraduated))));

        //Student{name='정수민', className='D', score=50, graduated=false}
        collect.get("D").get("정수민").get(false)
                .forEach(System.out::println);

        Map<String, Map<Boolean, Map<Boolean, List<Student>>>> collect2 = studentStream
                .collect(
                        groupingBy(Student::getClassName,
                                partitioningBy(s -> s.getScore() > 92,
                                        partitioningBy(Student::isGraduated))));

        //Student{name='남궁성', className='B', score=95, graduated=true}
        collect2.get("B").get(true).get(true).forEach(System.out::println);
    }
}
