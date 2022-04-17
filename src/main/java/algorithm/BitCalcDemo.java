package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BitCalcDemo {

    private static void swap(int a, int b) {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);

        System.out.println(b);
    }


    public static void main(String[] args) {
        swap(10, 20);


        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

        }

    }
}
