package stream.basic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectionGroupPartition {
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

        Map<Boolean, Long> partitioningCount = studentStream.collect(partitioningBy(Student::isGraduated, counting()));
        partitioningCount.get(true); // 3
        partitioningCount.get(false); // 1

        Map<Boolean, Map<Boolean, List<Student>>> collect = studentStream
                .collect(partitioningBy(Student::isGraduated, partitioningBy(student -> student.getScore() > 95)));
        //Student{name='최범균', className='A', score=97, graduated=true}
        collect.get(true).get(true).forEach(System.out::println);
    }
}
