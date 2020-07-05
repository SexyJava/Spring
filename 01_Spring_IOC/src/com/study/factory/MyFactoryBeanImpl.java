package com.study.factory;

import com.study.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * @Author Liuyunda
 * @Date 2020/7/5 13:36
 * @Email man021436@163.com
 * @Description: 实现了FactoryBean的类都是一个工厂类，spring会自动的调用工厂方法创建实例
 *      1.编写一个FactoryBean的实现类
 *      2.在spring配置文件中进行注册
 */
public class MyFactoryBeanImpl implements FactoryBean<Book> {
    /**
     * @Description: 工厂方法，spring自动调用
     * @Param: []
     * @return: com.study.bean.Book
     * @Author: Liuyunda
     * @Date: 2020/7/5
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImpl....帮你创建了对象");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * @Description: 返回创建的对象的类型，spring自动调用
     * @Param: []
     * @return: java.lang.Class<?>
     * @Author: Liuyunda
     * @Date: 2020/7/5
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * @Description: 是单例么
     * @Param: []
     * @return: boolean
     * @Author: Liuyunda
     * @Date: 2020/7/5
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
