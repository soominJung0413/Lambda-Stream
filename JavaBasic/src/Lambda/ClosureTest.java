package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosureTest {

    static <T> void waitFor(T input, Predicate<T> predicate) throws InterruptedException {
        // 인자로 넘겨주는 변수 외 외부 변수가 없기 때문에 효율적으로 연산
        while (predicate.test(input)) {
            System.out.println("Blocking");
            Thread.sleep(2500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //Blocking... Blocking.... Blocking...
        Optional<Object> obj_opt = Optional.of(new Object());
        waitFor(obj_opt, Optional::isPresent);


    }
}
