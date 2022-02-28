/**
 * USACO 2016 US Open Contest, Silver
 * Problem 3. Closing the Farm
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class Closing {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int[] close;
    static boolean[] isClosed;
    static int N;
    public static void main (String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int M = scan.nextInt();
        isClosed = new boolean[N];
        for (int i = 0; i < N; i++) g.add(new ArrayList<Integer>());
        for (int i = 0; i < M; i++) {
            int a = scan.nextInt()-1;
            int b = scan.nextInt()-1;
            g.get(a).add(b);
            g.get(b).add(a);
        }
        close = new int[N];
        for (int i = 0; i < N; i++) {
            close[i] = scan.nextInt()-1;
            isClosed[i] = true;
            System.out.println(connected());
        }  
    }
    static boolean connected() {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(close[N-1]);
        visited[close[N-1]] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            ArrayList<Integer> e = g.get(node);
            for (int i = 0; i < e.size(); i++) {
                int nei = e.get(i);
                if (!visited[nei] && !isClosed[nei]) q.add(nei);
            }
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && !isClosed[i]) return false;
        }
        return true;
    }
}