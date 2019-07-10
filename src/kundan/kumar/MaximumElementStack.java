package kundan.kumar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElementStack {

    static Stack<Integer> s1 = new Stack<Integer>();

    static Stack<Integer> s2 = new Stack<Integer>();


    public static void main(String[] args) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());

        //Scanner scanner = new Scanner(System.in);


        for (int i = 0; i <= testCases; i++) {

            String str = null;

            str = br.readLine();
            System.out.println("Entered number is " + str);
            String arr[] = str.split("\\s");

            int n1 = Integer.parseInt(arr[0]);

            int n2 = 0;

            if (arr.length > 1) {

                n2 = Integer.parseInt((arr[1]));
            }
            if (n1 == 1) {

                insert(n2);

            } else if (n1 == 3) {
                //int data = getMax();
                //System.out.println(data);
            } else {
                pop();
            }
        }
    }


    private static void pop() {

        System.out.print(s1.toString());

        System.out.println("***************");

        System.out.print(s2.toString());


        if (s1.isEmpty()) {

            if (s2.isEmpty()) {

                if (s1.peek() == s2.peek()) {

                    s1.pop();

                    s2.pop();

                } else {

                    s1.pop();

                }

            }

        }

    }

       /*private static int getMax() {
             int data = Integer.MIN_VALUE;
             if (!s2.isEmpty())
                    data = s2.peek();
             else {
                    if (!s1.isEmpty())
                          data = s1.peek();
             }
             return data;
       }
*/

    private static void insert(int data) {
        if (s1.isEmpty()) {
            s1.push(data);
            // s2.push(data);
        } else if (!s1.isEmpty()) {
            int val = s1.peek();
            if (data > val) {
                s1.push(data);
                s2.push(data);
            } else {
                s1.push(data);
            }
        }
    }
}
