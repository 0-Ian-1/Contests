/*
USACO 2020 December Contest, Bronze
Problem 1. Do You Know Your ABCs?
*/
import java.io.*;
import java.util.*;
public class ABC {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[7];
        for (int i = 0; i < 7; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        /**
         * sort the array, the smallest two must be a and b while the
         * largest number must be a+b+c.
         */
        Arrays.sort(a);
        int A = a[0];
        int B = a[1];
        int C = a[6] - B - A;
        System.out.println(A + " " + B + " " + C);
    }
}
