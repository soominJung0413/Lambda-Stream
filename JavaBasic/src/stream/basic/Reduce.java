package stream.basic;

import java.util.stream.IntStream;

public class Reduce {
    public static void main(String[] args) {

        IntStream intStream = IntStream.of(5,4,2,17,10,20,31,12,4,1);

        int count = intStream.reduce(0, (identity, element) -> identity + 1); // 10

        int max = intStream.reduce(Integer.MIN_VALUE, (identity, element) -> identity > element ? identity : element); // 31

        int min = intStream.reduce(Integer.MAX_VALUE, (identity, element) -> identity < element ? identity : element);//1

    }
}
