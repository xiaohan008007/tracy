package com.tracy.aop;

import java.util.ArrayList;
import java.util.List;

import com.tracy.aop.aspect.AfterHandler;
import com.tracy.aop.aspect.AfterHandlerImpl;
import com.tracy.aop.aspect.BeforeHandler;
import com.tracy.aop.aspect.BeforeHandlerImpl;
import com.tracy.aop.impl.Calculator;
import com.tracy.aop.impl.CalculatorImpl;

/**
 * The Test class to verify our own aop using JDK proxy.
 * 
 * @author Debadatta Mishra
 */
public class TestAopInJDK {

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        Calculator cal = new CalculatorImpl();
        BeforeHandler before = new BeforeHandlerImpl();
        AfterHandler after = new AfterHandlerImpl();
        List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
        handlers.add(before);
        handlers.add(after);
        Calculator proxy = (Calculator) ProxyFactory.getProxy(cal, handlers);
        int result = proxy.calculate(20, 10);
        System.out.println("FInal Result :::" + result);
    }

}
