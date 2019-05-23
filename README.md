# DesignPattern
设计模式的分类
* 创建型模式
 >工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
* 结构型模式
 >适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式
* 行为模式
 >策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
---

# 策略设计模式 
```
设计思路：模拟支付算法策略
作用： 策略模式是对算法的包装，是把使用算法的责任和算法本身分割开来，委派给不同的对象管理，最终可以实现解决多重if判断问题。
实现：（定义策略接口->实现不同的策略类->利用多态或其他方式调用策略）
    1. 环境(Context)角色：持有一个Strategy的引用。
    2. 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
    3. 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
优缺点：
    1. 优点：算法可以自由切换（高层屏蔽算法，角色自由切换）,避免使用多重条件判断（如果算法过多就会出现很多种相同的判断，很难维护）,扩展性好（可自由添加取消算法 而不影响整个功能）
    2. 缺点：策略类数量增多（每一个策略类复用性很小，如果需要增加算法，就只能新增类）,所有的策略类都需要对外暴露（使用的人必须了解使用策略，这个就需要其它模式来补充，比如工厂模式、代理模式）
```

#模板设计模式
```
设计思路：模拟银行请求抽离共同行为与不同行为
作用：（模板方法模式使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。）
    1. 定义了一个操作中的算法的骨架，而将部分步骤的实现在子类中完成。
    2. 基于继承的代码复用的基本技术，没有关联关系，在模板方法模式的类结构图中，只有继承关系。
实现：
    AbstractClass: 抽象类，定义并实现一个模板方法。这个模板方法定义了算法的骨架，而逻辑的组成步骤在相应的抽象操作中，推迟到子类去实现
    ConcreteClass: 实现类，实现父类所定义的一个或多个抽象方法。
优缺点：
    1. 优点：模板方法模式通过把不变的行为搬移到超类，去除了子类中的重复代码。子类实现算法的某些细节，有助于算法的扩展。通过一个父类调用子类实现的操作，通过子类扩展增加新的行为，符合“开放-封闭原则”。
    2. 缺点：每个不同的实现都需要定义一个子类，这会导致类的个数的增加，设计更加抽象。
```

#责任链模式
```
设计思路：模拟网关请求过滤
作用：客户端发出一个请求，链上的对象都有机会来处理这一请求，而客户端不需要知道谁是具体的处理对象，就实现了请求者和接受者之间的解耦，并且在客户端可以实现动态的组合职责链，使编程更有灵活性。
      使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。其过程实际上是一个递归调用。
实现：
    1. 有多个对象共同对一个任务进行处理。
    2. 这些对象使用链式存储结构，形成一个链，每个对象知道自己的下一个对象。
    3. 一个对象对任务进行处理，可以添加一些操作后将对象传递个下一个任务。也可以在此对象上结束任务的处理，并结束任务。
    4. 客户端负责组装链式结构，但是客户端不需要关心最终是谁来处理了任务。
优缺点：
    1. 优点：职责链模式的最主要功能就是：动态组合，请求者和接受者解耦。请求者和接受者松散耦合：请求者不需要知道接受者，也不需要知道如何处理。每个职责对象只负责自己的职责范围，其他的交给后继者。各个组件间完全解耦。
    动态组合职责：职责链模式会把功能分散到单独的职责对象中，然后在使用时动态的组合形成链，从而可以灵活的分配职责对象，也可以灵活的添加改变对象职责。
    2. 缺点：产生很多细粒度的对象：因为功能处理都分散到了单独的职责对象中，每个对象功能单一，要把整个流程处理完，需要很多的职责对象，会产生大量的细粒度职责对象。
    不一定能处理：每个职责对象都只负责自己的部分，这样就可以出现某个请求，即使把整个链走完，都没有职责对象处理它。这就需要提供默认处理，并且注意构造链的有效性。

```

#装饰模式
```
设计思路：模拟网关请求过滤
作用：在不改变原有对象的基础上附加功能，相比生成子类更灵活。
实现：
    1. 抽象组件:定义一个抽象接口，来规范准备附加功能的类
    2. 具体组件：将要被附加功能的类，实现抽象构件角色接口 
    3. 抽象装饰者：持有对具体构件角色的引用并定义与抽象构件角色一致的接口
    4. 具体装饰：实现抽象装饰者角色，负责对具体构件添加额外功能。
优缺点：
    1. 优点：可以不改变原有对象的情况下动态扩展功能，可以使扩展的多个功能按想要的顺序执行，以实现不同效果。
    2. 缺点：更多的类，使程序复杂
```

#代理模式
``` 
设计思路：研究代理模式设计源码
作用：
实现：
    JDK动态代理底层实现:JDK的动态代理使用Java的反射技术生成动态代理类，只能代理实现了接口的类， 没有实现接口的类不能实现动态代理。
    CGLIB动态代理底层实现:运行时动态的生成一个被代理类的子类（通过ASM字节码处理框架实现），子类重写了被代理类中所有非final的方法，在子类中采用方法拦截的技术拦截所有父类方法的调用，不需要被代理类对象实现接口，从而CGLIB动态代理效率比Jdk动态代理反射技术效率要高。
    动态代理原理：
    1. 创建代理类$Proxy0源代码文件实现被代理的接口。
    2. 使用JavaCompiler技术编译该$Proxy0文件获取到$Proxy0.class
    3. 使用ClassLoader将该$Proxy0.class加入到当前JVM内存中
    ClassLoader类加载器作用：负责将 Class 加载到 JVM 中审查每个类由谁加载（父优先的等级加载机制）将 Class 字节码重新解析成 JVM 统一要求的对象格式
```

#观察者模式
``` 
设计思路：模拟消息多渠道同时发送
作用：对象之间拥有一对多的依赖，当一个对象改变状态，依赖它的对象会收到通知并自动更新。
实现：
    抽象被观察者角色：也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
    抽象观察者角色：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
    具体被观察者角色：也就是一个具体的主题，在集体主题的内部状态改变时，所有登记过的观察者发出通知。
    具体观察者角色：实现抽象观察者角色所需要的更新接口，一边使本身的状态与制图的状态相协调。
```
