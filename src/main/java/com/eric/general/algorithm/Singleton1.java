package com.eric.general.algorithm;


/**
 * 描述: 饿汉单例模式
 *
 * @author eric
 * @create 2018-05-23 下午2:43
 */
public class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getSingleton1() {
        return singleton1;
    }
}
