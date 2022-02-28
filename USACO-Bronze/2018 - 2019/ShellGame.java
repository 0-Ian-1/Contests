/*
USACO 2019 January Contest, Bronze
Problem 1. Shell Game

SAMPLE INPUT:
3
1 2 1
3 2 1
1 3 1
SAMPLE OUTPUT:
2

submission
1   09/10
*/

import java.util.*;
import java.io.*;
public class ShellGame {
    static boolean[] p = new boolean[3];    // possible location of the pebble
    static int[][] s;                       // swap by bessie
    static int[] g;                         // guess by elsie
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = new int[n][3];
        g = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken())-1;
            s[i][1] = Integer.parseInt(st.nextToken())-1;
            g[i] = Integer.parseInt(st.nextToken())-1;
        }
        int count1 = 0; 
        p[0] = true;
        for (int i = 0; i < n; i++) {
            swap(s[i][0], s[i][1]);
            count1 += guess(g[i]);
        }
        int count2 = 0; 
        p[1] = true; p[0] = false;
        for (int i = 0; i < n; i++) {
            swap(s[i][0], s[i][1]);
            count2 += guess(g[i]);
        }
        int count3 = 0; 
        p[2] = true; p[1] = false;
        for (int i = 0; i < n; i++) {
            swap(s[i][0], s[i][1]);
            count3 += guess(g[i]);
        }
        pw.println(Math.max(count1, Math.max(count2, count3)));
        pw.close();
    }

    /**
     * simulate the process of the game, swap location i and j
     * @param i
     * @param j
     */
    static void swap(int i, int j) {
        boolean b = p[i];
        p[i] = p[j];
        p[j] = b;
    }

    /**
     * simulate guessing, if elsie guessed it right return 1.
     * @param g
     * @return
     */
    static int guess(int g) {
        if (p[g]) return 1;
        else return 0;
    }
}
