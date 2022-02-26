import java.io.*;
import java.lang.*;
import java.util.*;
public class Lunch {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] P = new int[N];
        int[] W = new int[N];
        int[] D = new int[N];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            P[i] = scan.nextInt();
            W[i] = scan.nextInt();
            D[i] = scan.nextInt();
            max = Math.max(max, P[i]);
            min = Math.min(min, P[i]);
        }
        int lo = min;
        int hi = max;
        int mid = 0;
        while (hi > lo) {
            mid = (hi + lo)/2;
            long t1 = sumT(P, W, D, mid);
            long t2 = sumT(P, W, D, mid + 1);
            long t0 = sumT(P, W, D, mid-1);
            if (t0 <= t1 && t1 <= t2) hi = mid - 1;
            else if (t0 >= t1 && t1 >= t2) lo = mid + 1;
            else break;
        }
        System.out.println(sumT(P, W, D, mid));
    }
    static long sumT(int[] p, int[] w, int[] d, int q) {
        long time = 0;
        for (int i = 0; i < p.length; i++) {
            int dis = Math.abs(p[i] - q);
            if (dis > d[i]) {
                dis -= d[i];
                time += dis * w[i];
            }
        }
        return time;
    }
}
