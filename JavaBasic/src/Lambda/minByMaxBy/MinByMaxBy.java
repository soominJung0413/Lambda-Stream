package Lambda.minByMaxBy;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class MinByMaxBy {
    static class Name {
        String word;
        int primary;

        public Name(String word, int primary) {
            this.word = word;
            this.primary = primary;
        }

        public String getWord() {
            return word;
        }

        public int getPrimary() {
            return primary;
        }
    }
    public static void main(String[] args) {


        BinaryOperator<Name> lastNameOperator = BinaryOperator.maxBy((o1, o2) -> Integer.compare(o1.primary, o2.primary));
        Name apply = lastNameOperator.apply(new Name("Jung", 1), new Name("SooMin", 0));

        System.out.println(apply.getWord()); // Jung

        BinaryOperator<Name> firstNameOperator = BinaryOperator.minBy(Comparator.comparingInt(o -> o.primary));
        apply = firstNameOperator.apply(new Name("Jung", 1), new Name("SooMin", 0));

        System.out.println(apply.getWord()); // SooMin
    }
}
