package concurrency;

import java.util.HashMap;

/**
 *
 *
 *
 */
public class ObjectLockDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("test");
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");

        HashMap map = new HashMap();
    }


}
