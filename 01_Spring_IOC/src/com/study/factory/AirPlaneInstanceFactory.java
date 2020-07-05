package com.study.factory;

import com.study.bean.AirPlane;

/**
 * @Author Liuyunda
 * @Date 2020/7/5 13:07
 * @Email man021436@163.com
 * @Description: 实例工厂
 */
public class AirPlaneInstanceFactory {
    // new AirPlaneInstanceFactory().getAirPlane
    public AirPlane getAirPlane(String jzName){
        System.out.println("AirPlaneInstanceFactory.....正在造飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("lyd");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(100);
        airPlane.setYc("198.98m");
        return airPlane;
    }
}
