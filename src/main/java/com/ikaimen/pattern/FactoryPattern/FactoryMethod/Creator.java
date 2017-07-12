package com.ikaimen.pattern.FactoryPattern.FactoryMethod;

/**
 * Created by ChenTao on 2017/7/8.
 * 抽象工厂类
 *
 * 工厂方法模式定义
 *
 * 工厂方法模式是指定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到期子类。
 *
 * 工厂方法模式的优缺点
 *
 * 首先，良好的封装性，代码结构清晰。一个对象创建是有条件约束的，如果一个调用者需要一个具体的产品对象，如一个调用者需要一个具体的产品对象，只要知道这个产品的类名（或约束字符串就可以了），
 * 不用知道创建对象的艰辛过程，降低模块间的耦合。
 * 其次，工厂方法模式的扩展性非常优秀。在增加产品类的情况下，只要适当地修改具体的工厂类或者扩展一个工厂类，就可以完成"拥抱变化"。例如在我们的例子中，需要增加一个棕色人种，则只需要增加一
 * 个BrownHuman类，工厂类不用任何修改就可以完成系统扩展。
 * 再次，屏蔽产品类。这一特点非常重要，产品类的实现如何变化，调用者都不需要关心， 他只需要关心产品的接口，只要接口保持不变，系统中的上层模块就不要发生变化。因为产品类的实例化工作是由
 * 工厂类负责的，一个茶农对象具体由哪一个产品生产是由工厂类决定是。在数据库开发中，大家应该能够深刻体会到工厂方法模式的好处；如何使用JDBC连接数据库，数据库从MySql切换到Oracle，需要改动
 * 的地方就是切换一个驱动名称（前提条件是SQL语句是标准语句），其他的都不需要修改，这是工厂方法模式灵活性的一个直接案例。
 * 最后，工厂方法模式是典型的解耦型框架。高层模块只需要知道产品的抽象类，其他的实现类都不用关心，符合迪米特法则，我不需要的就不要去交流；也符合以来导致原则，只依赖产品类的抽象，当然也符合
 * 里氏替换原则，使用产品自雷提花布产品父类，没问题！
 *
 * 使用场景
 *
 * 首先，工厂方法模式是new一个对象的替代品，所以在所有需要生成对象的地方都可以使用，但是需要慎重的考虑是否要增加一个工厂类进行管理，增加代码的复杂度。
 * 其次，需要灵活的，可扩展的框架时，可以考虑采用工厂方法模式，万物皆对象，那万物也就皆产品类。例如需要设计一个连接邮件服务器的框架，有三种网络协议可供选择：POP3、IMAP\HTTP,我们就可以
 * 把这三种连接方法作为产品类，定义一个接口如IconnectMail,然后定义对邮件的操作方法，用不同的方法实现是哪个具体的产品类（也就是连接方式）再定义一个工厂方法，按照不同的产品条件，选择不同
 * 的连接方式。如此设计，可以做到完美的扩展，如某些邮件服务器提供了WebServiceJ接口，很好，我们只要增加一个产品类就可以了。
 * 再次，工厂方法模式可以用在异构项目中，例如通过WebService与一个非Java的项目交互，虽然WebService号称是可以做到异构系统的同构化，但是在实际的开发中，还是会碰到很多问题，如类型问题，WSDL
 * 文件的支持问题，等等，从WSDL中产生的对象都是认为是一个产品，然后由一个具体的工厂类进行管理，减少与外围系统的耦合。
 * 最后，可以使用在测试驱动开发的框架下。例如，测试一个类A，就需要把类A有关联关系的类B也同时产生出来，我们就可以使用工厂方法模式把类B虚拟出来，避免类A与类B的耦合。目前由于Jmock和EasyMock
 * 的诞生，该使用场景已经弱化了，读者可以在遇到此种情况时直接考虑使用JMock或者EasyMock。
 *
 * 最佳实践
 *
 * 工厂方法模式在项目中使用得非常频繁，以至于很多代码中都包含工厂方法模式。改模式几乎人尽皆知，但是不是每个人都能用好。孰能生巧，熟练掌握该模式，多思考工厂方法如何应用，而且工厂放到模式还可以
 * 和其他模式混合使用（例如模板方法模式，单例模式，原型模式等），变化出无穷的优秀设计，这也是正式软件设计和开发乐趣所在。
 *
 */
public abstract class Creator {

    //创建一个产品对象呢，其输入参数类型可以自行设置
    public abstract <T extends  Product> T createProduct(Class<T> tClass);

}
