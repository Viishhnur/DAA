import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci {
    // To store Fibonacci series
    static ArrayList<Integer> fibSeries = new ArrayList<>();

    private static void fibonacci(int n) {
        // Base cases
        if (n >= 1) {
            fibSeries.add(0);
        }
        if (n >= 2) {
            fibSeries.add(1);
        }

        // Calculate the rest of the series
        for (int i = 2; i < n; i++) {
            int nextValue = fibSeries.get(i - 1) + fibSeries.get(i - 2);
            fibSeries.add(nextValue);
        }

        // Print the series
        for (int i = 0; i < fibSeries.size(); i++) {
            System.out.print(fibSeries.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Read the number of terms
        fibonacci(n);          // Generate and print Fibonacci series
        sc.close();
    }
}
