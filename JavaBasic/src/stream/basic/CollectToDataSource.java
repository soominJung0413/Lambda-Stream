package stream.basic;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectToDataSource {

    static class Student {
        private String name;
        private String className;
        private int score;

        public Student(String name, String className, int score) {
            this.name = name;
            this.className = className;
            this.score = score;
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
    }

    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
          new Student("정수민","D",50),
                new Student("신용권","C",92),
                new Student("남궁성","B",95),
                new Student("최범균","A", 97)
        );

        List<Student> toList = studentStream.collect(toList());
        Set<Student> toSet = studentStream.collect(toSet());
        LinkedList<Student> toLink = studentStream.collect(toCollection(LinkedList::new));
        Map<String, Student> collect = studentStream.collect(toMap(Student::getName, student -> student));
        Student[] students = studentStream.toArray(Student[]::new);

    }
}
