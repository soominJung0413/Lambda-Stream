package Lambda.contructorReference;

import java.lang.reflect.Member;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReference {
    static class Account {
        private String  name;

        private int age;

        public Account(String name) {
            System.out.println("OneArgsConstructor");
            this.name = name;
        }

        public Account(String name, int age) {
            System.out.println("TwoArgsConstructor");
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        Function<String,Account> oneArgFunction = Account::new;
        Account account = oneArgFunction.apply("SooMin");

        System.out.println(account.toString()); // Account{name='SooMin', age=0}



        BiFunction<String, Integer, Account> twoArgsFunction = Account::new;
        Account sooMin = twoArgsFunction.apply("SooMin", 29);

        System.out.println(sooMin.toString()); // Account{name='SooMin', age=29}
    }
}
