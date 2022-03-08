/**
 * USACO 2018 January Contest, Silver
 * Problem 1. Lifeguards
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class Lifeguards {
    static Interval[] t;
    static int N;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        t = new int[N];
        for (int i = 0; i < N; i++) {
            t[i] = new Interval(scan.nextInt(), scan.nextInt());
        }
        int[] s = new int[]
    }
    class Interval {
        public int s, f;
        public Interval(int s, int f) {
            this.s = s;
            this.f = f;
        }
    }
}