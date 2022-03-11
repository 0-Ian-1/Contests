/**
 * USACO 2019 January Contest, Silver
 * Problem 2. Icy Perimeter
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class Perimeter {
    static int[][] g;
    static int N;
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        N = Integer.parseInt(scan.nextLine());
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '#') g[i][j] = 1;
            }
        }
        
    }
}