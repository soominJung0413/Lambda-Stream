package Lambda;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaBasic {
    public static void main(String[] args) {

//        Runnable runnable = new LambdaBasic().useLambda();
//
//        new Thread(runnable).run();
//        // $1 => Hello @java.lang.FunctionalInterface() Method!

        //Predicate 익명 구현 객체 생성
        Predicate predicate = (Predicate) o -> "@java.lang.FunctionalInterface()".equals(Predicate.class.getAnnotations()[0].toString());
        //구현 메서드 실행
        boolean test = predicate.test(predicate);
        System.out.println(test); // $1 => true
    }

    private Runnable useLambda() {
        return (Runnable) () -> {
                System.out.printf("Hello %s Method!", Runnable.class.getAnnotations()[0] );

        };
    }
}
