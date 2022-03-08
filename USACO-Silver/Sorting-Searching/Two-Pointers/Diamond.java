/**
 * USACO 2016 US Open Contest, Silver
 * Problem 2. Diamond Collector
 * submission: 8/10
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class Diamond {
    static int[] d;
    static int N;
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("diamond.in"));
        PrintWriter pw = new PrintWriter("diamond.out");
        N = scan.nextInt();
        int K = scan.nextInt();
        d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = scan.nextInt();
        }
        Arrays.sort(d);
        int i, j, l, r, max, max1, max2;
        i = j = l = r = 0;
        max = max1 = max2 = 1;
        max = max(K * 2);
        while (i < N && j < N) {
            if (d[j] - d[i] > K) {
                j++;
            }
            while (j < N && d[j] - d[i] <= K) j++;
            if (j - i > max1) {
                max1 = j - i;
                l = i;
                r = j;
            }
            i++;
        }
        for (int index = l; index < r; index++) {
            d[index] = -1;
        }
        Arrays.sort(d);
        max2 = max(K);
        pw.println(Math.max(max, max1 + max2));
        scan.close();
        pw.close();
    }
    static int max(int K) {
        int i, j, max;
        i = j = max = 0;
        while (d[i] == -1) {i++; j++;}
        while (i < N && j < N) {
            if (d[j] - d[i] > K) {
                j++;
            }
            while (j < N && d[j] - d[i] <= K) j++;
            max = Math.max(max, j - i);
            i++;
        }
        return max;
    }
}