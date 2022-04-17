package algorithm.MapDemo;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPrice {
    private HashMap<Integer, Integer> timePriceMap;

    private TreeMap<Integer, Integer> prices;

    private Integer maxTimeStamp;

    public StockPrice() {
        maxTimeStamp = 0;
        timePriceMap = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        maxTimeStamp = Math.max(timestamp, maxTimeStamp);

        int prevPrice = timePriceMap.getOrDefault(timestamp, 0);

        timePriceMap.put(timestamp, price);

        if (prevPrice > 0) {
            prices.put(prevPrice, prices.get(prevPrice) - 1);
            if (prices.get(prevPrice) == 0) {
                prices.remove(prevPrice);
            }
        }

        prices.put(price, prices.getOrDefault(price, 0) + 1);

    }

    public int current() {
        return timePriceMap.get(maxTimeStamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }

    public static void main(String[] args) {
        StockPrice st = new StockPrice();

        st.update(1, 5);
        st.update(2, 10);
        st.update(1, 6);

        System.out.println(st.current());

        System.out.println(st.maximum());
    }
}
