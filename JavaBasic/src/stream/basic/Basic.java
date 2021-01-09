package stream.basic;

import java.util.Arrays;
import java.util.List;

public class Basic {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        // 다른 데이터 소스도 정렬 -> 출력하는 방식이 동일하고, 간결하다.
        Arrays.stream(strArr).sorted().forEach(System.out::println);
        strList.stream().sorted().forEach(System.out::println);
    }
}
