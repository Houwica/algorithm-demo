package algorithm.DesignPattern;

public class SingletonDemo {

    private static final SingletonDemo singleton = new SingletonDemo();

    private static SingletonDemo instance = new SingletonDemo();

    // 静态加载方式实现单列;  饿汉式
    public static SingletonDemo getInstance() {
        return singleton;
    }

    // 懒加载; 懒汉式
    public static synchronized SingletonDemo init01() {
        if (instance == null) {
            instance = new SingletonDemo();
        }

        return instance;
    }

    // 双重检测， 类锁
    public static SingletonDemo init() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }

        return instance;
    }

    // 静态内部类; 兼顾饿汉式和懒汉式的优点, 既能延迟加载又能保证线程安全;
    private static class SingletonDemoHolder{
        private static final SingletonDemo instance = new SingletonDemo();
    }

    public static SingletonDemo init02() {
        return SingletonDemoHolder.instance;
    }


    // threadLocal的是实现方式, 线程ID


}
