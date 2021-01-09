package stream.basic;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectCount {
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

        studentStream.collect(counting()); // 4
        studentStream.collect(summingInt(Student::getScore)); // 334
        studentStream.collect(maxBy(Comparator.comparingInt(Student::getScore))); // 97
        studentStream.collect(averagingInt(Student::getScore)); // 83.5

    }
}
