package Lambda.supplier;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
     static class Dice {
        private int num;

        public void setDiceNumber() {
            num = (int)(Math.random() * 6) + 1;
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String[] args) {

        Supplier<Dice> diceSupplier = Dice::new;
        Dice dice = diceSupplier.get();
        dice.setDiceNumber();

        IntSupplier intSupplier = () -> dice.getNum();

        int asInt = intSupplier.getAsInt();

        //Random Number
        System.out.println(asInt);
    }
}
