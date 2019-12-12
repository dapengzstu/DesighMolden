java的IO中有节点流和过滤流两种

new 过滤流（new 过滤流（ new 节点流（）））
最里面一定是个节点流，然后通过过滤流处理加工节点流的数据

因为在 过滤流类中有一个属性，这个属性可以是个节点流类，也可以是一个过滤流类，所以过滤流的类和节点流的类都要实现同一个接口，这样才能根据对象的多态性将这两个类，使用同一个属性    Interface Component
不同的过滤流要使用同一个模板，这个模板里面有一个实现了Component接口的类，这个模板就是所有的过滤流都要集成   Decorator抽象类，而Decorator类要实现Component接口

节点流就使用  ConcreteComponent类（具体节点）
过滤流就继承  Decorator类

                                Component（接口）
               Decorator（抽象类，实现Componet接口，里面有个Componet属性）       ConcreteComponent（节点流，实现COmponet接口）
        DecoratorComponet1
        DecoratorComponet2
        DecoratorComponet3