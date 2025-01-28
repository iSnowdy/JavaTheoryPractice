package Generics_T.Bounded_Generics;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //TPV<Calendar> calendarTPV; we are not allowed to do this!

        // Upon doing extends & implements on TPV, we cannot do this any longer. Because those classes
        // do not implement MoneyPurse. However, OnlineDebitCard does!

        /*TPV<CreditCard> creditCardTPV = new TPV<>();
        TPV<DebitCard> debitCardTPV = new TPV<>();
        TPV<PaymentCard> paymentCardTPV = new TPV<>();*/

        TPV<OnlineDebitCard> onlineDebitCardTPV = new TPV<>();
    }
}
