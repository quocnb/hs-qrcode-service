import java.util.*;

class Main {
    private static void printCommon(int[] firstArray, int[] secondArray) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : firstArray) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through the second array to find common elements
        List<Integer> intersection = new ArrayList<>();
        for (int num : secondArray) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Sort the intersection in ascending order
        Collections.sort(intersection);

        // Print the intersection
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] firstArray = new int [n];
        int[] secondArray = new int [n];
        for (int i = 0; i < n; ++i) { 
            firstArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; ++i) { 
            secondArray[i] = scanner.nextInt();
        }

        printCommon(firstArray,secondArray);
    }
}