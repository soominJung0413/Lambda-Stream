package Lambda.operator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class OperatorTest {
    private static int sum = 0;

    public static void main(String[] args) {
        int[] scores = {20,45,60,55,80};

        //Local Class 문제로 로컬 변수로 지정시 합산 불가
        IntUnaryOperator intUnaryOperator = operand -> sum += operand;

        Arrays.stream(scores).forEach(intUnaryOperator::applyAsInt);

        System.out.println(sum); // 260
    }
}
