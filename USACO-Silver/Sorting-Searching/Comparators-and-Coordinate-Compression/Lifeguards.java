/**
 * USACO 2018 January Contest, Silver
 * Problem 1. Lifeguards
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class C implements Comparable<C> {
    public int s, f;
    public C(int s, int f) {
        this.s = s;
        this.f = f;
    }
    public int compareTo(C that) {
        return this.s - that.s;
    }
}
public class Lifeguards {
    static C[] t;
    static int N;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        t = new C[N * 2];
        for (int i = 0; i < N; i++) {
            t[i*2] = new C(scan.nextInt(), i);
            t[i*2+1] = new C(scan.nextInt(), i);
        }
        Arrays.sort(t);
        int alone[] = new int[N];
        int total = 0;
        int last = 0;
        int out = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < N * 2; i++) {
            if (ts.size() == 1) alone[ts.first()] += t[i].s - last;
            if (!ts.isEmpty()) total += t[i].s - last;
            if (ts.contains(t[i].f)) ts.remove(t[i].f);
            else ts.add(t[i].f);
            last = t[i].s;
        }
        for (int i = 0; i < N; i++) {
            out = Math.max(out, total - alone[i]);
        }
        System.out.println(out);
    }
}