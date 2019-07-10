package scores.bin;

import java.util.Scanner;

public class HistogramDriver {
    public static void main(String[] args) {
        System.out.println("Enter Number of over followed by scores in each over");

        Histogram histogram = new Histogram();

        Scanner scanner = new Scanner(System.in);
        int overCount = scanner.nextInt();
        for (int i = 0; i < overCount; i++) {
            int score = scanner.nextInt();
            histogram.AddScore(score);
        }

        histogram.DisplayHistogram();
    }
}
