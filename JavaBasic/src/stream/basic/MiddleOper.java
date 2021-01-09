package stream.basic;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MiddleOper {

    static class Student  {

        private int score;

        private String name;

        public Student(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "score=" + score +
                    ", name='" + name + '\'' +
                    '}';
        }

    }

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,2,2,3,3,3,4,5,5,6);

        // 1, 5, 5
        intStream.filter(i -> i%2 != 0).filter(i -> i%3 !=0).forEach(System.out::println);

        Stream<Student> studentStream = Stream.of(
                new Student(50,"정수민"),
                new Student(90,"신용권"),
                new Student(92, "남궁성"),
                new Student(96, "최범균")
        );

//        Student{score=96, name='최범균'}
//        Student{score=92, name='남궁성'}
//        Student{score=90, name='신용권'}
//        Student{score=50, name='SooMin'}
        studentStream.sorted(Comparator.comparingInt(Student::getScore).reversed()).forEach(System.out::println);
    }
}
