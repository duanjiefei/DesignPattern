package proxy;

public class RealSubject implements Subject {

    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing");
    }
}
