/**
 * USACO 2017 January Contest, Silver
 * Problem 2. Hoof, Paper, Scissors
 */
import java.io.*;
import java.util.*;
import java.lang.*;
public class hps {
    public static void main(String arg[]) throws Exception{
        Scanner scan = new Scanner(new File("hps.in"));
        int N = Integer.parseInt(scan.nextLine());
        //if bessies shows h, p, or s
        int[] h = new int[N];
        int[] p = new int[N];
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            String g = scan.nextLine();
            if (i==0) {
                if (g.equals("P")) s[0] = 1;
                else if (g.equals("S")) h[0] = 1;
                else p[0] = 1;
            }
            if (i > 0) {
                h[i] = h[i-1];
                p[i] = p[i-1];
                s[i] = s[i-1];
                if (g.equals("P")) s[i] = s[i-1] + 1;
                else if (g.equals("S")) h[i] = h[i-1] + 1;
                else p[i] = p[i-1] + 1;
            }
        }
        scan.close();
        int w = 0;
        for (int i = 0; i < N; i++) {
            int before = Math.max(h[i], Math.max(p[i], s[i]));
            int after = Math.max(h[N-1]-h[i], Math.max(p[N-1]-p[i], s[N-1]-s[i]));
            w = Math.max(w, before + after);
        }
        PrintWriter pw = new PrintWriter("hps.out");
        pw.println(w);
        pw.close();
    }
}