package my.exp;

import java.io.*;
import java.util.*;

public class AmznStrChan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int charLength = Integer.parseInt(reader.readLine());
        char[] charArr = reader.readLine().trim().toCharArray();
        Map<Character, List<Integer>> map = prepareMap(charArr, charLength);
        int queryCount = Integer.parseInt(reader.readLine());
        int[] queryArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        for (int k : queryArr) {
            int ans = getSimilaryVal(map, k);
            writer.write(ans + " ");
        }
        writer.write("\n");
        writer.flush();
    }

    private static int getSimilaryVal(Map<Character, List<Integer>> map, int k) {
        int ans = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            //char key = entry.getKey();
            List<Integer> valList = entry.getValue();
            int currAns = getAns(valList, k);
            ans = Math.max(ans, currAns);
        }
        return ans;
    }

    private static int getAns(List<Integer> valList, int k) {
        valList.sort(Collections.reverseOrder());
        int count = 0;
        int idx = 0;
        while (idx < valList.size() && idx <= k) {
            count += valList.get(idx);
            idx++;
        }
        return count;
    }

    private static Map<Character, List<Integer>> prepareMap(char[] charArr, int charLength) {
        int idx = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        while (idx < charLength) {
            char currChar = charArr[idx++];
            int currCount = 1;
            while (idx < charLength && charArr[idx] == currChar) {
                currCount++;
                idx++;
            }
            List<Integer> list = map.getOrDefault(currChar, new ArrayList<>());
            list.add(currCount);
            map.put(currChar, list);
        }
        return map;
    }
}
