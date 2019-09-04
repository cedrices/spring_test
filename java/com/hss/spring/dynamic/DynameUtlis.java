package com.hss.spring.dynamic;

import com.hss.spring.dynamic.service.MyHaosService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynameUtlis {


    /**
     * JDK代理模式
     * @param service
     * @return
     */
    public static  Object  getJdkProxy(final MyHaosService service){
       Object proxy  = Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("getJdkProxy——前置通知！！");
                Object obj = method.invoke(service,args);
                return obj;
            }
        });

        return proxy;
    }

    /**
     *
     * @param service
     * @return
     */
    public static  Object  getCGLIBProxy(final MyHaosService service){
        Enhancer  enhancer = new Enhancer();
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new MethodInterceptor() {

            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("getCGLIBProxy——前置通知！！");
                Object object = method.invoke(service,objects);
                return object;
            }
        });
        MyHaosService service1 =  (MyHaosService)enhancer.create();
       return service1;
    }

}
