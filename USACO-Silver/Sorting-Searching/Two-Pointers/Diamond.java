/**
 * USACO 2016 US Open Contest, Silver
 * Problem 2. Diamond Collector
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class Diamond {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("diamond.in"));
        PrintWriter pw = new PrintWriter("diamond.out");
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = scan.nextInt();
        }
        Arrays.sort(d);
        int i, j, l, r, max, max1, max2;
        i = j = l = r = max = max1 = max2 = 0;
        while (i < N && j < N) {
            if (d[j] - d[i] > K*2) {
                j++;
            }
            while (j < N && d[j] - d[i] <= K*2) j++;
            if (j - i > max) {
                max = j - i;
                l = i;
                r = j;
            }
            i++;
        }
        i = j = l = r = 0;
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
        i = j = l = r = max1;
        while (i < N && j < N) {
            if (d[j] - d[i] > K) {
                j++;
            }
            while (j < N && d[j] - d[i] <= K) j++;
            if (j - i > max2) {
                max2 = j - i;
                l = i;
                r = j;
            }
            i++;
        }
        pw.println(Math.max(max, max1 + max2));
        scan.close();
        pw.close();
    }
}