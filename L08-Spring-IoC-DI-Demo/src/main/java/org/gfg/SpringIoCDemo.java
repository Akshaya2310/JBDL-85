package org.gfg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("projectbeans.xml");
        Engine engine1 = applicationContext.getBean("engine1", Engine.class);
        System.out.println(engine1);

        Engine engine2 = applicationContext.getBean("engine2", Engine.class);
        System.out.println(engine2);


        System.out.println(engine1 == engine2);

        Engine engine3 = applicationContext.getBean("engine2", Engine.class);
        System.out.println(engine3);

        System.out.println(engine2 == engine3); // false if scope=prototype, true if scope=singleton

        Car car1 = applicationContext.getBean("car1", Car.class);
        System.out.println(car1);

        System.out.println(car1.getEngine() == engine1);


    }
}
