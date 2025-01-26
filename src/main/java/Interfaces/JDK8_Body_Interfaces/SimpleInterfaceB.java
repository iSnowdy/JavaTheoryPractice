package Interfaces.JDK8_Body_Interfaces;

public interface SimpleInterfaceB {
    default void myDefaultMethod() {
        System.out.println("This is a default method inside an interface (B)");
    }

    static void staticMethodInInterface() {
        System.out.println("This is a static method inside an interface");
    }
}
