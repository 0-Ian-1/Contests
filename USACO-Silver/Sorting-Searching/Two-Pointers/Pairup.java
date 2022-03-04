/**
 * USACO 2017 US Open Contest, Silver
 * Problem 1. Paired Up
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class Pairup {
    static Cow[] cow;
    static int N;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        cow = new Cow[N];
        for (int i = 0; i < N; i++) {
            int c = scan.nextInt();
            int t = scan.nextInt();
            cow[i] = new Cow(c, t);
        }
        Arrays.sort(cow);
        int count = 0;
        int l = 0;
        int r = N-1;
        while (l <= r) {
            int pair = Math.min(cow[l].c, cow[r].c);
            if (l == r) pair /= 2;
            count = Math.max(count, cow[l].t + cow[r].t);
            cow[l].c -= pair;
            cow[r].c -= pair;
            if (cow[l].c == 0) l++;
            if (cow[r].c == 0) r--; 
        }
        System.out.println(count);
    }
}
class Cow implements Comparable<Cow> {
    public int c, t;
    public Cow(int c, int t) {
        this.c = c; 
        this.t = t;
    }
    public int compareTo(Cow that) {
        return this.t - that.t;
    }
}