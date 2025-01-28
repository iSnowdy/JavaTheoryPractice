package Generics_T.Basic_Generics;

// We want to use this class to envelope another class.
// Now we have enveloped an employee
// The issue with this is that if we specify the class Employee, then it will only expect Objects of instance
// Employee. What if we wanted to envelope a Department as well? Without using generics, that would not be possible

import Generics_T.Others.Employee;

public class Envelope<E> {
    private E enveloped;

    public Envelope(E enveloped) {
        this.enveloped = enveloped;
    }

    public E getEnveloped() {
        return enveloped;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "enveloped=" + enveloped +
                '}';
    }
}
