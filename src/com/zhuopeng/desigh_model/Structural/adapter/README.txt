适配器模式：将一个类的接口适配成客户需要的另一个接口
    类适配器，通过继承原有的Adaptee
    对象适配器，通过关联

Spring AOP中的适配器模式
https://blog.csdn.net/wwwdc1012/article/details/82780560

JDK中的适配器，InputStreamReader，将原来的字符流的接口 通过编码 变成现在需要的字符流的接口
两个接口    InputStream         Reader
    StreamDecoder持有InputStream对象
        InputStreamReader里面有一个StreamDecoder属性，负责将byte编码成字符


