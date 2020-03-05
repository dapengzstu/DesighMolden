有三种工厂模式：
简单工厂模式
工厂模式模板
抽象工厂模式

简单的就是：通过一个工厂可以获取不同的Shape（circle，triangle）
Factory factory = new Factory()
Shape circle = factory.getShape("circle")
circle.draw()

工厂模板：通过不同的工厂（CircleFactory，TriangleFactory），获得不同的Shape（circle，triangle）
Factory circleFactory = new CircleFactory()
Shape circle = cifcleFactory.getShape()
circle.draw()

抽象工厂模式：抽象工厂模式是对工厂模板的扩展，一个工厂里面可以创建(一组)不同的实例
Systemfactory factory;

factory = new AndroidFactory()  //factory = new IOSFatory()
UIController uiController = factory.createUIController();
OperationController operationController = factory.createOperationController();
