
package com.charmyin.practice.interfacetest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.charmyin.practice.classObjects.Employee;

 public class ProxyTest2
 {
   public static void main(String[] args)
   {
	   	  Object element = new Object();

	   	  Employee employee = new Employee("charmyin",21);
       
         
          Class[] interfaces = {USB.class};//value.getClass().getInterfaces();
          InvocationHandler handler = new TraceHandler2(employee);
          
          Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
          element = proxy;
       
          Mp3Player mp3 = new Mp3Player();
          mp3.readEmployee(employee);

    }
 }

 /**
    An invocation handler that prints out the method name
    and parameters, then invokes the original method
 */
 class TraceHandler2 implements InvocationHandler
 {
    /**
       Constructs a TraceHandler
       @param t the implicit parameter of the method call
    */
    public TraceHandler2(Object t)
    {
       target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
       // print implicit argument
       System.out.print(target);
       // print method name
       System.out.print("." + m.getName() + "(");
       // print explicit arguments
       if (args != null)
       {
         for (int i = 0; i < args.length; i++)
          {
            System.out.print(args[i]);
             if (i < args.length - 1)
                System.out.print(", ");
          }
       }
       System.out.println(")");

       // invoke actual method
       return m.invoke(target, args);
    }

    private Object target;
 }
