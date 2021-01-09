package stream.basic;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        Stream<String[]> streamArr = Stream.of(
                new String[]{"Java ", "Oracle ", "JavaScript"},
                new String[]{"Vue.js ", "SpringBoot ", "Ubuntu"}
        );
        
        // Stream<Stream<String>> 이 되어버린다.
        Stream<Stream<String>> streamStream = streamArr.map(Arrays::stream);

        Stream<String> stringStream = streamArr.flatMap(Arrays::stream);

        Stream<String> strStream = Stream.of(
                "Java Oracle JavaScript",
                "Vue.js SpringBoot Ubuntu");
        
        //원하는 결과가 도출되지 못함
        Stream<String[]> stream = strStream.map(s -> s.split(" "));
        Stream<Stream<String>> streamStream1 = strStream.map(s -> Stream.of(s.split(" ")));

        // 원하는 결과 도출
        Stream<String> flatStream = strStream.flatMap(s -> Stream.of(s.split(" ")));

    }
}
