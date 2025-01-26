package Interfaces.JDK8_Body_Interfaces;

public class TestB implements SimpleInterfaceA, SimpleInterfaceB {
    @Override
    public void myDefaultMethod() {
        //SimpleInterfaceA.super.myDefaultMethod();
        SimpleInterfaceB.super.myDefaultMethod();
    }

    @Override
    public void myAbstractMethod() {
        System.out.println("This is an abstract method inside an interface implemented by the inheriting class");
    }

}
