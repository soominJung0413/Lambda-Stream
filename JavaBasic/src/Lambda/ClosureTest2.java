package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosureTest2 {
    private int b = 2;

    private Stream<Integer> calculate(Stream<Integer> stream, int a) {
//        a = 10; 컴파일 에러, Final 키워드
        return stream.map(integer -> integer * a + b);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<Integer> collect = new ClosureTest2().calculate(list.stream(), 3)
                .collect(Collectors.toList());
    }
}
