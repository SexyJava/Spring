package com.study.test;

import com.study.bean.Book;
import com.study.bean.Car;
import com.study.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author Liuyunda
 * @Date 2020/6/22 20:56
 * @Email man021436@163.com
 * @Description: DOTO
 */

public class IOCTest {
    // private  ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    private  ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

    /**
     * @Description: 从容器中拿到这个组件
     * 细节：
     * 1.ApplicationContext（IOC容器的接口）
     * 2.给容器中注册一个组件，我们也从容器中按照id拿到了这个组件的对象
     *      组件的创建工作，是容器完成的
     *      Person对象是什么时候创建好的=在容器创建完成的时候就已经创建好了
     * 3.同一个组件在IOC容器中是单实例的，在容器创建完成时就已经创建了
     * 4.获取为注册的组件
     *      org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'none' available
     * 5.property怎么赋值的=IOC容器在创建这个组件对象的时候，（property）会利用setter方法为JavaBean的属性赋值
     * @Param: []
     * @return: void
     * @Author: Liuyunda
     * @Date: 2020/6/22
     */
    @Test
    public void test() {
        // ApplicationContext 代表IOC容器对象
        // 当前应用的xml配置文件在ClassPath下
        // 根据spring的配置文件得到IOC容器对象
        // ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        // ApplicationContext ioc = new FileSystemXmlApplicationContext("D:\\Code\\Spring\\01_Spring_IOC\\conf\\ioc.xml");
        // 容器帮我们创建好了对象
        System.out.println("容器启动成功");
        Person person01 = (Person) ioc.getBean("person01");
        Person person02 = (Person) ioc.getBean("person01");
        System.out.println(person01);
        System.out.println(person02);
        System.out.println(person01 == person02);// true
        System.out.println("====================");
        // Person none = (Person) ioc.getBean("none");
        // System.out.println(none);
    }
    /**
     * @Description: 根据bean的类型从IOC容器中获取bean的实例
     * 细节：
     * 1.如果IOC容器中这个类型的bean有多个，查找就会失败
     *      org.springframework.beans.factory.NoUniqueBeanDefinitionException:
     *      No qualifying bean of type 'com.study.bean.Person' available: expected single matching bean but found 2: person01,person02
     * @Param: []
     * @return: void
     * @Author: Liuyunda
     * @Date: 2020/6/22
     */
    @Test
    public void test02() {
        // Person bean = ioc.getBean(Person.class);
        // System.out.println(bean);
        Person person02 = ioc.getBean("person02", Person.class);
        System.out.println(person02);
    }
    /**
     * @Description: 通过构造器为bean的属性赋值
     * @Param: []
     * @return: void
     * @Author: Liuyunda
     * @Date: 2020/6/22
     */
    @Test
    public void  test03() {
        // Person person = (Person) ioc.getBean("person");
        // System.out.println(person);
        Person person03 = (Person) ioc.getBean("person03");
        System.out.println(person03);
    }

    /**
     * @Description: 为各种属性赋值
     *      测试使用null值，默认引用类型就是null，基本类型是默认值
     *      Person{lastName='null', age=null, gender='null', email='null', car=null, books=null, maps=null, properties=null}
     *      ref引用，内部bean(内部bean不能被获取到)
     * @Param: []
     * @return: void
     * @Author: Liuyunda
     * @Date: 2020/6/22
     */
    @Test
    public void  test04() {
        Person person = (Person) ioc.getBean("person");
        System.out.println(person.getLastName() == null);
        System.out.println(person);
        System.out.println("===================");
        System.out.println(person.getCar());
        Car car01 = (Car) ioc.getBean("car01");
        System.out.println(car01 == person.getCar());
        System.out.println(person.getBooks());
        // Book book01 = (Book) ioc.getBean("book01");
        // System.out.println(book01);
        System.out.println(person.getMaps());
        System.out.println(person.getProperties());
        Person person02 = (Person) ioc.getBean("person01");
        System.out.println(person02.getMaps());
        Map myMap = (Map) ioc.getBean("myMap");
        System.out.println(myMap);


    }
}