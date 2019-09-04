package com.hss.spring.dynamic;

import com.hss.spring.dynamic.service.MyHaosService;
import com.hss.spring.dynamic.service.impl.MyHaosServiceImpl;

public class Test {
    public static void main(String[] args) {
        MyHaosService service  =  new MyHaosServiceImpl();
        MyHaosService proxy =  (MyHaosService) DynameUtlis.getJdkProxy(service);
        proxy.doSomething();

        MyHaosService proxy2 =  (MyHaosService) DynameUtlis.getCGLIBProxy(service);
        proxy2.doSomething();
    }
}
