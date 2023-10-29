package sit.int202.jcfreview;

import java.util.HashMap;
import java.util.Map;

public class ProblemTwo {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 5, 8, 7, 9, 6, 4};
        int target = 6;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            int key = target - data[i];
            if (map.get(key) != null) {
                System.out.println("(" + i + ", " + map.get(key) + ")");
            }
            map.put(data[i], i);
        }
    }
}
