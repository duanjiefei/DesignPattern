package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java 动态代理
 */
public class ProxyHandler implements InvocationHandler {

    private Object tar;

    public  Object bindObject(Object obj){
        this.tar  = obj;
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),tar.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        result = method.invoke(tar,args);
        return result;
    }
}
