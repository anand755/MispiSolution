package my.exp;

import java.io.*;
import java.util.*;

public class AmznStrSubOr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] inputArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int[] resultArr = prepareAllOrArray(inputArr, arrLength);

            int queryLength = Integer.parseInt(reader.readLine());
            int[] queryArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            for (int idx : queryArr) {
                writer.write(resultArr[idx - 1] + " ");
            }
            writer.write("\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int[] prepareAllOrArray(int[] inputArr, int arrLength) {
        int resLength = (arrLength * (arrLength + 1)) / 2;
        int[] result = new int[resLength];
        int idx = 0;
        for (int s = 0; s < arrLength; s++) {
            int x = inputArr[s];
            result[idx++] = x;
            for (int e = s + 1; e < arrLength; e++) {
                x = x | inputArr[e];
                result[idx++] = x;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
