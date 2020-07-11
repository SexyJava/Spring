package com.study.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author Liuyunda
 * @Date 2020/7/11 16:02
 * @Email man021436@163.com
 * @Description: DOTO
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * @Description: 初始化之前调用
     * @Param: [o, s]
     * @return: java.lang.Object
     * @Author: Liuyunda
     * @Date: 2020/7/11
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(s+"bean将要调用初始化方法");
        // 返回传入的bean
        return o;
    }

    /**
     * @Description: 初始化之后调用
     * @Param: [o, s]
     * @return: java.lang.Object
     * @Author: Liuyunda
     * @Date: 2020/7/11
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(s+"bean调用初始化方法完毕");
        return o;
    }
}
