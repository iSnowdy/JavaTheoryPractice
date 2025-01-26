package Interfaces.JDK8_Body_Interfaces;

public interface SimpleInterfaceA {
    String myInterfaceVariable = "This is an interface variable";
    default void myDefaultMethod() {
        System.out.println("This is a default method inside an interface (A)");
    }

    default void mySecondDefaultMethod() {
        System.out.println("This is a second default method inside an interface. I can have all I want!");
    }

    void myAbstractMethod();
}
