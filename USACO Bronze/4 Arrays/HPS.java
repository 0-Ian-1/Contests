/*
USACO 2017 January Contest, Bronze
Problem 2. Hoof, Paper, Scissors

SAMPLE INPUT:
5
1 2
2 2
1 3
1 1
3 2
SAMPLE OUTPUT:
2

Note, better logic: 
1. this is a simulation problem. 
2. catch the game rule and count the wins
3. use 2D array to store the data:
    int[][] a = new int[4][4], storing 1, 2, or 3 gestures.
    a[i][j] - gesture i for cow1, gesture j for cow2 (1 <= i & j <= 3)
    store each line of input int cow1, int cow2 to a[cow1][cow2]
4. compare the following rules: 
    1 beats 2 beats 3, count a[1][2] + a[2][3] + a[3][1]
    1 beats 3 beats 2, count a[1][3] + a[3][2] + a[2][1]
*/

import java.util.*;
import java.io.*;

public class HPS {
    static int n;
    static int[] one;
    static int[] two;
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        n = Integer.parseInt(st.nextToken());
        one = new int[n];
        two = new int[n];
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            one[i] = Integer.parseInt(st.nextToken());
            two[i] = Integer.parseInt(st.nextToken());
        }
        int count = Math.max(Math.max(Math.max(hps(1, 2, 3), hps(1, 3, 2)), 0), Math.max(Math.max(hps(2, 1, 3), hps(2, 3, 1)), Math.max(hps(3, 1, 2), hps(3, 2, 1))));
        pw.println(count);
        pw.close();
    }

    public static int hps(int a, int b, int c)                          // let game rule be: a beats b, b beats c, c beats a
    {
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if ((one[i] == a && two[i] == b) || (one[i] == b && two[i] == c) || (one[i] == c && two[i] == a)) count++;
        }
        return count;
    }
}
