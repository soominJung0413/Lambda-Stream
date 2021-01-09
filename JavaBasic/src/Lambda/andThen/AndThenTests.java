package Lambda.andThen;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class AndThenTests {

    static class Account {
        private int age;
        private String name;
        private String address;

        public Account(int age, String name, String address) {
            this.age = age;
            this.name = name;
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }

    public static void main(String[] args) {
        Function<Account,String> function1 = Account::getName;
        Function<String ,String> function2 = s -> s.substring(s.lastIndexOf(" ")+1 , s.length());
        
        // 파이프라인으로 이어놓은 메서드 재정의
        Function<Account,String > compositeFunction = function1.andThen(function2);
        
        //실행
        String apply = compositeFunction.apply(new Account(29, "SooMin Jung", "address"));
        //Jung
        System.out.println(apply);
    }
}
