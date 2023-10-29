package sit.int202.jcfreview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemFour {
    public static void main(String[] args) {
        int mostInteger = 0;
        int mostValue = 0;
        List<Integer> position = new ArrayList<Integer>();
        int[] data = {8, 2, 3, 7, 8, 8, 7, 4, 7, 4, 4, 2, 2, 3, 8, 2, 7, 3, 3, 8};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (map.get(data[i]) == null) {
                map.put(data[i], 1);
            }else {
                int addValue = map.get(data[i]) + 1;
                map.replace(data[i], addValue);
            }
        }
        for (int number : map.keySet()) {
            if (map.get(number) >= mostValue) {
                mostInteger = number;
                mostValue = map.get(number);

            }
        }
        for (int i = 0; i < data.length; i++) {
            if (mostInteger == data[i]) {
                position.add(i);
            }
        }
        System.out.print(mostInteger + "(" + mostValue + ") : ");
        for (int pos : position) {
            System.out.print(pos + " ");
        }
        System.out.println();
    }
}
