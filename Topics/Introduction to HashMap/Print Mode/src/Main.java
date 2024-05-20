import java.util.HashMap;
import java.util.Scanner;

class Main {
    private static void printMode( int[] map) {
        // Enter your Code Here
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i : map) {
            if (result.containsKey(i)) {
                result.put(i, result.get(i) + 1);
            } else {
                result.put(i, 1);
            }
        }
        int number = 0;
        int maxAppearances = 0;

        for (var entry : result.entrySet()) {
            if (entry.getValue() > maxAppearances) {
                number = entry.getKey();
                maxAppearances = entry.getValue();
            }
        }

        // Print the letter and its number of appearances
        System.out.println(number + " " + maxAppearances);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] map = new int [n];
        for (int i = 0; i < n; ++i) { 
            map[i] = scanner.nextInt();
        }

        printMode(map);
    }
}