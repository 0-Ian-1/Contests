/*
USACO 2016 January Contest, Bronze
Problem 3. Mowing the Field

SAMPLE INPUT:
6
N 10
E 2
S 3
W 4
S 5
E 8
SAMPLE OUTPUT:
10

submission
1   07/10    did not consider the case that no loop occured
2   10/10
*/

import java.util.*;
import java.io.*;
public class MowingTheField {
    static int[][] t = new int[2000][2000];
    static int time; 
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = 999;
        int y = 999;
        time = 0;
        int mint = 1001;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int dx = 0; int dy = 0;     // use dx dy so that there is no need to write separate
            if (d == 'N') dx = 1;       // for loops for each case. 
            else if (d == 'S') dx = -1;
            else if (d == 'W') dy = -1;
            else dy = 1; 
            for (int j = 0; j < s; j++) {
                x += dx;
                y += dy;
                time++;
                if (t[x][y] != 0) mint = Math.min(mint, time - t[x][y]);
                t[x][y] = time;
            }
        }
        if (mint != 1001) pw.println(mint);
        else pw.println("-1");
        pw.close();
    }
}
