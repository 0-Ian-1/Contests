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
        BufferedReader br = new BufferedReader(InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        while ()
    }
    static boolean simulate(int r) {
        int index = 0;
        for (int i = 0; i < K; i++) {
            int cur = x[index];
            while (x[index] - cur < r * 2) {
                index++;
            }
        }
        return index >= N;
    }
}