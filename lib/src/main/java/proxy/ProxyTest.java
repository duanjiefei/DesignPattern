package proxy;

public class ProxyTest {
    public static void main(String[] args){
        ProxyHandler proxyHandler = new ProxyHandler();
        Subject realSubject = (Subject) proxyHandler.bindObject(new RealSubject());
        realSubject.doSomeThing();
    }
}
