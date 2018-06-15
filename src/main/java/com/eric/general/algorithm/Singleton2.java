package com.eric.general.algorithm;

/**
 * 描述:懒汉单例模式
 *
 * @author eric
 * @create 2018-05-23 下午3:10
 */
public class Singleton2 {

    private static class SingletonHandler {
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHandler.instance;
    }

    private Singleton2() {

    }
}
