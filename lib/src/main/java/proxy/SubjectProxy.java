package proxy;

/**
 * 静态代理
 */
public class SubjectProxy implements Subject {
    RealSubject subject = new RealSubject();
    @Override
    public void doSomeThing() {
            System.out.println("before");
            subject.doSomeThing();
            System.out.println("after");
    }


}
