import java.util.HashMap;
import java.util.Scanner;

class Main {
    private static void printMostFrequentWord(String[] words) {
        // write your code here
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        int maxCount = 0;
        String word = "";
        for (var key : map.keySet()) {
            if (map.get(key) > maxCount) {
                maxCount = map.get(key);
                word = key;
            }
        }
        System.out.println(word + " " + maxCount);
    }

    // don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        printMostFrequentWord(words);
    }
}