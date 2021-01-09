package Lambda.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.print(s);
        stringConsumer.accept("Hello ");

        BiConsumer<String,String> biConsumer = (s, s2) -> System.out.printf("%s %s ! ",s,s2);
        biConsumer.accept("Java","8");

        ObjIntConsumer<String> objIntConsumer = (s, value) -> System.out.printf("%s , %d.",s,value);
        objIntConsumer.accept("Lambda Expression",1);

        //Hello Java 8 ! Lambda Expression , 1.
    }
}
