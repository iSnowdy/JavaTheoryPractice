package Interfaces.JDK8_Body_Interfaces;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        TestA testA = new TestA();

        testA.myDefaultMethod();
        testA.myAbstractMethod();
        testA.myClassMethod();
        testA.mySecondDefaultMethod();
        System.out.println(testA.myInterfaceVariable);

        System.out.println("\n------------------------\n");

        TestB testB = new TestB();
        testB.myDefaultMethod();

        Function.identity().apply("Hello World!");
        SimpleInterfaceB.staticMethodInInterface();
    }
}
