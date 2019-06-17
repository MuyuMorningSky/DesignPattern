package com.learn.designpattern.core.singleton;

import org.springframework.stereotype.Component;

@Component
public class SingletonFactory {

    public void hungerSingleton() {
        HungerSingleton hungerSingleton1 = HungerSingleton.getInstance();
        HungerSingleton hungerSingleton2 = HungerSingleton.getInstance();
        System.out.println(hungerSingleton1 == hungerSingleton2);
    }

    public void lazySingleton() {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton1 == lazySingleton2);
    }

    public void doubleCheckSingleton() {
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();
        System.out.println(doubleCheckSingleton1 == doubleCheckSingleton2);
    }

    public void innerStaticSingleton() {
        InnerStaticSingleton innerStaticSingleton1 = InnerStaticSingleton.getInstance();
        InnerStaticSingleton innerStaticSingleton2 = InnerStaticSingleton.getInstance();
        System.out.println(innerStaticSingleton1 == innerStaticSingleton2);
    }

    public void enumSingleton() {
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton1 == enumSingleton2);
    }
}
