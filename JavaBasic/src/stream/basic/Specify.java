package stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Specify {
    public static void main(String[] args) {

        String[] strArr = {"ccc", "bbb", "aaa"};

        Stream<String> stream = Arrays.stream(strArr);

        List<String> collectList = stream.sorted().collect(Collectors.toList());

        //IllegalStateException : stream has already been operated upon or closed
        long count = stream.sorted().count();

//        void forEach(Consumer<? super T> action){
//            Objects.requireNonNull(action);
//
//            for(T t : src) {
//                action.accept(t);
//            }
//        }
    }


}
