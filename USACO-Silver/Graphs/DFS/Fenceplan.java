/**
 * USACO 2019 US Open Contest, Silver
 * Problem 3. Fence Planning
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class Fenceplan {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int[] x;
    static int[] y;
    static boolean[] visited;
    static int N;
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("fenceplan.in"));
        PrintWriter pw = new PrintWriter("fenceplan.out");
        N = scan.nextInt();
        int M = scan.nextInt();
        x = new int[N];
        y = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) { 
            x[i] = scan.nextInt()-1;
            y[i] = scan.nextInt()-1;
        }
        for (int i = 0; i < M; i++) {
            int a = scan.nextInt()-1;
            int b = scan.nextInt()-1;
            g.get(a).add(b);
            g.get(b).add(a);
        }
        int i = 0; 
        int C = Integer.MAX_VALUE;
        while (i < N) {
            if (!visited[i]) C = Math.min(C, c(i));
            i++;
        }
        pw.println(C);
        scan.close();
        pw.close();
    }
    static int c(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        int maxX, maxY, minX, minY;
        maxX = minX = x[k];
        maxY = minY = y[k];
        visited[k] = true;
        while (!q.isEmpty()) {
            int cow = q.poll();
            maxX = Math.max(maxX, x[cow]);
            minX = Math.min(minX, x[cow]);
            maxY = Math.max(maxY, y[cow]);
            minY = Math.min(minY, y[cow]);
            ArrayList<Integer> e = g.get(cow);
            for (int i = 0; i < e.size(); i++) {
                int nei = e.get(i);
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return 2 * ((maxX - minX) + (maxY - minY));
    }
}