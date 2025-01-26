package Interfaces.JDK8_Body_Interfaces;

public class TestA implements SimpleInterfaceA {
    @Override
    public void myAbstractMethod() {
        System.out.println("This is an abstract method inside an interface implemented by the inheriting class");
    }

    public void myClassMethod() {
        System.out.println("This is a class method");
    }
}
