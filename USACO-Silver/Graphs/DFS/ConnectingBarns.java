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
        for (int cases = 0; cases < T; i++) {
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
        }
    }
    static int
}