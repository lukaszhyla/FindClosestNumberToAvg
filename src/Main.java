import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.println(findClosestNumberToAvg());
        }
    }

    private static int findClosestNumberToAvg() {
        int tableLength = scanner.nextInt();
        int[] table = getIntsFromUser(tableLength);
        double avg = calculateAvg(table);
        return calculateClosestNumber(table, avg);
    }

    private static int[] getIntsFromUser(int tableLength) {
        int[] table = new int[tableLength];
        for (int i = 0; i < tableLength; i++) {
            table[i] = scanner.nextInt();
        }
        return table;
    }

    private static double calculateAvg(int[] table) {
        double sum = 0;
        for (int i = 0; i < table.length; i++) {
            sum += table[i];
        }
        double avg = sum / (double) table.length;
        return avg;
    }

    private static int calculateClosestNumber(int[] table, double avg) {
        double currentClosestDifference = 10000;
        int indexOfClosestNum = 0;
        double difference;

        for (int i = 0; i < table.length; i++) {
            difference = avg - (double) table[i];
            if (difference < 0.0) {
                difference = difference * -1;
            }

            if (difference < currentClosestDifference) {
                currentClosestDifference = difference;
                indexOfClosestNum = i;
            }
        }
        return table[indexOfClosestNum];
    }
}
