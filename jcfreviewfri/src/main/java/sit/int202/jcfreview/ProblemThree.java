package sit.int202.jcfreview;

import java.io.*;
import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        List<String> textList = new ArrayList<>();
        Map<String, Integer> textCount = new HashMap<>();
        String text;
        try {
            File file = new File("Example.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((text = reader.readLine()) != null) {
                textList = Arrays.stream(text.split(" ")).toList();
            }
            for (int i = 0; i < textList.size(); i++) {
                if (textCount.get(textList.get(i)) == null) {
                    textCount.put(textList.get(i), 1);
                } else {
                    int countRepeat = textCount.get(textList.get(i)) + 1;
                    textCount.replace(textList.get(i), countRepeat);
                }
            }
            List<Map.Entry<String, Integer>> sortedTextCount = new ArrayList<>(textCount.entrySet());
            sortedTextCount.sort(Comparator.comparingInt(Map.Entry::getValue));
            for (Map.Entry<String, Integer> entry : sortedTextCount) {
                System.out.print(entry.getKey() + "(" + entry.getValue() + ") : ");
                for (int i = 0; i < textList.size(); i++) {
                    if (entry.getKey().equals(textList.get(i))) {
                        System.out.print("@" + i + " ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
