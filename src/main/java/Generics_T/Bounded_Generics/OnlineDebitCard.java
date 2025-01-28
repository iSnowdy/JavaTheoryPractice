package Generics_T.Bounded_Generics;

public class OnlineDebitCard extends DebitCard implements MoneyPurse {
    int myBalance;

    @Override
    public int balance() {
        return myBalance;
    }

    @Override
    public void charge(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Negative amount");
        myBalance += amount;
    }

    @Override
    public void unload(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Negative amount");

        if ((myBalance - amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        } else {
            myBalance -= amount;
        }
    }
}
