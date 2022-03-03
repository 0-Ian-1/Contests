/**
 * USACO 2021 December Contest, Silver
 * Problem 2. Connecting Two Barns
 */
import java.util.*;
public class ConnectingBarns {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int N;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int cases = 0; cases < T; cases++) {
            N = scan.nextInt();
            int M = scan.nextInt();
            for (int i = 0; i < N; i++) {
                g.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; i++) {
                int a = scan.nextInt()-1;
                int b = scan.nextInt()-1;
                g.get(a).add(b);
                g.get(b).add(a);
            }
            int X1, X2, x1, x2;
            X1 = X2 = 0;
            x1 = x2 = Integer.MAX_VALUE;
            ArrayList<Integer> start = c(0);
            ArrayList<Integer> end = c(N-1);
            for (int i = 0; i < start.size(); i++) {
                X1 = Math.max(X1, start.get(i));
                x1 = Math.min(x1, start.get(i));
            }
            for (int i = 0; i < end.size(); i++) {
                X2 = Math.max(X2, end.get(i));
                x2 = Math.min(x2, end.get(i));
            }
            System.out.println(Math.min(Math.abs(X2-x1), Math.abs(X1-x2)));
        }
    }
    static ArrayList<Integer> c(int k) {
        boolean[] visited = new boolean[N];
        ArrayList<Integer> c = new ArrayList<>();
        c.add(k);
        visited[k] = true;
        int n = 0;
        while (n < c.size()) {
            int node = c.get(n);
            ArrayList<Integer> e = g.get(node);
            for (int i = 0; i < e.size(); i++) {
                if (!visited[e.get(i)]) {
                    c.add(e.get(i));
                    visited[e.get(i)] = true;
                }
            }
            n++;
        }
        return c;
    }
}