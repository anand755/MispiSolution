package scores.bin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Histogram {
    private Map<Integer, Integer> bins = new HashMap<>();

    public void AddScore(Integer score) {

        if (score >= 0 && score <= 10) {
            if (bins.get(10) != null)
                bins.put(10, bins.get(10) + 1);
            else
                bins.put(10, 1);
        } else if (score > 10 && score <= 20) {
            if (bins.get(20) != null)
                bins.put(20, bins.get(20) + 1);
            else
                bins.put(20, 1);
        } else if (score > 20 && score <= 30) {
            if (bins.get(30) != null)
                bins.put(30, bins.get(30) + 1);
            else
                bins.put(30, 1);
        } else if (score > 30 && score <= 40) {
            if (bins.get(40) != null)
                bins.put(40, bins.get(40) + 1);
            else
                bins.put(40, 1);
        } else {
            System.out.println("Outside of bin range");
        }

    }

    public void DisplayHistogram() {

        Map<Integer, Integer> sortedbin = new TreeMap<>(bins);

        for (Map.Entry entry : sortedbin.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i = 0; i < Integer.valueOf(entry.getValue().toString()); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
