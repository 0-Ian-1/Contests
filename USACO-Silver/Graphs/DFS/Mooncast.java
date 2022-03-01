/**
 * USACO 2016 December Contest, Silver
 * Problem 3. Moocast
 */
import java.io.*;
import java.lang.*;
import java.util.*;
public class Mooncast {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int[] x;
    static int[] y;
    static int[] r;
    static int N;
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("moocast.in"));
        PrintWriter pw = new PrintWriter("moocast.out");
        N = scan.nextInt();
        x = new int[N];
        y = new int[N];
        r = new int[N];
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) { 
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            r[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (c(i, j)) g.get(i).add(j);
                if (c(j, i)) g.get(j).add(i);
            }
        }
        int count = -1;
        for (int i = 0; i < N; i++) {
            count = Math.max(count, count(i));
        }
        pw.println(count);
        scan.close();
        pw.close();
    }
    // check if i can reach j.
    static boolean c(int i, int j) {
        double d = Math.sqrt(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
        return d < r[i];
    }
    static int count(int k) {
        int count = 0;
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            ArrayList<Integer> e = g.get(node);
            for (int i = 0; i < e.size(); i++) {
                if (!visited[e.get(i)]) q.add(e.get(i));
            }
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) count++;
        }
        return count;
    }
}