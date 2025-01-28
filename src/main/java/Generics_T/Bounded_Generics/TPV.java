package Generics_T.Bounded_Generics;

// We want the TPV to accept credit cards. Any kind of credit cards (generic), but only cards (bounded)
// This has as a consequence that if we try to instantiate a TPV, the type must be a class extending from PaymentCard

// Here we use extends, but we could also use interfaces. We could use interfaces if we want to apply multiple
// bounds to the generic

public class TPV<T extends PaymentCard & MoneyPurse> {
    // But now we have the issue that yes, we have a generic T, but now we don't know what kind of card are we
    // dealing with. We cannot access any of the methods from credit card / debit card. But now that we have
    // the extends in the class signature, that is no longer the case
    public void accepts(T t) {
        t.getNumber();
        // getNumber because that is the method inside PaymentCard
    }
}
