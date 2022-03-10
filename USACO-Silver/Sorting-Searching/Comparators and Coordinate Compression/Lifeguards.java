/**
 * USACO 2018 January Contest, Silver
 * Problem 1. Lifeguards
 */
import java.util.*;
import java.lang.*;
import java.io.*;
class Interval {
    public int s, f;
    public Interval(int s, int f) {
        this.s = s;
        this.f = f;
    }
}
public class Lifeguards {
    static Interval[] t;
    static int N;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        t = new Interval[N];
        for (int i = 0; i < N; i++) {
            t[i] = new Interval(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(t, new Comparator<Interval>() {
            public int compare(Interval one, Interval two) {
                return one.s - two.s;
            }
        });
        int tt = t[0].f - t[0].s; 
        int st = t[0].s;
        int ft = t[0].f;
        int mt = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            Interval cur = t[i];
            ft = Math.max(ft, cur.f);
            mt = Math.max(mt, 0);
            if (ft >= cur.s) {
                mt = Math.min(mt, cur.f - ft);
                continue;
            }
            else {
                tt += ft - st;
                st = cur.s;
                mt = Math.min(mt, cur.f - cur.s);
            }

        }
        tt += ft - st;
        System.out.println(tt - mt);
    }
}