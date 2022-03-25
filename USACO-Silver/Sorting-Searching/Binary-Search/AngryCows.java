/**
 * USACO 2016 January Contest, Silver
 * Problem 1. Angry Cows
 */
import java.util.*;
import java.io.*;
public class AngryCows {
    static int N, K;
    static int[] x;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        int r, lo, hi;
        lo = r = 0; hi = x[N-1];
        while (lo < hi) {
            r = (lo + hi) / 2;
            if (simulate(r)) hi = r-1;
            else lo = r+1;
        }
        System.out.println(r);
    }
    static boolean simulate(int r) {
        int index = 0;
        for (int i = 0; i < K; i++) {
            int cur = x[index];
            while (index < N && x[index] - cur < r * 2) {
                index++;
            }
            if (index >= N) return true;
        }
        return false;
    }
}